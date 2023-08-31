package com.example.dynamic_menu_builder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dynamic_menu_builder.model.dto.MenuDTO;
import com.example.dynamic_menu_builder.model.entity.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {

    /**
     * Create menu
     * @param name menu name
     * @param parentMenuName parent menu name
     * @param permissionNameRequired permission name required
     * @param systemControlNameRequired system control name required
     */
    void createMenu(String name, String parentMenuName, String permissionNameRequired, String systemControlNameRequired);

    /**
     * Query menu structure by role id
     * @param roleId role id
     * @return menu structure list
     */
    List<MenuDTO> queryMenuStructureByRoleId(Long roleId);
}
