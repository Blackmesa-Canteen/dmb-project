package com.example.dynamic_menu_builder.controller.api.v1;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dynamic_menu_builder.model.dto.R;
import com.example.dynamic_menu_builder.model.entity.Role;
import com.example.dynamic_menu_builder.model.param.CreateRoleBatchParam;
import com.example.dynamic_menu_builder.model.param.CreateRoleParam;
import com.example.dynamic_menu_builder.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@Api(tags = "Role")
@RequestMapping("/api/v1/role")
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * get role by id
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get role by id")
    @ApiResponse(code = 200, message = "Example response: {'code': 200, 'msg': 'ok', 'data': {...}}")
    public R getRoleById(@PathVariable(value = "id") Long id) {
        Role role = roleService.getById(id);
        return R.ok().put("data", role);
    }

    /**
     * list all roles by page
     *
     * @param page page number
     * @param size page size
     * @since 08/09/2021
     */
    @GetMapping("/")
    @ApiOperation(value = "List all roles by page")
    @ApiResponse(code = 200, message = "Example response: {'code': 200, 'msg': 'ok', 'data': [...]}")
    public R listAllRolesByPage(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size) {
        List<Role> records = roleService
                .page(new Page<>(page, size))
                .getRecords();

        return R.ok().put("data", records);
    }

    /**
     * Create role by name
     *
     * @since 08/09/2021
     */
    @PostMapping("/")
    @ApiOperation(value = "Create role")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R createRole(@Valid @RequestBody CreateRoleParam param) {
        roleService.createRoleByName(param.getName());
        return R.ok();
    }

    /**
     * Create role by name batch
     *
     * @since 08/09/2021
     */
    @PostMapping("/batch")
    @ApiOperation(value = "Create role by name batch")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R crateRoleByNameBatch(@Valid @RequestBody CreateRoleBatchParam param) {
        roleService.crateRoleByNameBatch(param.getNames());
        return R.ok();
    }

    /**
     * delete role by id
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete role by id")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R deleteRoleById(@PathVariable(value = "id") Long id) {
        roleService.removeById(id);
        return R.ok();
    }
}
