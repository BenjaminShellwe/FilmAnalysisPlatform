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
 * The type InformationEnterpriseEmployees.
 */
@Entity(name = "information_enterprise_employees")
public class InformationEnterpriseEmployees {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private String userID;
    private String realName;
    private String enterpriseID;
    private String enterprise;
    private String department;
    private String position;
    private String status;
    private String phone;
    private String remarks;
    private String political;
    private String birth;
    private String entry;
    private String salary;
    private String type;

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
     * Gets real name.
     *
     * @return the real name
     */
    public String getRealName() {
        return realName;
    }

    /**
     * Sets real name.
     *
     * @param realName the real name
     */
    public void setRealName(String realName) {
        this.realName = realName;
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
     * Gets remarks.
     *
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets remarks.
     *
     * @param remarks the remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets user id.
     *
     * @param userID the user id
     */
    public void setUserID(String userID) {
        this.userID = userID;
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
     * Gets political.
     *
     * @return the political
     */
    public String getPolitical() {
        return political;
    }

    /**
     * Sets political.
     *
     * @param political the political
     */
    public void setPolitical(String political) {
        this.political = political;
    }

    /**
     * Gets birth.
     *
     * @return the birth
     */
    public String getBirth() {
        return birth;
    }

    /**
     * Sets birth.
     *
     * @param birth the birth
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * Gets entry.
     *
     * @return the entry
     */
    public String getEntry() {
        return entry;
    }

    /**
     * Sets entry.
     *
     * @param entry the entry
     */
    public void setEntry(String entry) {
        this.entry = entry;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }
}
