package com.example.dynamic_menu_builder.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RolePermission", description = "Role Permission associated entity")
@TableName("t_role_permission")
public class RolePermission extends BaseEntity {

    @ApiModelProperty(value = "role id", example = "1")
    @TableField(value = "role_id")
    private Long roleId;

    @ApiModelProperty(value = "permission id", example = "1")
    @TableField(value = "permission_id")
    private Long permissionId;

    public RolePermission() {
    }

    public RolePermission(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
