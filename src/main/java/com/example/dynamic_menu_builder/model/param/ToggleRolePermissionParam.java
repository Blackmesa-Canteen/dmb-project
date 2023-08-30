package com.example.dynamic_menu_builder.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@ApiModel(description = "Parameters required for toggling role permission.")
public class ToggleRolePermissionParam {

    @NotNull(message = "role id cannot be null")
    @ApiModelProperty(value = "Role id", required = true, example = "1")
    Long roleId;

    @ApiModelProperty(value = "Permission list", required = true,
            example = "[\"PERMISSION_2\",\"PERMISSION_3\"]")
    @NotNull(message = "permission list cannot be null")
    List<String> permissionList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<String> permissionList) {
        this.permissionList = permissionList;
    }
}
