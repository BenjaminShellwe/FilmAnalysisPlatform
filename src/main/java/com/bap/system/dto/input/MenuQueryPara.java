package com.bap.system.dto.input;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import com.bap.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统管理-菜单表 查询参数
 *
 * @author: zhengqing
 * @description:
 * @date: 2019-08-19
 */
@Data
@ApiModel(description = "系统管理-菜单表 查询参数")
public class MenuQueryPara extends BasePageQuery{
    @ApiModelProperty(value = "id")
    private Integer id;
}
