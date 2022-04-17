package com.bap.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.entity.BasicAvatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Avatar repository.
 */
@Repository(value = "AvatarService")
public interface AvatarRepository extends JpaRepository<BasicAvatar,Integer> {
    /**
     * Find by id avatar.
     *
     * @param id the id
     * @return the avatar
     */
    BasicAvatar findById(int id);
}
