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
    @ApiModelProperty(value = "Name of the permission", example = "PERMISSION_6")
    private String name;

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
}
