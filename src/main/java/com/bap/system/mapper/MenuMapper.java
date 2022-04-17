package com.bap.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import com.bap.system.dto.input.MenuQueryPara;
import com.bap.system.entity.SystemUrl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> 系统管理-菜单表  Mapper 接口 </p>
 *
 * @author : zhengqing
 * @author BenjaminThomas
 * @date : 2022/03/28
 */
@Mapper
public interface MenuMapper extends BaseMapper<SystemUrl> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<SystemUrl> selectMenus(Pagination page, @Param("filter") MenuQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<SystemUrl> selectMenus(@Param("filter") MenuQueryPara filter);

    /**
     * 通过菜单编码获取信息
     *
     * @param resources:
     * @return: com.zhengqing.modules.system.entity.SystemUrl
     */
    SystemUrl findByResources(@Param("resources") String resources);

    /**
     * 根据角色查询用户权限
     *
     * @param roleId:
     * @return: java.util.List<com.zhengqing.modules.system.entity.SystemUrl>
     */
    List<SystemUrl> selectMenuByRoleId(@Param("roleId") Integer roleId);

}
