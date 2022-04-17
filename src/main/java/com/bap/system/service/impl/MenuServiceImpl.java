package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bap.system.dto.input.MenuQueryPara;
import com.bap.system.entity.SystemUrl;
import com.bap.system.mapper.MenuMapper;
import com.bap.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> 系统管理-菜单表  服务实现类 </p>
 */
@Service
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper, SystemUrl> implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List <SystemUrl> listTreeMenu() {
        return menuMapper.selectList(null);
    }

    @Override
    public void listPage(Page<SystemUrl> page, MenuQueryPara filter) {
        page.setRecords(menuMapper.selectMenus(page, filter));
    }

    @Override
    public List<SystemUrl> list(MenuQueryPara filter) {
        return menuMapper.selectMenus(filter);
    }

    @Override
    public Integer save(SystemUrl para) {
        if (para.getId()!=null) {
            menuMapper.updateById(para);
        } else {
            menuMapper.insert(para);
        }
        return para.getId();
    }

}
