package com.bap.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.bap.system.dto.input.LogQueryPara;
import com.bap.system.entity.SystemLogEvent;
import com.bap.util.Result;

import java.util.List;

/**
 * The interface Log system service.
 */
public interface SystemLogEventService extends IService<SystemLogEvent> {
    /**
     * Query all result.
     *
     * @return the result
     */
    Result queryAll();
    /**
     * 系统管理 - 日志表列表分页
     *
     * @param page
     * @param para
     * @return
     */
    void listPage(Page<SystemLogEvent> page, LogQueryPara para);

    /**
     * 保存系统管理 - 日志表
     *
     * @param input
     */
    Integer save(SystemLogEvent input);

    /**
     * 系统管理 - 日志表列表
     *
     * @param para
     * @return
     */
    List<SystemLogEvent> list(LogQueryPara para);
}
