package com.example.dynamic_menu_builder.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Permission entity
 */
@TableName("t_permission")
@ApiModel(value = "Permission", description = "Permission entity")
public class Permission extends BaseEntity {

    @TableField(value = "name")
    @ApiModelProperty(value = "Name of the permission", example = "READ")
    private String name;

    @TableField(value = "description")
    @ApiModelProperty(value = "Description of the permission", example = "Allows read access")
    private String description;

    @TableField(value = "role_id")
    @ApiModelProperty(value = "role id", example = "1")
    private Long roleId;

    public Permission() {
    }

    public Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
