package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import org.springframework.stereotype.Service;
import com.bap.system.dao.DepartmentRepository;
import com.bap.system.entity.InformationEnterpriseDepartment;
import com.bap.system.service.DepartmentService;
import com.bap.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    DepartmentRepository departmentRepository;

    @Override
    public Result queryAll() {
        List<InformationEnterpriseDepartment> list = departmentRepository.findAll();
        return new Result(list);
    }

    @Override
    public List<InformationEnterpriseDepartment> getByEnterpriseID(String eid) {
//        List<InformationEnterpriseDepartment> list = departmentRepository.getByEnterpriseID(eid);
        return departmentRepository.getByEnterpriseID(eid);
    }

    @Override
    public Result updateDepartmentField(InformationEnterpriseDepartment informationEnterpriseDepartment){
        departmentRepository.save(informationEnterpriseDepartment);
        return new Result(200, "Success");
    }
}
