package com.bap.system.controller;
/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/19 10:5:55
 */

import com.alibaba.fastjson.JSONObject;
import com.bap.system.mapper.FilmMapper;
import com.bap.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/film")
public class FilmDataController {

//    基本mapper调用请看下面函数的使用,为了方便理解,都是一个接口对应一次调用
    @Autowired
    FilmMapper filmMapper;

    @ResponseBody
    @RequestMapping(value = "/count")
    public Result count() {
        String s = filmMapper.count();
        return new Result(s);
    }

    @ResponseBody
    @RequestMapping(value = "/yearsCount")
    public Result yearsCount() {
        List<Map<String, Integer>> s = filmMapper.yearsCount();
        return new Result(s);
    }

    @ResponseBody
    @RequestMapping(value = "/randomFilm")
    public Result randomFilm() {
        List<Map<String, Integer>> s = filmMapper.randomFilm();
        return new Result(s);
    }

    @ResponseBody
    @RequestMapping(value = "/budgetFilm")
    public Result budgetFilm(@RequestBody JSONObject jsonObject) {
        List<Map<String, Integer>> s = filmMapper.budgetFilm(jsonObject.getInteger("i"),jsonObject.getInteger("j"));
        System.out.println("测试输出" + jsonObject);
        System.out.println(s);
        return new Result(s);
    }
}
