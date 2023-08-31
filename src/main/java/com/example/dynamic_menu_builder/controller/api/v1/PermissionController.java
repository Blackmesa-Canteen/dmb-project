package com.example.dynamic_menu_builder.controller.api.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dynamic_menu_builder.model.dto.R;
import com.example.dynamic_menu_builder.model.entity.Permission;
import com.example.dynamic_menu_builder.model.param.CreatePermissionBatchParam;
import com.example.dynamic_menu_builder.model.param.CreatePermissionParam;
import com.example.dynamic_menu_builder.model.param.ToggleRolePermissionParam;
import com.example.dynamic_menu_builder.service.IPermissionService;
import com.example.dynamic_menu_builder.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "Permission")
@Validated
@RequestMapping("/api/v1/permission")
public class PermissionController {

    private final IPermissionService permissionService;

    private final IRoleService roleService;

    public PermissionController(IPermissionService permissionService, IRoleService roleService) {
        this.permissionService = permissionService;
        this.roleService = roleService;
    }

    /**
     * get permission by id
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get permission by id")
    @ApiResponse(code = 200, message = "Example response: {'code': 200, 'msg': 'ok', 'data': {...}}")
    public R getPermissionById(@PathVariable(value = "id") Long id) {
        Permission permission = permissionService.getById(id);
        return R.ok().put("data", permission);
    }

    /**
     * list all permissions by page
     * @param page page number
     * @param size page size
     */
    @GetMapping("/")
    @ApiOperation(value = "List all permissions by page")
    @ApiResponse(code = 200, message = "Example response: {'code': 200, 'msg': 'ok', 'data': [...]}")
    public R listAllPermissionsByPage(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size) {
        List<Permission> records = permissionService
                .page(new Page<>(page, size))
                .getRecords();

        return R.ok().put("data", records);
    }

    /**
     * get role permissions by role id
     */
    @GetMapping("/batch/role/{roleId}")
    @ApiOperation(value = "Get role permission names by role id")
    @ApiResponse(code = 200, message = "Example response: {'code': 200, 'msg': 'ok', 'data': [...]}")
    public R getRolePermissionsByRoleId(@PathVariable(value = "roleId") Long id) {
        List<String> permissions = roleService.getRolePermissionsByRoleId(id);
        return R.ok().put("data", permissions);
    }

    /**
     * enable role permission
     */
    @PutMapping("/batch/enable")
    @ApiOperation(value = "Enable role permissions")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R enableRolePermission(
            @Valid @RequestBody ToggleRolePermissionParam param
    ) {
        roleService.enableRolePermission(param.getRoleId(), param.getPermissionList());
        return R.ok();
    }

    /**
     * disable role permission
     */
    @PutMapping("/batch/disable")
    @ApiOperation(value = "Disable role permissions")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R disableRolePermission(
            @Valid @RequestBody ToggleRolePermissionParam param
    ) {
        roleService.disableRolePermission(param.getRoleId(), param.getPermissionList());
        return R.ok();
    }

    /**
     * Create permission
     */
    @PostMapping("/")
    @ApiOperation(value = "Create permission")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R createPermission(@Valid @RequestBody CreatePermissionParam param) {
        permissionService.createPermissionByName(param.getName());
        return R.ok();
    }

    /**
     * Create permission batch
     */
    @PostMapping("/batch")
    @ApiOperation(value = "Create permission batch")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R createPermissionBatch(@Valid @RequestBody CreatePermissionBatchParam param) {
        permissionService.createPermissionByNameBatch(param.getNames());
        return R.ok();
    }

    /**
     * delete permission by id
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete permission by id")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R deletePermissionById(@PathVariable(value = "id") Long id) {
        permissionService.removeById(id);
        return R.ok();
    }
}
