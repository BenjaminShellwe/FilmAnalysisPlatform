package com.bap.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import com.bap.system.entity.InformationEnterpriseDepartment;

import com.bap.util.Result;

import java.util.List;

/**
 * The interface InformationEnterpriseDepartment service.
 */
public interface DepartmentService {
    /**
     * Query all result.
     *
     * @return the result
     */
    Result queryAll();

    /**
     * Gets by enterprise id.
     *
     * @param eid the eid
     * @return the by enterprise id
     */
    List<InformationEnterpriseDepartment> getByEnterpriseID(String eid);

    /**
     * Update informationEnterpriseDepartment field result.
     *
     * @param informationEnterpriseDepartment the informationEnterpriseDepartment
     * @return the result
     */
    Result updateDepartmentField(InformationEnterpriseDepartment informationEnterpriseDepartment);
}
