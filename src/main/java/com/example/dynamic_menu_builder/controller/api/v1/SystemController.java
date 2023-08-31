package com.example.dynamic_menu_builder.controller.api.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dynamic_menu_builder.model.dto.R;
import com.example.dynamic_menu_builder.model.entity.SystemControl;
import com.example.dynamic_menu_builder.model.param.CreateSystemControlParam;
import com.example.dynamic_menu_builder.model.param.ToggleSystemControlParam;
import com.example.dynamic_menu_builder.service.ISystemControlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/system")
@Api(tags = "System Control")
public class SystemController {

    private final ISystemControlService systemControlService;

    public SystemController(ISystemControlService systemControlService) {
        this.systemControlService = systemControlService;
    }

    /**
     * get system control by id
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get system control by id", notes = "Get system control by id")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R getSystemControlById(@PathVariable(value = "id") Long id) {
        SystemControl systemControl = systemControlService.getById(id);
        return R.ok().put("data", systemControl);
    }

    /**
     * list all system controls by page
     */
    @GetMapping("/")
    @ApiOperation(value = "List all system controls by page", notes = "List all system controls by page")
    @ApiResponse(code = 200, message = "Example response: {'code': 200, 'msg': 'ok', 'data': [...]}")
    public R listAllSystemControlsByPage(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size") Integer size
    ) {
        List<SystemControl> records = systemControlService
                .page(new Page<>(page, size))
                .getRecords();

        return R.ok().put("data", records);
    }

    /**
     * create system control
     */
    @PostMapping("/")
    @ApiOperation(value = "Create system control", notes = "Create system control")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R createSystemControl(
            @Valid @RequestBody CreateSystemControlParam param
            ) {
        systemControlService.createSystemControl(param.getName(), param.getStatus());
        return R.ok();
    }

    /**
     * batch toggle system control status
     */
    @PutMapping("/batch")
    @ApiOperation(value = "Toggle system control status", notes = "Toggle system control status")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R toggleSystemControlStatus(
            @Valid @RequestBody ToggleSystemControlParam param
    ) {
        systemControlService.toggleSystemControlStatus(param.getSystemStatus());
        return R.ok();
    }

    /**
     * update system control by id
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete system control by id", notes = "Delete system control by id")
    @ApiResponse(code = 200, message = "OK", response = R.class)
    public R deleteSystemControlById(@PathVariable(value = "id") Long id) {
        systemControlService.removeById(id);
        return R.ok();
    }
}
