package com.example.dynamic_menu_builder.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Role entity
 */
@TableName("t_role")
@ApiModel(value = "Role", description = "Role entity")
public class Role extends BaseEntity {

    @TableField(value = "name")
    @ApiModelProperty(value = "Name of the role", example = "User")
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
