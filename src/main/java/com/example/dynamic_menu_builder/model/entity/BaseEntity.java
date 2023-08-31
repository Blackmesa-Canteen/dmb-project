package com.example.dynamic_menu_builder.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID", example = "1")
    private Long id;

    @TableField(value = "created_at", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "created_at", example = "2020-01-01 00:00:00")
    private LocalDateTime createdAt = LocalDateTime.now();

    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "updated_at", example = "2020-01-01 00:00:00")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}