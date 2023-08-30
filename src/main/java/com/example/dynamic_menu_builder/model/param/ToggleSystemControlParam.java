package com.example.dynamic_menu_builder.model.param;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Map;


@ApiModel(description = "Parameters required for toggling system control.")
public class ToggleSystemControlParam {

    @ApiModelProperty(value = "System name-status map", required = true,
            example = "{\"SYSTEM_CONTROL_3\":true,\"SYSTEM_CONTROL_6\":false}")
    @NotNull(message = "system name-status map cannot be null")
    Map<String, Boolean> systemStatus;

    public Map<String, Boolean> getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(Map<String, Boolean> systemStatus) {
        this.systemStatus = systemStatus;
    }
}
