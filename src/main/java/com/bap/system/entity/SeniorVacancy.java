package com.bap.system.entity;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

/**
 * The type SeniorVacancy.
 */
@Entity(name = "senior_vacancy")
public class SeniorVacancy {

    @Id
    @Column(name = "affairID", nullable = false)
    private String affairID;
    private String position;
    private String positionStatus;
    private String department;
    private String departmentID;
    private String enterpriseID;
    private String description;
    private Date createdTime;
    private Date deadline;
    private String salary;
    private String requirement;
    private String type;

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
     * Gets position status.
     *
     * @return the position status
     */
    public String getPositionStatus() {
        return positionStatus;
    }

    /**
     * Sets position status.
     *
     * @param positionStatus the position status
     */
    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
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
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets created time.
     *
     * @param createdTime the created time
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Gets deadline.
     *
     * @return the deadline
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * Sets deadline.
     *
     * @param deadline the deadline
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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
     * Gets requirement.
     *
     * @return the requirement
     */
    public String getRequirement() {
        return requirement;
    }

    /**
     * Sets requirement.
     *
     * @param requirement the requirement
     */
    public void setRequirement(String requirement) {
        this.requirement = requirement;
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
}
