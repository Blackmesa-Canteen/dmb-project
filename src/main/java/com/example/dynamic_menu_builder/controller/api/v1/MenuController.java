package com.example.dynamic_menu_builder.controller.api.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dynamic_menu_builder.model.dto.MenuDTO;
import com.example.dynamic_menu_builder.model.dto.R;
import com.example.dynamic_menu_builder.model.entity.Menu;
import com.example.dynamic_menu_builder.model.param.CreateMenuParam;
import com.example.dynamic_menu_builder.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/menu")
@Api(tags = "Menu")
public class MenuController {

    private final IMenuService menuService;

    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * get menu by id
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get menu by id")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R getMenuById(@PathVariable(value = "id") Long id) {
        Menu menu = menuService.getById(id);
        return R.ok().put("data", menu);
    }

    /**
     * list all menus by page
     */
    @GetMapping("/")
    @ApiOperation(value = "List all menus by page")
    @ApiResponse(code = 200, message = "Example response: {'code': 200, 'msg': 'ok', 'data': [...]}")
    public R listAllMenusByPage(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size) {
        List<Menu> records = menuService
                .page(new Page<>(page, size))
                .getRecords();

        return R.ok().put("data", records);
    }

    /**
     * Create menu
     */
    @PostMapping("/")
    @ApiOperation(value = "Create menu")
    @ApiResponse(code = 200, message = "Example response: {'code': 200, 'msg': 'ok', 'data': {...}}")
    public R createMenu(@Valid @RequestBody CreateMenuParam param) {

        menuService.createMenu(
                param.getName(),
                param.getParentName(),
                param.getPermissionNameRequired(),
                param.getSystemControlNameRequired()
        );

        return R.ok();
    }

    /**
     * query menu structure by role id
     */
    @GetMapping("/structure/role/{roleId}")
    @ApiOperation(value = "Query menu structure by role id")
    @ApiResponse(code = 200,
            message = "Example response: {'code': 200, 'msg': 'ok', 'data': {...}}",
            response = MenuDTO.class,
            responseContainer = "List"
    )
    public R queryMenuStructureByRoleId(@PathVariable(value = "roleId") Long roleId) {
        List<MenuDTO> menus = menuService.queryMenuStructureByRoleId(roleId);
        return R.ok().put("data", menus);
    }

}
