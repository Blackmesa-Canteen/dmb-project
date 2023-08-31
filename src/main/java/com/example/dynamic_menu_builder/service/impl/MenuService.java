package com.example.dynamic_menu_builder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic_menu_builder.exception.BadRequestException;
import com.example.dynamic_menu_builder.exception.DuplicatedDataException;
import com.example.dynamic_menu_builder.exception.NotFoundException;
import com.example.dynamic_menu_builder.mapper.*;
import com.example.dynamic_menu_builder.model.dto.MenuDTO;
import com.example.dynamic_menu_builder.model.dto.SubMenuDTO;
import com.example.dynamic_menu_builder.model.entity.*;
import com.example.dynamic_menu_builder.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuService extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    private final MenuMapper menuMapper;

    private final SystemControlMapper systemControlMapper;

    private final RoleMapper roleMapper;

    private final PermissionMapper permissionMapper;

    private final RolePermissionMapper rolePermissionMapper;

    public MenuService(MenuMapper menuMapper, SystemControlMapper systemControlMapper,
                       RoleMapper roleMapper, PermissionMapper permissionMapper,
                       RolePermissionMapper rolePermissionMapper) {
        this.menuMapper = menuMapper;
        this.systemControlMapper = systemControlMapper;
        this.roleMapper = roleMapper;
        this.permissionMapper = permissionMapper;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public void createMenu(String name, String parentMenuName, String permissionNameRequired, String systemControlNameRequired) {
        // if parent menu name is null, then it is a root menu,
        // so permission name required and system control name required should be null
        if (parentMenuName == null) {
            if (permissionNameRequired != null || systemControlNameRequired != null) {
                throw new BadRequestException(
                        "Root menu should not have permission name required or system control name required"
                );
            }
        }

        // check if name exists
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        boolean exists = menuMapper.exists(queryWrapper);
        if (exists) {
            throw new DuplicatedDataException("Menu name already exists");
        }

        // check if permission name exists
        if (permissionNameRequired != null) {
            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", permissionNameRequired);
            exists = menuMapper.exists(queryWrapper);
            if (!exists) {
                throw new NotFoundException("Permission name not found: " + permissionNameRequired);
            }
        }

        // check if system control name exists
        if (systemControlNameRequired != null) {
            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", systemControlNameRequired);
            exists = menuMapper.exists(queryWrapper);
            if (!exists) {
                throw new NotFoundException("System control name not found: " + systemControlNameRequired);
            }
        }

        // check if parent menu name exists
        Long parentMenuId = null;
        if (parentMenuName != null) {
            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", parentMenuName);
            Menu menu = menuMapper.selectOne(queryWrapper);
            if (menu == null) {
                throw new NotFoundException("Parent menu name not found: " + parentMenuName);
            }
            parentMenuId = menu.getId();
        }

        Menu menu = new Menu(name, parentMenuId, permissionNameRequired, systemControlNameRequired);
        menuMapper.insert(menu);
    }

    @Override
    public List<MenuDTO> queryMenuStructureByRoleId(Long roleId) {
        // check role exists
        Role role = roleMapper.selectById(roleId);
        if (role == null) {
            throw new NotFoundException("Role not found: " + roleId);
        }

        // get permission names of the role
        QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectList(queryWrapper);
        List<Permission> permissions = permissionMapper.selectBatchIds(
                rolePermissions.stream().map(RolePermission::getPermissionId).toList()
        );
        List<String> permissionNames = permissions.stream().map(Permission::getName).toList();

        // get all sub-menus with permission name required in permission names
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.in("permission_name_required", permissionNames);
        List<Menu> subMenus = menuMapper.selectList(menuQueryWrapper);

        // filter valid submenus: systemControlNameRequired map to a SystemControl with status true
        List<Menu> validSubMenus = subMenus.stream().filter(
                subMenu -> {
                    String systemControlNameRequired = subMenu.getSystemControlNameRequired();
                    // if systemControlNameRequired isn't given for a Level 2 menu item, treat it as true.
                    if (systemControlNameRequired == null) {
                        return true;
                    }

                    QueryWrapper<SystemControl> systemControlQueryWrapper = new QueryWrapper<>();
                    systemControlQueryWrapper.eq("name", systemControlNameRequired);
                    SystemControl systemControl = systemControlMapper.selectOne(systemControlQueryWrapper);

                    // systemControl status should be true
                    return systemControl != null && systemControl.getStatus();
                }
        ).toList();

        // get all root Menus
        Map<Menu, MenuDTO> rootMenuDTOMap = new HashMap<>();
        for (Menu validSubMenu : validSubMenus) {
            // since there are only 2 levels, so we can get root menu from sub menu
            Long parenMenuId = validSubMenu.getParentId();
            Menu rootMenu = menuMapper.selectById(parenMenuId);

            // init sut menu dto
            SubMenuDTO subMenuDTO = new SubMenuDTO();
            subMenuDTO.setName(validSubMenu.getName());
            subMenuDTO.setPermission(validSubMenu.getPermissionNameRequired());
            subMenuDTO.setSystemControl(validSubMenu.getSystemControlNameRequired());


            if (!rootMenuDTOMap.containsKey(rootMenu)) {
                // if the root menu is firstly occurred, then init it
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setName(rootMenu.getName());

                // init a new sub menu dto list, add sub menu dto to it
                List<SubMenuDTO> subMenuDTOS = new ArrayList<>();
                subMenuDTOS.add(subMenuDTO);
                menuDTO.setSubMenus(subMenuDTOS);

                // add it to map
                rootMenuDTOMap.put(rootMenu, menuDTO);
            } else {
                // just get the root menu dto from map, then add sub menu dto to it
                MenuDTO menuDTO = rootMenuDTOMap.get(rootMenu);
                menuDTO.getSubMenus().add(subMenuDTO);
                // sort sub menu list by name
                menuDTO.getSubMenus().sort(Comparator.comparing(SubMenuDTO::getName));
            }
        }

        // return root menu dto list, and also sorted by name
        List<MenuDTO> menuDTOList = new ArrayList<>(rootMenuDTOMap.values());
        menuDTOList.sort(Comparator.comparing(MenuDTO::getName));
        return menuDTOList;
    }
}
