package com.example.dynamic_menu_builder.model.dto;

/**
 * Sub menu DTO of JSON initial Menu Rendering Table
 */
public class SubMenuDTO {
    private String name;
    private String systemControl;
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
}
