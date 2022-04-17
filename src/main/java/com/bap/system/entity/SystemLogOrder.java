package com.bap.system.entity;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Log system.
 */
@Entity(name = "system_log_order")
public class SystemLogOrder {
    @Id
    @Column(name = "model_requestID", nullable = false)
    private String model_requestID;
    private int id;
    private String date;
    private String model_serviceName;
    private String model_readWriteType;
    private String model_userName;
    private String model_accountName;
    private String model_realName;
    private String model_resourceType;
    private String model_resourceName;
    private String model_operationName;
    private String model_keyValue;

    /**
     * Gets model request id.
     *
     * @return the model request id
     */
    public String getModel_requestID() {
        return model_requestID;
    }

    /**
     * Sets model request id.
     *
     * @param model_requestID the model request id
     */
    public void setModel_requestID(String model_requestID) {
        this.model_requestID = model_requestID;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
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
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets model service name.
     *
     * @return the model service name
     */
    public String getModel_serviceName() {
        return model_serviceName;
    }

    /**
     * Sets model service name.
     *
     * @param model_serviceName the model service name
     */
    public void setModel_serviceName(String model_serviceName) {
        this.model_serviceName = model_serviceName;
    }

    /**
     * Gets model read write type.
     *
     * @return the model read write type
     */
    public String getModel_readWriteType() {
        return model_readWriteType;
    }

    /**
     * Sets model read write type.
     *
     * @param model_readWriteType the model read write type
     */
    public void setModel_readWriteType(String model_readWriteType) {
        this.model_readWriteType = model_readWriteType;
    }

    /**
     * Gets model user name.
     *
     * @return the model user name
     */
    public String getModel_userName() {
        return model_userName;
    }

    /**
     * Sets model user name.
     *
     * @param model_userName the model user name
     */
    public void setModel_userName(String model_userName) {
        this.model_userName = model_userName;
    }

    /**
     * Gets model account name.
     *
     * @return the model account name
     */
    public String getModel_accountName() {
        return model_accountName;
    }

    /**
     * Sets model account name.
     *
     * @param model_accountName the model account name
     */
    public void setModel_accountName(String model_accountName) {
        this.model_accountName = model_accountName;
    }

    /**
     * Gets model real name.
     *
     * @return the model real name
     */
    public String getModel_realName() {
        return model_realName;
    }

    /**
     * Sets model real name.
     *
     * @param model_realName the model real name
     */
    public void setModel_realName(String model_realName) {
        this.model_realName = model_realName;
    }

    /**
     * Gets model resource type.
     *
     * @return the model resource type
     */
    public String getModel_resourceType() {
        return model_resourceType;
    }

    /**
     * Sets model resource type.
     *
     * @param model_resourceType the model resource type
     */
    public void setModel_resourceType(String model_resourceType) {
        this.model_resourceType = model_resourceType;
    }

    /**
     * Gets model resource name.
     *
     * @return the model resource name
     */
    public String getModel_resourceName() {
        return model_resourceName;
    }

    /**
     * Sets model resource name.
     *
     * @param model_resourceName the model resource name
     */
    public void setModel_resourceName(String model_resourceName) {
        this.model_resourceName = model_resourceName;
    }

    /**
     * Gets model operation name.
     *
     * @return the model operation name
     */
    public String getModel_operationName() {
        return model_operationName;
    }

    /**
     * Sets model operation name.
     *
     * @param model_operationName the model operation name
     */
    public void setModel_operationName(String model_operationName) {
        this.model_operationName = model_operationName;
    }

    /**
     * Gets model key value.
     *
     * @return the model key value
     */
    public String getModel_keyValue() {
        return model_keyValue;
    }

    /**
     * Sets model key value.
     *
     * @param model_keyValue the model key value
     */
    public void setModel_keyValue(String model_keyValue) {
        this.model_keyValue = model_keyValue;
    }
}
