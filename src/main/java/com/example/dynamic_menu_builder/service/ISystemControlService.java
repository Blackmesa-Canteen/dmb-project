package com.example.dynamic_menu_builder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dynamic_menu_builder.model.entity.SystemControl;

import java.util.Map;

public interface ISystemControlService extends IService<SystemControl> {

    /**
     * Create system control
     * @param name system control name
     * @param status system control status
     * @since 08/30/2023
     */
    void createSystemControl(String name, Boolean status);

    /**
     * Toggle system control status
     * @param systemControlStatusMap system control status map
     */
    void toggleSystemControlStatus(Map<String, Boolean> systemControlStatusMap);
}
