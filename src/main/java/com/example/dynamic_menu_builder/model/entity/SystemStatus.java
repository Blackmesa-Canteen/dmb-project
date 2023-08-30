package com.example.dynamic_menu_builder.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * system entity
 */

@TableName("t_system_status")
@ApiModel(value = "System Status", description = "System Status entity")
public class SystemStatus extends BaseEntity{

    @TableField(value = "name")
    @ApiModelProperty(value = "Name of the system status", example = "SYSTEM_CONTROL_1")
    private String name;

    @TableField(value = "status")
    @ApiModelProperty(value = "Status of the system", example = "true")
    private Boolean status;

    public SystemStatus() {
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
