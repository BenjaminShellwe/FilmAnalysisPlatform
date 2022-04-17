package com.bap.system.entity;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import javax.persistence.*;

/**
 * The type SeniorVacancy coming.
 */
@Entity(name = "senior_vacancy_create")
public class SeniorVacancyCreate {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Id
    @Column(name = "affairID", nullable = false)
    private String affairID;
    private int verify;
    private String result;
    private String enterpriseID;
    private String departmentID;
    private String position;
    private String department;
    private String estimatedTime;
    private String name;
    private String sex;
    private String description;
    private String createdTime;
    private String address;
    private String phone;

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
     * Gets affair id.
     *
     * @return the affair id
     */
    public String getAffairID() {
        return affairID;
    }

    /**
     * Sets affair id.
     *
     * @param affairID the affair id
     */
    public void setAffairID(String affairID) {
        this.affairID = affairID;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets department.
     *
     * @param department the department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets estimated time.
     *
     * @return the estimated time
     */
    public String getEstimatedTime() {
        return estimatedTime;
    }

    /**
     * Sets estimated time.
     *
     * @param estimatedTime the estimated time
     */
    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
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
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets created time.
     *
     * @return the created time
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets created time.
     *
     * @param createdTime the created time
     */
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets verify.
     *
     * @return the verify
     */
    public int getVerify() {
        return verify;
    }

    /**
     * Sets verify.
     *
     * @param verify the verify
     */
    public void setVerify(int verify) {
        this.verify = verify;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(String result) {
        this.result = result;
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
}
