package com.example.dynamic_menu_builder.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Parameters required for creating a role.")
public class CreateRoleParam {

    @ApiModelProperty(value = "Name of the role", required = true, example = "ROLE_1")
    @NotNull(message = "role name cannot be null")
    String name;

    public CreateRoleParam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
