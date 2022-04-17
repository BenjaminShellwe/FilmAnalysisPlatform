package com.bap.system.entity;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type InformationEnterpriseDepartment.
 */
@Entity(name = "information_enterprise_department")
public class InformationEnterpriseDepartment {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Id
    @Column(name = "departmentID", nullable = false)
    private String departmentID;
    private String name;
    private String enterpriseID;
    private String enterprise;
    private String UIDD;
    private String director;
    private String phoneD;
    private String UIDM;
    private String manager;
    private String phoneM;
    private String departmentStatus;

    /**
     * Gets id.
     *
     * @return the id
     */
    @Id
    public int getId() {
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
     * Gets department id.
     *
     * @return the department id
     */
    public String getDepartmentID() {
        return departmentID;
    }

    /**
     * Sets department id.
     *
     * @param departmentID the department id
     */
    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets enterprise id.
     *
     * @return the enterprise id
     */
    public String getEnterpriseID() {
        return enterpriseID;
    }

    /**
     * Sets enterprise id.
     *
     * @param enterpriseID the enterprise id
     */
    public void setEnterpriseID(String enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    /**
     * Gets enterprise.
     *
     * @return the enterprise
     */
    public String getEnterprise() {
        return enterprise;
    }

    /**
     * Sets enterprise.
     *
     * @param enterprise the enterprise
     */
    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    /**
     * Gets uidd.
     *
     * @return the uidd
     */
    public String getUIDD() {
        return UIDD;
    }

    /**
     * Sets uidd.
     *
     * @param UIDD the uidd
     */
    public void setUIDD(String UIDD) {
        this.UIDD = UIDD;
    }

    /**
     * Gets director.
     *
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets director.
     *
     * @param director the director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets phone d.
     *
     * @return the phone d
     */
    public String getPhoneD() {
        return phoneD;
    }

    /**
     * Sets phone d.
     *
     * @param phoneD the phone d
     */
    public void setPhoneD(String phoneD) {
        this.phoneD = phoneD;
    }

    /**
     * Gets uidm.
     *
     * @return the uidm
     */
    public String getUIDM() {
        return UIDM;
    }

    /**
     * Sets uidm.
     *
     * @param UIDM the uidm
     */
    public void setUIDM(String UIDM) {
        this.UIDM = UIDM;
    }

    /**
     * Gets manager.
     *
     * @return the manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * Sets manager.
     *
     * @param manager the manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Gets phone m.
     *
     * @return the phone m
     */
    public String getPhoneM() {
        return phoneM;
    }

    /**
     * Sets phone m.
     *
     * @param phoneM the phone m
     */
    public void setPhoneM(String phoneM) {
        this.phoneM = phoneM;
    }

    /**
     * Gets department status.
     *
     * @return the department status
     */
    public String getDepartmentStatus() {
        return departmentStatus;
    }

    /**
     * Sets department status.
     *
     * @param departmentStatus the department status
     */
    public void setDepartmentStatus(String departmentStatus) {
        this.departmentStatus = departmentStatus;
    }
}
