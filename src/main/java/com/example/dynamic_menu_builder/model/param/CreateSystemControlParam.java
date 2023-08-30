package com.example.dynamic_menu_builder.model.param;

import jakarta.validation.constraints.NotNull;

public class CreateSystemControlParam {

    @NotNull(message = "system control name cannot be null")
    String name;

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
