package com.wfuhui.modules.market.entity;

import java.io.Serializable;
import java.util.Date;

public class MassEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //社团名称
    private String massName;
    //联系人
    private String contacts;
    //社团联系人电话
    private String mobile;
    //社团简介
    private String remark;

    private String picUrl;
    //
    private Date createTime;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：社团名称
     */
    public void setMassName(String massName) {
        this.massName = massName;
    }
    /**
     * 获取：社团名称
     */
    public String getMassName() {
        return massName;
    }
    /**
     * 设置：联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
    /**
     * 获取：联系人
     */
    public String getContacts() {
        return contacts;
    }
    /**
     * 设置：
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * 获取：
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * 设置：
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * 获取：
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 设置：
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：
     */
    public Date getCreateTime() {
        return createTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

}

