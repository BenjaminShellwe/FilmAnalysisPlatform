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
 * The type InformationEnterprisePerformance.
 */
@Entity(name = "information_enterprise_performance")
public class InformationEnterprisePerformance {

    @Id
    @Column(name = "affairID", nullable = false)
    private String affairID;
    private String name;
    private String department;
    private String rules;
    private String expression;
    private String proportion;
    private String completion;
    private String data1;
    private String data2;
    private String data3;
    private String data4;

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
     * Gets rules.
     *
     * @return the rules
     */
    public String getRules() {
        return rules;
    }

    /**
     * Sets rules.
     *
     * @param rules the rules
     */
    public void setRules(String rules) {
        this.rules = rules;
    }

    /**
     * Gets expression.
     *
     * @return the expression
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Sets expression.
     *
     * @param expression the expression
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * Gets proportion.
     *
     * @return the proportion
     */
    public String getProportion() {
        return proportion;
    }

    /**
     * Sets proportion.
     *
     * @param proportion the proportion
     */
    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    /**
     * Gets completion.
     *
     * @return the completion
     */
    public String getCompletion() {
        return completion;
    }

    /**
     * Sets completion.
     *
     * @param completion the completion
     */
    public void setCompletion(String completion) {
        this.completion = completion;
    }

    /**
     * Gets data 1.
     *
     * @return the data 1
     */
    public String getData1() {
        return data1;
    }

    /**
     * Sets data 1.
     *
     * @param data1 the data 1
     */
    public void setData1(String data1) {
        this.data1 = data1;
    }

    /**
     * Gets data 2.
     *
     * @return the data 2
     */
    public String getData2() {
        return data2;
    }

    /**
     * Sets data 2.
     *
     * @param data2 the data 2
     */
    public void setData2(String data2) {
        this.data2 = data2;
    }

    /**
     * Gets data 3.
     *
     * @return the data 3
     */
    public String getData3() {
        return data3;
    }

    /**
     * Sets data 3.
     *
     * @param data3 the data 3
     */
    public void setData3(String data3) {
        this.data3 = data3;
    }

    /**
     * Gets data 4.
     *
     * @return the data 4
     */
    public String getData4() {
        return data4;
    }

    /**
     * Sets data 4.
     *
     * @param data4 the data 4
     */
    public void setData4(String data4) {
        this.data4 = data4;
    }
}
