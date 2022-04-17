package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import org.springframework.stereotype.Service;
import com.bap.system.dao.MonitorRepository;
import com.bap.system.entity.SystemLogMonitor;
import com.bap.system.service.MonitorService;
import com.bap.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Resource
    MonitorRepository monitorRepository;

    @Override
    public Result queryAll() {
        List<SystemLogMonitor> list = monitorRepository.findAll();
        return new Result(list);
    }
}
