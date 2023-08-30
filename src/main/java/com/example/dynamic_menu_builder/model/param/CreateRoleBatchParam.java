package com.example.dynamic_menu_builder.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(description = "Parameters required for creating a role batch.")
public class CreateRoleBatchParam {

    @NotNull(message = "names list cannot be null")
    @ApiModelProperty(value = "Names of the roles", required = true, example = "[\"ROLE_1\", \"ROLE_2\"]")
    List<String> names;

    public CreateRoleBatchParam() {
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
