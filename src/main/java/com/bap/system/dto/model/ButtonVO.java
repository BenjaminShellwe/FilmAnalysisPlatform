package com.bap.system.dto.model;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import lombok.Data;

@Data
public class ButtonVO {

    private Integer id;

    /**
     * 上级按钮ID
     */
    private String parentId;

    /**
     * 按钮编码
     */
    private String resources;

    /**
     * 按钮名称
     */
    private String title;

    /**
     * 按钮图标
     */
    private String icon;

}
