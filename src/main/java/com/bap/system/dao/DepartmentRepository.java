package com.bap.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.entity.InformationEnterpriseDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface InformationEnterpriseDepartment repository.
 */
@Repository(value = "departmentService")
public interface DepartmentRepository extends JpaRepository<InformationEnterpriseDepartment,Integer> {
    /**
     * Gets by enterprise id.
     *
     * @param eid the eid
     * @return the by enterprise id
     */
    List<InformationEnterpriseDepartment> getByEnterpriseID(String eid);
}
