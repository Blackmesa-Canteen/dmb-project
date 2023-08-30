package com.example.dynamic_menu_builder.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Menu entity
 */
@TableName("t_menu")
@ApiModel(value = "Menu", description = "Menu entity")
public class Menu extends BaseEntity {

    @TableField(value = "name")
    @ApiModelProperty(value = "Name of the menu item", example = "menu_1")
    private String name;

    @TableField(value = "level")
    @ApiModelProperty(value = "Level of the menu item (1 for main menu, 2 for submenu)", example = "1")
    private Integer level;

    @TableField(value = "parent_id")
    @ApiModelProperty(value = "ID of the parent menu item (null for level 1 items)", example = "1")
    private Long parentId;

    @TableField(value = "permission_name_required")
    @ApiModelProperty(value = "Permission required to view menu", example = "PERMISSION_6")
    private String permissionNameRequired;

    @TableField(value = "system_name_required")
    @ApiModelProperty(value = "System status dependency for the menu", example = "SYSTEM_CONTROL_2")
    private String systemNameRequired;

    public Menu() {
    }

    public Menu(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPermissionNameRequired() {
        return permissionNameRequired;
    }

    public void setPermissionNameRequired(String permissionNameRequired) {
        this.permissionNameRequired = permissionNameRequired;
    }

    public String getSystemNameRequired() {
        return systemNameRequired;
    }

    public void setSystemNameRequired(String systemNameRequired) {
        this.systemNameRequired = systemNameRequired;
    }
}
