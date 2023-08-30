package com.example.dynamic_menu_builder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic_menu_builder.exception.DuplicatedDataException;
import com.example.dynamic_menu_builder.mapper.RoleMapper;
import com.example.dynamic_menu_builder.model.entity.Role;
import com.example.dynamic_menu_builder.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    private final RoleMapper roleMapper;

    public RoleService(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
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
}
