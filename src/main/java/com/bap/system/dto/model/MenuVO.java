package com.bap.system.dto.model;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  <p> 权限-菜单 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/8/19 18:57
 */
@Data
public class MenuVO implements Serializable {

    private Integer id;

    /**
     * 上级菜单ID
     */
    private String parentId;

    /**
     * 菜单编码
     */
    private String resources;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单级别
     */
    private Integer level;

    /**
     * 菜单图标
     */
    private String icon;

    List<MenuVO> children = Lists.newArrayList();

}
