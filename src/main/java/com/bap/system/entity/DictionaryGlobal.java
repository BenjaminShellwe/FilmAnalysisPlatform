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
 * The type Dictionary.
 */
@Entity(name = "dictionary_global")
public class DictionaryGlobal {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private String prefix;
    private String uniqueID;
    private String typeCode;
    private String typeName;
    private int valueID;
    private String valueName;
    private String valueStatus;
    private String description;
    private String editable;
    private String type;

    /**
     * Gets prefix.
     *
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets prefix.
     *
     * @param prefix the prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

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
     * Gets unique id.
     *
     * @return the unique id
     */
    public String getUniqueID() {
        return uniqueID;
    }

    /**
     * Sets unique id.
     *
     * @param uniqueID the unique id
     */
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    /**
     * Gets type code.
     *
     * @return the type code
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * Sets type code.
     *
     * @param typeCode the type code
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * Gets type name.
     *
     * @return the type name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets type name.
     *
     * @param typeName the type name
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * Gets value id.
     *
     * @return the value id
     */
    public int getValueID() {
        return valueID;
    }

    /**
     * Sets value id.
     *
     * @param valueID the value id
     */
    public void setValueID(int valueID) {
        this.valueID = valueID;
    }

    /**
     * Gets value name.
     *
     * @return the value name
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * Sets value name.
     *
     * @param valueName the value name
     */
    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    /**
     * Gets value status.
     *
     * @return the value status
     */
    public String getValueStatus() {
        return valueStatus;
    }

    /**
     * Sets value status.
     *
     * @param valueStatus the value status
     */
    public void setValueStatus(String valueStatus) {
        this.valueStatus = valueStatus;
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
     * Gets editable.
     *
     * @return the editable
     */
    public String getEditable() {
        return editable;
    }

    /**
     * Sets editable.
     *
     * @param editable the editable
     */
    public void setEditable(String editable) {
        this.editable = editable;
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

    @Override
    public String toString() {
        return "User{" + "prefix = " + prefix + ", id = " + id +
                     ", uniqueID = " + uniqueID + ", typeCode = " + typeCode +
                     ", typeName=" + typeName + ", valueID = " + valueID +
                     ", valueName = " + valueName + ", valueStatus = " + valueStatus +
                     ", description = " + description + ", editable = " + editable +
                     ", type = " + type +
                '}';
    }
}
