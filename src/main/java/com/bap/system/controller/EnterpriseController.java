package com.bap.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.alibaba.fastjson.JSONObject;
import com.bap.system.entity.InformationEnterprise;
import com.bap.system.entity.InformationEnterpriseDepartment;
import com.bap.system.mapper.InformationEnterpriseMapper;
import com.bap.system.service.DepartmentService;
import com.bap.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * The type Enterprise controller.
 */
@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    /**
     * The Enterprise mapper.
     */
    @Autowired
    InformationEnterpriseMapper informationEnterpriseMapper;
    /**
     * The InformationEnterpriseDepartment service.
     */
    @Autowired
    DepartmentService departmentService;

    /**
     * Get by id result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/query/Info")
    public Result getById(@RequestBody JSONObject data){

        List<InformationEnterprise> list = informationEnterpriseMapper.getById(data.get("userID"));
        if (list.size() == 0){
            return new Result(2001, "No data return from Database");
        }
        return new Result(list);
    }

    /**
     * Query department result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/query/departmentAll")
    public Result queryDepartment(){
        return departmentService.queryAll();
    }

    /**
     * Query department by eid result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/query/department")
    public Result queryDepartmentByEID(@RequestBody JSONObject data){
        List<InformationEnterpriseDepartment> list = departmentService.getByEnterpriseID(data.getString("enterpriseID"));
        if (list.size() == 0) {
            return new Result(400, "Error!");
        }
        return new Result(list);
    }

    /**
     * Unite table list.
     *
     * @return the list
     */
    @ResponseBody
    @RequestMapping("/query/uniteTable")
    public List<Map<String, JSONObject>> uniteTable(){
//        System.out.println("????" + enterpriseMapper.uniteTable());
        return informationEnterpriseMapper.uniteTable();
    }

    /**
     * Update department field result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/update/department/field")
    public Result updateDepartmentField(@RequestBody JSONObject data){
       InformationEnterpriseDepartment informationEnterpriseDepartment = new InformationEnterpriseDepartment();
//       System.out.println("????" + data);
        JSONObject o = data.getJSONObject("data");
        informationEnterpriseDepartment.setId(o.getInteger("id"));
        informationEnterpriseDepartment.setName(o.getString("name"));
        informationEnterpriseDepartment.setDepartmentID(o.getString("departmentID"));
        informationEnterpriseDepartment.setEnterpriseID(o.getString("enterpriseID"));
        informationEnterpriseDepartment.setUIDD(o.getString("uidd"));
        informationEnterpriseDepartment.setDirector(o.getString("director"));
        informationEnterpriseDepartment.setPhoneD(o.getString("phoneD"));
        informationEnterpriseDepartment.setUIDM(o.getString("uidm"));
        informationEnterpriseDepartment.setManager(o.getString("manager"));
        informationEnterpriseDepartment.setPhoneM(o.getString("phoneM"));
        informationEnterpriseDepartment.setDepartmentStatus(o.getString("departmentStatus"));
        departmentService.updateDepartmentField(informationEnterpriseDepartment);
        return new Result(200, "Success");
    }
}

