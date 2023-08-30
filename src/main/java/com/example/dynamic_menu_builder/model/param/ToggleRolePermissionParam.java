package com.example.dynamic_menu_builder.model.param;

import jakarta.validation.constraints.NotNull;

public class ToggleRolePermissionParam {

    @NotNull(message = "role name cannot be null")
    String roleName;

    @NotNull(message = "permission name cannot be null")
    String permissionName;

    @NotNull(message = "enable boolean cannot be null")
    Boolean enable;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
