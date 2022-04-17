package com.bap.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bap.system.entity.informationPersonal;

import java.util.List;

/**
 * The interface Get info pe repository.
 */
@Repository(value = "getInfoPeRepository")
public interface GetInfoPeRepository extends JpaRepository<informationPersonal,Integer> {
    /**
     * Gets by id.
     *
     * @param data the data
     * @return the by id
     */
    List<informationPersonal> getById(int data);
}
