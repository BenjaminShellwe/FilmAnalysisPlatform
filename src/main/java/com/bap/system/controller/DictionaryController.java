package com.bap.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bap.system.entity.DictionaryGlobal;
import com.bap.system.mapper.DictionaryMapper;
import com.bap.system.service.GlobalDicService;
import com.bap.util.Result;

import java.util.*;


/**
 * The type Global dic controller.
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
    /**
     * The Global dic service.
     */
    @Autowired
    GlobalDicService globalDicService;

    /**
     * The Global dic mapper.
     */
    @Autowired
    DictionaryMapper dictionaryMapper;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return globalDicService.queryAll();
    }

    /**
     * Gets by type name.
     *
     * @param data the data
     * @return the by type name
     */
    @PostMapping("/queryTypeName")
    public Result getByTypeName(@RequestBody JSONObject data) {
        List<DictionaryGlobal> list = dictionaryMapper.getByTypeName(data.get("typeName"));
        if (list.size() == 0){
            return new Result(200, "查无数据");
        }
        return new Result(list);
    }

    /**
     * Gets by id.
     *
     * @param data the data
     * @return the by id
     */
    @PostMapping("/queryId")
    public Result getById(@RequestBody JSONObject data) {
        List<DictionaryGlobal> list = dictionaryMapper.getById(data.get("id"));
        if (list.size() == 0){
            return new Result(200, "查无数据");
        }
//        System.out.println(list.get(0).getEditable());
        if(Objects.equals(list.get(0).getEditable(), "0")){
            return new Result(4033, "禁止写访问");
        }
        return new Result(200, "数据已获取");
    }

    /**
     * Delete by id result.
     *
     * @param data the data
     * @return the result
     */
    @PostMapping("/deleteId")
    public Result DeleteById(@RequestBody JSONObject data) {
        List<DictionaryGlobal> list = dictionaryMapper.getById(data.get("id"));
//        System.out.println(list);
        if(Objects.equals(list.get(0).getEditable(), "0")){
            return new Result(4033, "删除动作被拒绝");
        }
        dictionaryMapper.deleteId(data.get("id"));
        return new Result(200, "删除已执行");
    }

    /**
     * Add global dic result.
     *
     * @param dictionaryGlobal the dictionary
     * @return the result
     */
    @PostMapping("/addGlobalDic")
    public Result addGlobalDic(@RequestBody DictionaryGlobal dictionaryGlobal) {
        cherkType(dictionaryGlobal);
        if(dictionaryGlobal.getType().equals("single")){
            List<DictionaryGlobal> list = dictionaryMapper.getByTypeName(dictionaryGlobal.getTypeName());
            if(list.size() > 0) {
                return new Result(415, "Same rule found!");
            }
        }
        dictionaryGlobal.setEditable("0");
        globalDicService.updateGlobalDic(dictionaryGlobal);
        return new Result(200, "添加规则成功!");
    }

    /**
     * Update global dic field result.
     *
     * @param dictionaryGlobal the dictionary
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/update/field")
    public Result updateGlobalDicField(@RequestBody DictionaryGlobal dictionaryGlobal) {
        cherkType(dictionaryGlobal);
        globalDicService.updateGlobalDic(dictionaryGlobal);
        return new Result(200, "Success");
    }

    /**
     * Cherk type.
     *
     * @param dictionaryGlobal the dictionary
     */
    public void cherkType(@RequestBody DictionaryGlobal dictionaryGlobal) {
        if(dictionaryGlobal.getType().equals("single")) {
            dictionaryGlobal.setValueID(0);
            if(dictionaryGlobal.getTypeCode().contains("_")){
                dictionaryGlobal.setTypeCode((dictionaryGlobal.getTypeCode().split("_Type")[0]));
            }
        }
        if(dictionaryGlobal.getType().equals("group")) {
            if(!dictionaryGlobal.getTypeCode().contains("_")){
                dictionaryGlobal.setTypeCode(dictionaryGlobal.getTypeCode() + "_Type");
            }
            List<DictionaryGlobal> list = dictionaryMapper.getByTypeName(dictionaryGlobal.getTypeName());
            if(list.size() > 0) {
                dictionaryGlobal.setValueID(list.size() + 1);
            }
        }
    }
}
