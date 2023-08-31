package com.example.dynamic_menu_builder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic_menu_builder.exception.BadRequestException;
import com.example.dynamic_menu_builder.exception.DuplicatedDataException;
import com.example.dynamic_menu_builder.exception.NotFoundException;
import com.example.dynamic_menu_builder.mapper.PermissionMapper;
import com.example.dynamic_menu_builder.mapper.RoleMapper;
import com.example.dynamic_menu_builder.mapper.RolePermissionMapper;
import com.example.dynamic_menu_builder.model.entity.Permission;
import com.example.dynamic_menu_builder.model.entity.Role;
import com.example.dynamic_menu_builder.model.entity.RolePermission;
import com.example.dynamic_menu_builder.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    private final RoleMapper roleMapper;

    private final RolePermissionMapper rolePermissionMapper;

    private final PermissionMapper permissionMapper;

    public RoleService(RoleMapper roleMapper, RolePermissionMapper rolePermissionMapper, PermissionMapper permissionMapper) {
        this.roleMapper = roleMapper;
        this.rolePermissionMapper = rolePermissionMapper;
        this.permissionMapper = permissionMapper;
    }

    public void createRoleByName(String name) {
        // check if name exists
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        boolean exists = roleMapper.exists(queryWrapper);
        if (exists) {
            throw new DuplicatedDataException("Role name already exists");
        }
        roleMapper.insert(new Role(name));
    }

    public void crateRoleByNameBatch(List<String> names) {
        List<Role> roles = new LinkedList<>();
        for (String name : names) {
            roles.add(new Role(name));
        }

        boolean res = saveBatch(roles);
        if (!res) {
            throw new RuntimeException("Create role batch failed");
        }
    }

    @Override
    @Transactional
    public void enableRolePermission(Long roleId, List<String> permissionList) {
        // check if role exists
        Role role = roleMapper.selectById(roleId);
        if (role == null) {
            throw new BadRequestException("Role ID not exists: " + roleId);
        }

        for (String permissionName : permissionList) {
            // check if permission exists
            QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", permissionName);
            Permission permission = permissionMapper.selectOne(queryWrapper);
            if (permission == null) {
                throw new NotFoundException("Permission name not exists: " + permissionName);
            }

            // add the permission to associated table if not exists
            QueryWrapper<RolePermission> rolePermissionQueryWrapper = new QueryWrapper<>();
            rolePermissionQueryWrapper
                    .eq("role_id", roleId)
                    .and(wrapper -> wrapper.eq("permission_id", permission.getId()));
            boolean exists = rolePermissionMapper.exists(rolePermissionQueryWrapper);
            if (!exists) {
                // no need to use batch insert because the service is transactional already
                rolePermissionMapper.insert(new RolePermission(roleId, permission.getId()));
            }
        }
    }

    @Override
    @Transactional
    public void disableRolePermission(Long roleId, List<String> permissionList) {
        // check if role exists
        Role role = roleMapper.selectById(roleId);
        if (role == null) {
            throw new NotFoundException("Role ID not exists: " + roleId);
        }

        for (String permissionName : permissionList) {
            // check if permission exists
            QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", permissionName);
            Permission permission = permissionMapper.selectOne(queryWrapper);
            if (permission == null) {
                throw new NotFoundException("Permission name not exists: " + permissionName);
            }

            // delete the permission from associated table if exists
            QueryWrapper<RolePermission> rolePermissionQueryWrapper = new QueryWrapper<>();
            rolePermissionQueryWrapper
                    .eq("role_id", roleId)
                    .and(wrapper -> wrapper.eq("permission_id", permission.getId()));
            List<RolePermission> rolePermissions = rolePermissionMapper.selectList(rolePermissionQueryWrapper);

            rolePermissionMapper.deleteBatchIds(rolePermissions);
        }
    }

    @Override
    public List<String> getRolePermissionsByRoleId(Long roleId) {
        // check if role exists
        Role role = roleMapper.selectById(roleId);
        if (role == null) {
            throw new NotFoundException("Role ID not exists: " + roleId);
        }

        QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectList(queryWrapper);

        // get permission Ids
        List<Long> permissionIds = rolePermissions.stream()
                .map(RolePermission::getPermissionId)
                .collect(Collectors.toList());

        // get permissions based on permission Ids
        List<Permission> permissions = permissionMapper.selectBatchIds(permissionIds);

        // return permission names
        return permissions.stream()
                .map(Permission::getName)
                .collect(Collectors.toList());
    }
}
