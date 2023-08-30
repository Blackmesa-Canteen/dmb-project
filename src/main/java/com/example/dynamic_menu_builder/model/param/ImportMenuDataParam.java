package com.example.dynamic_menu_builder.model.param;

import com.example.dynamic_menu_builder.model.dto.MenuDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * import init Menu Rendering Table data from json
 */
@ApiModel(description = "Parameters required for importing init Menu Rendering Table.")
public class ImportMenuDataParam {

    @ApiModelProperty(value = "Menu list", required = true,
            example = "[{\"name\":\"MENU_1\",\"subMenus\":[{\"name\":\"SUB_MENU_1\"," +
                    "\"subMenus\":[{\"name\":\"SUB_SUB_MENU_1\",\"subMenus\":[]}," +
                    "{\"name\":\"SUB_SUB_MENU_2\",\"subMenus\":[]}]}]}]")
    @NotNull
    private List<MenuDTO> menus;

    public List<MenuDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDTO> menus) {
        this.menus = menus;
    }
}
