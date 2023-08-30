package com.example.dynamic_menu_builder.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Parameters required for creating a menu.")
public class CreateMenuParam {

    @ApiModelProperty(value = "Name of the menu", required = true, example = "MENU_1")
    @NotNull(message = "menu name cannot be null")
    String name;

    @ApiModelProperty(value = "Name of the parent menu", required = false, example = "MENU_1")
    String parentName;

    @ApiModelProperty(value = "Name of the permission required to access this menu",
            required = false, example = "PERMISSION_1")
    String permissionNameRequired;

    @ApiModelProperty(value = "Name of the system control required to access this menu",
            required = false, example = "SYSTEM_CONTROL_1")
    String systemControlNameRequired;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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
