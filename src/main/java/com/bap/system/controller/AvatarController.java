package com.bap.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.entity.BasicAvatar;
import com.bap.system.service.AvatarService;
import com.bap.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The type Avatar controller.
 */
@Controller
@RequestMapping("/avatar")
public class AvatarController {

    /**
     * The Avatar service.
     */
    @Autowired
    AvatarService avatarService;

    /**
     * Insert result.
     *
     * @param data the data
     * @return the result
     */
    @RequestMapping("/insert")
    public Result Insert(BasicAvatar data){
        avatarService.insert(data);
        return new Result(200, "Success", "Data been changed.");
    }

    /**
     * Query by id result.
     *
     * @return the result
     */
    @RequestMapping("/query")
    public Result QueryByID(){
        avatarService.query(2022001);
        System.out.println("测试输出" + avatarService.query(2022001).getData());
        return new Result(200, "Success" );
    }

    /**
     * Show image.
     *
     * @param id       the id
     * @param response the response
     * @param request  the request
     * @throws IOException  the io exception
     * @throws SQLException the sql exception
     */
    @RequestMapping(value = "/showImage.do")
    public  void showImage(int id, HttpServletResponse response, HttpServletRequest request) throws IOException, SQLException {
        BasicAvatar basicAvatar =avatarService.query(id);
        if(null != basicAvatar){
            //从数据库读取出二进制数据……
            byte[] bb= basicAvatar.getImage();
            // 将图像输出到Servlet输出流中。
            ServletOutputStream sos = response.getOutputStream();
            sos.write(bb, 0, bb.length);
            sos.close();
        }
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
    }
}
