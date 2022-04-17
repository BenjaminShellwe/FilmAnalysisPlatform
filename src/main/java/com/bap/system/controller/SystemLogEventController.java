package com.bap.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.service.SystemLogEventService;
import com.bap.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Log system controller.
 */
@RestController
@RequestMapping("/log")
public class SystemLogEventController {

    /**
     * The Log system service.
     */
    @Autowired
    SystemLogEventService systemLogEventService;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return systemLogEventService.queryAll();
    }
}
