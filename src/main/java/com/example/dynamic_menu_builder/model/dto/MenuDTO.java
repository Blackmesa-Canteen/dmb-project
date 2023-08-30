package com.example.dynamic_menu_builder.model.dto;


import java.util.List;

/**
 * Root menu DTO of JSON initial Menu Rendering Table
 */
public class MenuDTO {
    private String name;
    private List<SubMenuDTO> subMenus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubMenuDTO> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SubMenuDTO> subMenus) {
        this.subMenus = subMenus;
    }
}
