package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import org.springframework.stereotype.Service;
import com.bap.system.dao.AvatarRepository;
import com.bap.system.entity.BasicAvatar;
import com.bap.system.service.AvatarService;

import javax.annotation.Resource;


@Service
public class AvatarServiceImpl implements AvatarService {

    @Resource
    AvatarRepository avatarRepository;

    @Override
    public void insert(BasicAvatar basicAvatar){
        avatarRepository.save(basicAvatar);
    }

    @Override
    public BasicAvatar query(int id) {
        BasicAvatar basicAvatar = avatarRepository.getById(id);
        System.out.println("测试输出" + avatarRepository.getById(id));
        return basicAvatar;
    }
}
