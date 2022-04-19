package com.bap.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import com.alibaba.fastjson.JSONObject;
import com.bap.system.entity.BasicUser;
import com.bap.system.mapper.BasicUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bap.util.Result;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;


/**
 * The type User controller.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * The User mapper.
     */
    @Autowired
    BasicUserMapper basicUserMapper;

    /**
     * Register string.
     *
     * @return the string
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * Login string.
     *
     * @return the string
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Success login string.
     *
     * @return the string
     */
    @RequestMapping("/successLogin")
    public String successLogin() { return "successLogin"; }

    /**
     * Success register string.
     *
     * @return the string
     */
    @RequestMapping("/successRegister")
    public String successRegister() { return "1"; }

    /**
     * Select string.
     *
     * @param basicUser the user
     * @return the string
     */
    @ResponseBody
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String select(@RequestBody BasicUser basicUser) {
        System.out.println("find user name = "+ basicUser.getUserName());
        String result = basicUserMapper.selectUserName(basicUser.getUserName());
        System.out.println("result is → "+result);
        if (result == null) {
            System.out.println("callback is 0");
            return "0";
        }
        System.out.println("callback is 1");
        return "1";
    }


    /**
     * Select user name int.
     *
     * @param basicUser the user
     * @return the int
     */
    @ResponseBody
    @RequestMapping(value = "/selectUserName", method = RequestMethod.POST)
    public int selectUserName(@RequestBody BasicUser basicUser) {
        String userName = basicUser.getUserName();
        String userPassword = basicUser.getUserPassword();
        System.out.println(userName +"+"+ userPassword);

        int result = -1;

        //将输入的密码加密
        //String passwordMD5 = passwordMD5(userName, userPassword);

        //用户不存在
        if (basicUserMapper.selectUserName(userName) == null) {
//            return "用户不存在";
            result = 0;
            System.out.println("0 用户 "+ userName +" 不存在");
            return result;
            //用户存在，但密码输入错误
        }else if(!basicUserMapper.selectUserPassword(userName).equals(userPassword) ){
            System.out.println("1 账号或密码输入错误");
            result = 1;
            return result;
//            return "账号或密码输入错误";
        }else if(basicUserMapper.selectUserPassword(userName).equals(userPassword)&& basicUserMapper.selectUserName(userName).equals(userName)) {
            result = basicUserMapper.check(userName);
            System.out.println("2 成功登录");
            basicUserMapper.check(userName);
//            return "成功登录";
            return result;
        }
        System.out.println(result);
        return result;
    }

    /**
     * Add user string.
     *
     * @param basicUser the user
     * @return the string
     */
    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody BasicUser basicUser) {
        String userName = basicUser.getUserName();
        String userPassword = basicUser.getUserPassword();
        if(userName == basicUser.getUserName()){
            System.out.println(userName + " is already exist");
            return "0";
        }else{
            System.out.println(userName + "***" + userPassword);
            String passwordMD5 = passwordMD5(userName, userPassword);
//        userMapper.addUser(userName, passwordMD5);
            basicUserMapper.addUser(userName, userPassword);
            return "1";
        }
    }

    /**
     * Update psw result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result updatePsw(@RequestBody JSONObject data){
        Object o = data.get("id");
        if(o.toString().length() == 6){
            return new Result(4033, "此账号类型不允许在此页面修改密码,请联系管理员");
        }
        Object o1 = data.get("psw");
        Object o2 = data.get("userName");
        basicUserMapper.updatePsw(o, o1, o2);
        return new Result(200, "success");
    }

    /**
     * Query result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/query/EID")
    public Result query(@RequestBody JSONObject data){
        List<BasicUser> list = basicUserMapper.queryEID("enterpriseID");
        if (list.size() == 0){
            return new Result(2001, "暂无可绑定用户");
        }
        return new Result(list);
    }

    /**
     * Get eid result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/get/EID")
    public Result getEID(@RequestBody JSONObject data){
        List<BasicUser> list = basicUserMapper.getEID(data.getString("id"));
        if (list.size() == 0){
            return new Result(2001, "企业不存在或用户未绑定企业");
        }
        return new Result(list);
    }

    @ResponseBody
    @RequestMapping(value = "/updateTime")
    public Result updateTime() {
        Timestamp s = basicUserMapper.updateTime();
//        System.out.println("测试输出" + s);
        return new Result(s);
    }


    /**
     * Password md 5 string.
     *
     * @param userName     the user name
     * @param userPassword the user password
     * @return the string
     */
    public String passwordMD5(String userName, String userPassword) {
        // 需要加密的字符串
        String src = userName + userPassword;
        try {
            // 加密对象，指定加密方式
            MessageDigest md5 = MessageDigest.getInstance("md5");
            // 准备要加密的数据
            byte[] b = src.getBytes();
            // 加密：MD5加密一种被广泛使用的密码散列函数，
            // 可以产生出一个128位（16字节）的散列值（hash value），用于确保信息传输完整一致
            byte[] digest = md5.digest(b);
            // 十六进制的字符
            char[] chars = new char[]{'0', '1', '2', '3', '4', '5',
                    '6', '7', 'A', 'B', 'C', 'd', 'o', '*', '#', '/'};
            StringBuffer sb = new StringBuffer();
            // 处理成十六进制的字符串(通常)
            // 遍历加密后的密码，将每个元素向右位移4位，然后与15进行与运算(byte变成数字)
            for (byte bb : digest) {
                sb.append(chars[(bb >> 4) & 15]);
                sb.append(chars[bb & 15]);
            }
            // 打印加密后的字符串
            System.out.println(sb);
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
