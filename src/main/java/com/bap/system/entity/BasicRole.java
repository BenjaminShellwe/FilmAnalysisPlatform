package com.bap.system.entity;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.bap.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity(name = "basic_role")
public class BasicRole extends BaseEntity<BasicRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value="id", type= IdType.AUTO)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ApiModelProperty(value = "角色名称")
    @TableField("role")
    @NotBlank(message = "角色名称不能为空")
    private String name;
    @ApiModelProperty(value = "角色编码")
    @TableField("code")
    @NotBlank(message = "角色编码不能为空")
    private String role;

    private String enterprisePermission;
    private String enterpriseAdd;
    private String enterpriseAlter;
    private String enterpriseQuery;
    private String enterpriseDelete;
    private String basicPermission;
    private String basicAdd;
    private String basicAlter;
    private String basicQuery;
    private String basicDelete;
    private String personalPermission;
    private String personalAdd;
    private String personalAlter;
    private String personalQuery;
    private String personalDelete;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets enterprise permission.
     *
     * @return the enterprise permission
     */
    public String getEnterprisePermission() {
        return enterprisePermission;
    }

    /**
     * Sets enterprise permission.
     *
     * @param enterprisePermission the enterprise permission
     */
    public void setEnterprisePermission(String enterprisePermission) {
        this.enterprisePermission = enterprisePermission;
    }

    /**
     * Gets enterprise add.
     *
     * @return the enterprise add
     */
    public String getEnterpriseAdd() {
        return enterpriseAdd;
    }

    /**
     * Sets enterprise add.
     *
     * @param enterpriseAdd the enterprise add
     */
    public void setEnterpriseAdd(String enterpriseAdd) {
        this.enterpriseAdd = enterpriseAdd;
    }

    /**
     * Gets enterprise alter.
     *
     * @return the enterprise alter
     */
    public String getEnterpriseAlter() {
        return enterpriseAlter;
    }

    /**
     * Sets enterprise alter.
     *
     * @param enterpriseAlter the enterprise alter
     */
    public void setEnterpriseAlter(String enterpriseAlter) {
        this.enterpriseAlter = enterpriseAlter;
    }

    /**
     * Gets enterprise query.
     *
     * @return the enterprise query
     */
    public String getEnterpriseQuery() {
        return enterpriseQuery;
    }

    /**
     * Sets enterprise query.
     *
     * @param enterpriseQuery the enterprise query
     */
    public void setEnterpriseQuery(String enterpriseQuery) {
        this.enterpriseQuery = enterpriseQuery;
    }

    /**
     * Gets enterprise delete.
     *
     * @return the enterprise delete
     */
    public String getEnterpriseDelete() {
        return enterpriseDelete;
    }

    /**
     * Sets enterprise delete.
     *
     * @param enterpriseDelete the enterprise delete
     */
    public void setEnterpriseDelete(String enterpriseDelete) {
        this.enterpriseDelete = enterpriseDelete;
    }

    /**
     * Gets basic permission.
     *
     * @return the basic permission
     */
    public String getBasicPermission() {
        return basicPermission;
    }

    /**
     * Sets basic permission.
     *
     * @param basicPermission the basic permission
     */
    public void setBasicPermission(String basicPermission) {
        this.basicPermission = basicPermission;
    }

    /**
     * Gets basic add.
     *
     * @return the basic add
     */
    public String getBasicAdd() {
        return basicAdd;
    }

    /**
     * Sets basic add.
     *
     * @param basicAdd the basic add
     */
    public void setBasicAdd(String basicAdd) {
        this.basicAdd = basicAdd;
    }

    /**
     * Gets basic alter.
     *
     * @return the basic alter
     */
    public String getBasicAlter() {
        return basicAlter;
    }

    /**
     * Sets basic alter.
     *
     * @param basicAlter the basic alter
     */
    public void setBasicAlter(String basicAlter) {
        this.basicAlter = basicAlter;
    }

    /**
     * Gets basic query.
     *
     * @return the basic query
     */
    public String getBasicQuery() {
        return basicQuery;
    }

    /**
     * Sets basic query.
     *
     * @param basicQuery the basic query
     */
    public void setBasicQuery(String basicQuery) {
        this.basicQuery = basicQuery;
    }

    /**
     * Gets basic delete.
     *
     * @return the basic delete
     */
    public String getBasicDelete() {
        return basicDelete;
    }

    /**
     * Sets basic delete.
     *
     * @param basicDelete the basic delete
     */
    public void setBasicDelete(String basicDelete) {
        this.basicDelete = basicDelete;
    }

    /**
     * Gets personal permission.
     *
     * @return the personal permission
     */
    public String getPersonalPermission() {
        return personalPermission;
    }

    /**
     * Sets personal permission.
     *
     * @param personalPermission the personal permission
     */
    public void setPersonalPermission(String personalPermission) {
        this.personalPermission = personalPermission;
    }

    /**
     * Gets personal add.
     *
     * @return the personal add
     */
    public String getPersonalAdd() {
        return personalAdd;
    }

    /**
     * Sets personal add.
     *
     * @param personalAdd the personal add
     */
    public void setPersonalAdd(String personalAdd) {
        this.personalAdd = personalAdd;
    }

    /**
     * Gets personal alter.
     *
     * @return the personal alter
     */
    public String getPersonalAlter() {
        return personalAlter;
    }

    /**
     * Sets personal alter.
     *
     * @param personalAlter the personal alter
     */
    public void setPersonalAlter(String personalAlter) {
        this.personalAlter = personalAlter;
    }

    /**
     * Gets personal query.
     *
     * @return the personal query
     */
    public String getPersonalQuery() {
        return personalQuery;
    }

    /**
     * Sets personal query.
     *
     * @param personalQuery the personal query
     */
    public void setPersonalQuery(String personalQuery) {
        this.personalQuery = personalQuery;
    }

    /**
     * Gets personal delete.
     *
     * @return the personal delete
     */
    public String getPersonalDelete() {
        return personalDelete;
    }

    /**
     * Sets personal delete.
     *
     * @param personalDelete the personal delete
     */
    public void setPersonalDelete(String personalDelete) {
        this.personalDelete = personalDelete;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
