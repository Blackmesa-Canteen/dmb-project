package com.example.dynamic_menu_builder.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * User entity
 */
@TableName("t_user")
@ApiModel(value = "User", description = "User entity")
public class User extends BaseEntity{

    @TableField(value = "username")
    @ApiModelProperty(value = "username for login", example = "admin@example.com")
    private String username;

    @TableField(value = "password")
    @ApiModelProperty(value = "password cypher", example = "some cypher")
    private String password;

    @TableField(value = "role_id")
    @ApiModelProperty(value = "role id", example = "1")
    private Long roleId;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
