package com.bap.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.bap.system.dto.input.MenuQueryPara;
import com.bap.system.entity.SystemUrl;

import java.util.List;

/**
 * <p>  系统管理-菜单表  服务类 </p>
 */
public interface MenuService extends IService<SystemUrl> {

    /**
     * 菜单树
     *
     * @param :
     * @return: java.util.List<top.shellwe.bip.modules.system.entity.SystemUrl>
     */
    List<SystemUrl> listTreeMenu();

    /**
     * 系统管理-菜单表 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<SystemUrl> page, MenuQueryPara filter);

    /**
     * 保存系统管理-菜单表
     *
     * @param input
     */
    Integer save(SystemUrl input);

    /**
     * 系统管理-菜单表 列表
     *
     * @param filter
     * @return
     */
    List<SystemUrl> list(MenuQueryPara filter);
}
