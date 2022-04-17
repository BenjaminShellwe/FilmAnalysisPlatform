package com.bap.system.entity;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.bap.common.entity.BaseEntity;
import com.bap.common.validator.FieldRepeatValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>  系统管理-权限菜单表  </p>
 *
 */
@Data
@ApiModel(description = "系统管理-菜单表 ")
@TableName("system_url")
@FieldRepeatValidator(field = "resources", message = "菜单编码重复！")
public class SystemUrl extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@ApiModelProperty(value = "主键")
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	/**
	 * 类型 menu、button
	 */
	@ApiModelProperty(value = "类型 menu、button")
	@TableField("type")
	@NotBlank(message = "类型不能为空")
	private String type;
	/**
	 * url
	 */
	@ApiModelProperty(value = "url")
	@TableField("url")
	private String url;
	/**
	 * 上级菜单ID
	 */
	@ApiModelProperty(value = "上级菜单ID")
	@TableField("parent_id")
	private String parentId;
	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序")
	@TableField("sort_no")
	private Integer sortNo;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
