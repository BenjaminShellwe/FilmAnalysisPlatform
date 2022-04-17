package com.bap.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.service.MonitorService;
import com.bap.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type SystemLogMonitor controller.
 */
@RestController
@RequestMapping("/monitor")
public class MonitorController {

    /**
     * The SystemLogMonitor service.
     */
    @Autowired
    MonitorService monitorService;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return monitorService.queryAll();
    }
}
