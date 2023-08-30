package com.example.dynamic_menu_builder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dynamic_menu_builder.exception.DuplicatedDataException;
import com.example.dynamic_menu_builder.model.entity.Permission;

import java.util.List;

public interface IPermissionService extends IService<Permission> {

    /**
     * Create permission by name
     * @param name permission name
     * @exception RuntimeException if create permission failed
     * @exception DuplicatedDataException if permission name already exists
     * @since 08/09/2021
     */
    void createPermissionByName(String name);

    /**
     * Create permission by name batch
     * @param names permission names
     * @exception RuntimeException if create permission batch failed
     * @since 08/09/2021
     */
    void createPermissionByNameBatch(List<String> names);
}
