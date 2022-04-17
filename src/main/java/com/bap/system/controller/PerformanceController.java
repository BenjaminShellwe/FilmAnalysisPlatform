package com.bap.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bap.system.service.PerformanceService;
import com.bap.util.Result;

/**
 * The type InformationEnterprisePerformance controller.
 */
@RestController
@RequestMapping("/performance")
public class PerformanceController {

    /**
     * The InformationEnterprisePerformance service.
     */
    @Autowired
    PerformanceService performanceService;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return performanceService.queryAll();
    }
}
