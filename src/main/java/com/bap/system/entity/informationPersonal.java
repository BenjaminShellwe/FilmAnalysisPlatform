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
 * The type informationPersonal.
 */
@Entity(name = "information_personal")
public class informationPersonal {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private int userID;
    private String realName;
    private String nickName;
    private String phone;
    private String sex;
    private String occupationStatus;
    private String enterprise;
    private String createTime;
    private String birth;
    private String habitation;
    private String address;
    private String remarks;
    private String wechat;
    private String homeUrl;
    private String qq;

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
     * Gets nick name.
     *
     * @return the nick name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets nick name.
     *
     * @param nickName the nick name
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
     * Gets occupation status.
     *
     * @return the occupation status
     */
    public String getOccupationStatus() {
        return occupationStatus;
    }

    /**
     * Sets occupation status.
     *
     * @param occupationStatus the occupation status
     */
    public void setOccupationStatus(String occupationStatus) {
        this.occupationStatus = occupationStatus;
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
     * Gets create time.
     *
     * @return the create time
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Sets create time.
     *
     * @param createTime the create time
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
     * Gets habitation.
     *
     * @return the habitation
     */
    public String getHabitation() {
        return habitation;
    }

    /**
     * Sets habitation.
     *
     * @param habitation the habitation
     */
    public void setHabitation(String habitation) {
        this.habitation = habitation;
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
     * Gets wechat.
     *
     * @return the wechat
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * Sets wechat.
     *
     * @param wechat the wechat
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * Gets home url.
     *
     * @return the home url
     */
    public String getHomeUrl() {
        return homeUrl;
    }

    /**
     * Sets home url.
     *
     * @param homeUrl the home url
     */
    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    /**
     * Gets qq.
     *
     * @return the qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * Sets qq.
     *
     * @param qq the qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets user id.
     *
     * @param userID the user id
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
}
