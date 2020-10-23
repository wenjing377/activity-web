package com.wfuhui.modules.base.entity;

import java.io.Serializable;
import java.util.Date;

/**

 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Long id;
	// 微信openid
	private String openid;
	// 昵称
	private String nickname;
	// 头像
	private String avatarUrl;

	// 性别
	private String gender;

	// 创建时间
	private Date createTime;

	private String realName;

	private String mobile;

	private String email;
	
	private String userNo;
	
	private String schoolName;
	
	private String loginName;
	
	private String password;
	
	private String idCard;
	
	private String address;
	
	private String className;


	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：微信openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 获取：微信openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 设置：头像
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * 获取：头像
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email ) {
		this.email  = email ;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}

