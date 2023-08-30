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
}
