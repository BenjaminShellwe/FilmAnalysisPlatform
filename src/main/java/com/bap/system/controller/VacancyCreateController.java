package com.bap.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.alibaba.fastjson.JSONObject;
import com.bap.system.mapper.VacancyMapper;
import com.bap.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bap.system.entity.SeniorVacancyCreate;
import com.bap.system.service.VacancyComingService;

/**
 * The type SeniorVacancy coming controller.
 */
@RestController
@RequestMapping("/vacancyComing")
public class VacancyCreateController {

    /**
     * The SeniorVacancy coming service.
     */
    @Autowired
    VacancyComingService vacancyComingService;

    /**
     * The SeniorVacancy coming mapper.
     */
    @Autowired
    VacancyMapper vacancyMapper;
    private JSONObject data;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return vacancyComingService.queryAll();
    }

    /**
     * Update by aid result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/updateByAid")
    public Result updateByAid(@RequestBody JSONObject data){
        String aid = data.getString("affairID");
        int i = data.getInteger("verify");
        vacancyMapper.updateByAid(aid, i);
        return new Result(200, "Success");
    }

    /**
     * Delete by aid result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/deleteByAid")
    public Result deleteByAid(@RequestBody JSONObject data){
        vacancyMapper.deleteByAid(data.getString("affairID"));
        return new Result(200, "Success");
    }

    /**
     * Update vacancy coming result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/updateAll")
    public Result updateVacancyComing(@RequestBody JSONObject data){
//        System.out.println("测试输出data" + data);
        SeniorVacancyCreate seniorVacancyCreate = new SeniorVacancyCreate();
        JSONObject o = data.getJSONObject("data");
        seniorVacancyCreate.setId(o.getInteger("id"));
        seniorVacancyCreate.setAffairID(o.getString("affairID"));
        seniorVacancyCreate.setResult(o.getString("result"));
        seniorVacancyCreate.setEnterpriseID(o.getString("enterpriseID"));
        seniorVacancyCreate.setDepartmentID(o.getString("departmentID"));
        seniorVacancyCreate.setPosition(o.getString("position"));
        seniorVacancyCreate.setDepartment(o.getString("department"));
        seniorVacancyCreate.setEstimatedTime(o.getString("estimatedTime"));
        seniorVacancyCreate.setName(o.getString("name"));
        seniorVacancyCreate.setSex(o.getString("sex"));
        seniorVacancyCreate.setDescription(o.getString("description"));
        seniorVacancyCreate.setCreatedTime(o.getString("createdTime"));
        seniorVacancyCreate.setAddress(o.getString("address"));
        seniorVacancyCreate.setPhone(o.getString("phone"));

        vacancyComingService.updateAll(seniorVacancyCreate);
        return new Result(200, "Success");
    }
}
