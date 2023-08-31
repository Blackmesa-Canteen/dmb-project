package com.example.dynamic_menu_builder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic_menu_builder.mapper.RolePermissionMapper;
import com.example.dynamic_menu_builder.model.entity.RolePermission;
import com.example.dynamic_menu_builder.service.IRolePermissionService;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionService extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {
}
