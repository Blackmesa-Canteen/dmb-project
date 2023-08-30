package com.example.dynamic_menu_builder.model.param;

import jakarta.validation.constraints.NotNull;

public class CreateRoleParam {

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
