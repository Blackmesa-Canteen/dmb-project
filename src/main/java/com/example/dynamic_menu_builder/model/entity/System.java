package com.example.dynamic_menu_builder.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * system entity
 */

@TableName("t_system")
@ApiModel(value = "System", description = "System entity")
public class System extends BaseEntity{

    @TableField(value = "name")
    @ApiModelProperty(value = "Name of the system", example = "SYSTEM_CONTROL_1")
    private String name;

    @TableField(value = "status")
    @ApiModelProperty(value = "Status of the system", example = "true")
    private Boolean status;

    public System() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
