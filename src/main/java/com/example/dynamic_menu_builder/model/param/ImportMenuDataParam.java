package com.example.dynamic_menu_builder.model.param;

import java.util.List;

/**
 * import menu data from json
 */
public class ImportMenuDataParam {
    private MenuData data;

    public MenuData getData() {
        return data;
    }

    public void setData(MenuData data) {
        this.data = data;
    }

    public static class MenuData {
        private List<Menu> menus;

        public List<Menu> getMenus() {
            return menus;
        }

        public void setMenus(List<Menu> menus) {
            this.menus = menus;
        }
    }

    public static class Menu {
        private String name;
        private List<SubMenu> subMenus;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubMenu> getSubMenus() {
            return subMenus;
        }

        public void setSubMenus(List<SubMenu> subMenus) {
            this.subMenus = subMenus;
        }
    }

    public static class SubMenu {
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
}
