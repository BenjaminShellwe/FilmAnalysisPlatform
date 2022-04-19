package com.bap.system.controller;
/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/19 10:5:55
 */

import com.bap.system.mapper.BasicUserMapper;
import com.bap.system.mapper.FilmMapper;
import com.bap.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/film")
public class FilmDataController {

    @Autowired
    FilmMapper filmMapper;
    BasicUserMapper basicUserMapper;

    @ResponseBody
    @RequestMapping(value = "/count")
    public Result count() {
        String s = filmMapper.count();
        return new Result(s);
    }

}
