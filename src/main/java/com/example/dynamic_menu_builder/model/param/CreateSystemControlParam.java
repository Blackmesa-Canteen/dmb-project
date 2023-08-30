package com.example.dynamic_menu_builder.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Parameters required for creating a system control.")
public class CreateSystemControlParam {

    @ApiModelProperty(value = "Name of the system control", required = true, example = "SYSTEM_CONTROL_1")
    @NotNull(message = "system control name cannot be null")
    String name;

    @ApiModelProperty(value = "Status of the system control", required = true, example = "true")
    @NotNull(message = "status boolean cannot be null")
    Boolean status;

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
