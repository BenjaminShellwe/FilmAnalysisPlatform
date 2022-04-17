package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bap.system.dao.LogSystemRepository;
import com.bap.system.dto.input.LogQueryPara;
import com.bap.system.entity.SystemLogEvent;
import com.bap.system.entity.SystemLogOrder;
import com.bap.system.mapper.SystemLogEventMapper;
import com.bap.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bap.system.service.SystemLogEventService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemEventLogEventServiceImpl extends ServiceImpl<SystemLogEventMapper, SystemLogEvent> implements SystemLogEventService {

    @Autowired
    SystemLogEventMapper systemLogEventMapper;

    @Resource
    LogSystemRepository logSystemRepository;

    @Override
    public Result queryAll() {
        List<SystemLogOrder> list = logSystemRepository.findAll();
        return new Result(list);
    }

    @Override
    public void listPage(Page<SystemLogEvent> page, LogQueryPara para) {
        List<SystemLogEvent> result = systemLogEventMapper.selectSystemLogs(page, para);
        result.forEach( e->{
//            if (e.getUserId()==0){
//                e.setUsername("非法人员");
//            }
        });
        page.setRecords(result);
    }

    @Override
    public List<SystemLogEvent> list(LogQueryPara para) {
        return systemLogEventMapper.selectSystemLogs(para);
    }

    @Override
    public Integer save(SystemLogEvent para) {
        if (para.getId()!=null) {
            systemLogEventMapper.updateById(para);
        } else {
            systemLogEventMapper.insert(para);
        }
        return para.getId();
    }
}
