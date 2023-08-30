package com.example.dynamic_menu_builder.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * CreatePermissionParam from post body
 */
@ApiModel(description = "Parameters required for creating a permission.")
public class CreatePermissionParam {

    @ApiModelProperty(value = "Name of the permission", required = true, example = "read_user")
    @NotNull(message = "Permission name cannot be null")
    private String name;

    public CreatePermissionParam() {
    }

    public CreatePermissionParam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
