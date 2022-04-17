package com.bap.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.entity.InformationEnterpriseEmployees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Get info en repository.
 */
@Repository(value = "getInfoEnRepository")
public interface GetInfoEnRepository extends JpaRepository<InformationEnterpriseEmployees,Integer> {
    /**
     * Gets by id.
     *
     * @param data the data
     * @return the by id
     */
    List<InformationEnterpriseEmployees> getById(int data);
}
