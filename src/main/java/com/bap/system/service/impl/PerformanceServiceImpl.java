package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import org.springframework.stereotype.Service;
import com.bap.system.dao.PerformanceRepository;
import com.bap.system.entity.InformationEnterprisePerformance;
import com.bap.system.service.PerformanceService;
import com.bap.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Resource
    PerformanceRepository performanceRepository;

    @Override
    public Result queryAll() {
        List<InformationEnterprisePerformance> list = performanceRepository.findAll();
        return new Result(list);
    }
}
