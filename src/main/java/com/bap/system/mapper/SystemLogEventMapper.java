package com.bap.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bap.system.dto.input.LogQueryPara;
import org.apache.ibatis.annotations.Mapper;
import com.bap.system.entity.SystemLogEvent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemLogEventMapper extends BaseMapper<SystemLogEvent> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<SystemLogEvent> selectSystemLogs(Pagination page, @Param("filter") LogQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<SystemLogEvent> selectSystemLogs(@Param("filter") LogQueryPara filter);

}
