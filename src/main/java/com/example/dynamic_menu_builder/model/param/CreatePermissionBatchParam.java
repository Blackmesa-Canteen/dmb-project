package com.example.dynamic_menu_builder.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * create permission batch param
 */
@ApiModel(description = "Parameters required for creating a permission.")
public class CreatePermissionBatchParam {

    @NotNull(message = "names list cannot be null")
    @ApiModelProperty(value = "Names of the permissions",
            required = true, example = "[\"PERMISSION_1\", \"PERMISSION_2\"]")
    List<String> names;

    public CreatePermissionBatchParam() {
    }

    public CreatePermissionBatchParam(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
