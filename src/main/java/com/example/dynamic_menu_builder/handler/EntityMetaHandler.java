package com.example.dynamic_menu_builder.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.dynamic_menu_builder.constant.CommonConstant;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EntityMetaHandler implements MetaObjectHandler {

    /**
     * auto fill date and field for logical delete
     * @param metaObject meta object
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, CommonConstant.CREATED_AT_FIELD_NAME, LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, CommonConstant.UPDATED_AT_FIELD_NAME, LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, CommonConstant.UPDATED_AT_FIELD_NAME, LocalDateTime.class, LocalDateTime.now());
    }
}
