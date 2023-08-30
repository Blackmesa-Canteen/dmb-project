package com.example.dynamic_menu_builder.model.param;

import jakarta.validation.constraints.NotNull;

public class CreateMenuParam {

    @NotNull(message = "menu name cannot be null")
    String name;

    String parentName;

    String permissionNameRequired;

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
