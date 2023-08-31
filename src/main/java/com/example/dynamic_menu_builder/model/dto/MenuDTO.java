package com.example.dynamic_menu_builder.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

/**
 * Root menu DTO of JSON initial Menu Rendering Table
 */
@ApiModel(value = "MenuDTO", description = "Root menu DTO of JSON initial Menu Rendering Table")
public class MenuDTO {

    @ApiModelProperty(value = "Name of the menu", required = true, example = "MENU_1")
    private String name;

    @ApiModelProperty(value = "List of sub menus", required = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDTO menuDTO = (MenuDTO) o;
        return Objects.equals(name, menuDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
