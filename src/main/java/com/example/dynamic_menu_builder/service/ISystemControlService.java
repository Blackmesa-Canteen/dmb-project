package com.example.dynamic_menu_builder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dynamic_menu_builder.model.entity.SystemControl;

public interface ISystemControlService extends IService<SystemControl> {

    /**
     * Create system control by name
     * @param name system control name
     * @since 08/09/2021
     */
    void createSystemControlByName(String name, Boolean status);
}
