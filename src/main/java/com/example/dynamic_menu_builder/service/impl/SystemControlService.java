package com.example.dynamic_menu_builder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic_menu_builder.exception.NotFoundException;
import com.example.dynamic_menu_builder.mapper.SystemControlMapper;
import com.example.dynamic_menu_builder.model.entity.SystemControl;
import com.example.dynamic_menu_builder.service.ISystemControlService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class SystemControlService extends ServiceImpl<SystemControlMapper, SystemControl>
        implements ISystemControlService {

    private final SystemControlMapper systemControlMapper;

    public SystemControlService(SystemControlMapper systemControlMapper) {
        this.systemControlMapper = systemControlMapper;
    }

    @Override
    public void createSystemControl(String name, Boolean status) {
        SystemControl systemControl = new SystemControl(name, status);
        save(systemControl);
    }

    @Override
    @Transactional
    public void toggleSystemControlStatus(Map<String, Boolean> systemControlStatusMap) {
        // check key
        systemControlStatusMap.forEach((name, status) -> {
            // query system control by name
            QueryWrapper<SystemControl> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", name);
            SystemControl systemControl = systemControlMapper.selectOne(queryWrapper);
            if (systemControl == null) {
                throw new NotFoundException("System control name not found: " + name);
            }

            systemControl.setStatus(status);
            updateById(systemControl);
        });
    }
}
