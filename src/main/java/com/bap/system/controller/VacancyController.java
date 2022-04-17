package com.bap.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bap.system.entity.SeniorVacancy;
import com.bap.system.service.VacancyService;
import com.bap.util.Result;

import java.text.SimpleDateFormat;

/**
 * The type SeniorVacancy controller.
 */
@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    /**
     * The SeniorVacancy service.
     */
    @Autowired
    VacancyService vacancyService;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return vacancyService.queryAll();
    }

    /**
     * Update result.
     *
     * @param object the object
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result update(@RequestBody JSONObject object) {
        SeniorVacancy seniorVacancy = new SeniorVacancy();
        seniorVacancy.setAffairID(object.getString("affairID"));
        seniorVacancy.setPosition(object.getString("position"));
        seniorVacancy.setDescription(object.getString("description"));
        seniorVacancy.setSalary(object.getString("salary"));
        seniorVacancy.setType(object.getString("type"));
        seniorVacancy.setRequirement(object.getString("requirement"));
        seniorVacancy.setDepartment(object.getString("department"));
        seniorVacancy.setDeadline(object.getDate("deadline"));
        seniorVacancy.setCreatedTime(object.getDate("createdTime"));
        seniorVacancy.setDepartmentID(object.getString("departmentID"));
        seniorVacancy.setEnterpriseID(object.getString("enterpriseID"));
        seniorVacancy.setPositionStatus(object.getString("positionStatus"));
        vacancyService.update(seniorVacancy);
        return new Result(200, "提交数据已修改");
    }

    /**
     * Publish result.
     *
     * @param object the object
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/addNewVacancy")
    public Result publish(@RequestBody JSONObject object){
        Long timeStamp = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmss");
        SeniorVacancy seniorVacancy =new SeniorVacancy();
        seniorVacancy.setCreatedTime(object.getDate("createdTime"));
        seniorVacancy.setDeadline(object.getDate("estimatedTime"));
        seniorVacancy.setPositionStatus(object.getString("positionStatus"));
        seniorVacancy.setType(object.getString("type"));
        seniorVacancy.setRequirement(object.getString("requirement"));
        seniorVacancy.setSalary(object.getString("salary"));
        seniorVacancy.setDepartment(object.getString("department"));
        seniorVacancy.setPosition(object.getString("position"));
        seniorVacancy.setDescription(object.getString("description"));
        seniorVacancy.setDepartmentID(object.getString("departmentID"));
        seniorVacancy.setEnterpriseID(object.getString("enterpriseID"));
        String s = simpleDateFormat.format(timeStamp);
        System.out.println("测试输出" + object.getString("AffairID"));
        if(object.getString("AffairID") == null ){
            seniorVacancy.setAffairID(s);
        } else {
            seniorVacancy.setAffairID(object.getString("AffairID"));
        }
        Result r = vacancyService.publish(seniorVacancy);
        if (r.getCode() != 200){
            return new Result(401, "Error!", "error");
        }
        return new Result(200, "success", "success");
    }
}
