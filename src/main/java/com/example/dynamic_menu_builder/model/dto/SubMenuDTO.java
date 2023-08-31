package com.example.dynamic_menu_builder.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Sub menu DTO of JSON initial Menu Rendering Table
 */
@ApiModel(value = "SubMenuDTO", description = "Sub menu DTO of JSON initial Menu Rendering Table")
public class SubMenuDTO {

    @ApiModelProperty(value = "Name of the sub menu", required = true, example = "menu_1_1")
    private String name;

    @ApiModelProperty(value = "System control name for the sub menu", required = true, example = "SYSTEM_CONTROL_2")
    private String systemControl;

    @ApiModelProperty(value = "Permission required to view sub menu", required = true, example = "PERMISSION_6")
    private String permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystemControl() {
        return systemControl;
    }

    public void setSystemControl(String systemControl) {
        this.systemControl = systemControl;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubMenuDTO that = (SubMenuDTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
