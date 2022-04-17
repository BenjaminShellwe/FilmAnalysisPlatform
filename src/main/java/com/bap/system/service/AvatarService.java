package com.bap.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.entity.BasicAvatar;

/**
 * The interface Avatar service.
 */
public interface AvatarService {
    /**
     * Query avatar.
     *
     * @param id the id
     * @return the avatar
     */
    BasicAvatar query(int id);

    /**
     * Insert.
     *
     * @param basicAvatar the avatar
     */
    void insert(BasicAvatar basicAvatar);
}
