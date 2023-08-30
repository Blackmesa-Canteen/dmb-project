package com.example.dynamic_menu_builder.controller.api.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dynamic_menu_builder.model.dto.R;
import com.example.dynamic_menu_builder.model.entity.Permission;
import com.example.dynamic_menu_builder.model.param.CreatePermissionBatchParam;
import com.example.dynamic_menu_builder.model.param.CreatePermissionParam;
import com.example.dynamic_menu_builder.service.IPermissionService;
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

    public PermissionController(IPermissionService permissionService) {
        this.permissionService = permissionService;
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
