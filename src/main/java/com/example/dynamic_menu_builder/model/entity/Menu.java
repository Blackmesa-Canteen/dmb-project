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

    @TableField(value = "parent_id")
    @ApiModelProperty(value = "ID of the parent menu item (null for root menu)", example = "1")
    private Long parentId;

    @TableField(value = "permission_name_required")
    @ApiModelProperty(value = "Permission required to view menu", example = "PERMISSION_6")
    private String permissionNameRequired;

    @TableField(value = "system_control_name_required")
    @ApiModelProperty(value = "System control name for the menu", example = "SYSTEM_CONTROL_2")
    private String systemControlNameRequired;

    public Menu() {
    }

    public Menu(String name, Long parentId, String permissionNameRequired, String systemControlNameRequired) {
        this.name = name;
        this.parentId = parentId;
        this.permissionNameRequired = permissionNameRequired;
        this.systemControlNameRequired = systemControlNameRequired;
    }

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSystemControlNameRequired() {
        return systemControlNameRequired;
    }

    public void setSystemControlNameRequired(String systemControlNameRequired) {
        this.systemControlNameRequired = systemControlNameRequired;
    }
}
