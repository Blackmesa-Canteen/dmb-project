package com.example.dynamic_menu_builder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic_menu_builder.exception.DuplicatedDataException;
import com.example.dynamic_menu_builder.mapper.PermissionMapper;
import com.example.dynamic_menu_builder.model.entity.Permission;
import com.example.dynamic_menu_builder.service.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    private final PermissionMapper permissionMapper;

    public PermissionService(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    public void createPermissionByName(String name) {
        // check if name exists
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        boolean exists = permissionMapper.exists(queryWrapper);
        if (exists) {
            throw new DuplicatedDataException("Permission name already exists");
        }

        permissionMapper.insert(new Permission(name));
    }

    public void createPermissionByNameBatch(List<String> names) {
        List<Permission> permissions = new LinkedList<>();
        for (String name : names) {
            permissions.add(new Permission(name));
        }

        boolean res = saveBatch(permissions);
        if (!res) {
            throw new RuntimeException("Create permission batch failed");
        }
    }

}
