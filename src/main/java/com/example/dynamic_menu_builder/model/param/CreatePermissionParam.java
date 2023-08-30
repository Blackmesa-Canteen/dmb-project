package com.example.dynamic_menu_builder.model.param;

import jakarta.validation.constraints.NotNull;

/**
 * CreatePermissionParam from post body
 */
public class CreatePermissionParam {

    @NotNull(message = "permission name cannot be null")
    String name;

    public CreatePermissionParam() {
    }

    public CreatePermissionParam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
