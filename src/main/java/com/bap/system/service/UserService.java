package com.bap.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.baomidou.mybatisplus.service.IService;
import com.bap.system.entity.BasicUser;

/**
 * The interface User service.
 */
public interface UserService extends IService<BasicUser> {


    /**
     * 保存系统管理-用户基础信息表
     *
     * @param input:
     * @return: java.lang.Integer
     */
    Integer save(BasicUser input);

    /**
     * 修改用户个人信息
     *
     * @param para:
     * @return: java.lang.Integer
     */
    Integer updatePersonalInfo(BasicUser para);
}
