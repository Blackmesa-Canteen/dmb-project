package com.example.dynamic_menu_builder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dynamic_menu_builder.exception.DuplicatedDataException;
import com.example.dynamic_menu_builder.model.entity.Role;

import java.util.List;

public interface IRoleService extends IService<Role> {

    /**
     * Create role by name
     * @param name role name
     * @exception RuntimeException if create permission failed
     * @exception DuplicatedDataException if permission name already exists
     * @since 08/30/2023
     */
    void createRoleByName(String name);

    /**
     * Create role by name batch
     * @param names role names
     * @exception RuntimeException if create permission batch failed
     * @since 08/30/2023
     */
    void crateRoleByNameBatch(List<String> names);
}
