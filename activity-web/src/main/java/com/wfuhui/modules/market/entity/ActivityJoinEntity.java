package com.wfuhui.modules.market.entity;

import java.io.Serializable;
import java.util.Date;

import com.wfuhui.modules.base.entity.UserEntity;

/**
 * 活动报名
 * 

 */
public class ActivityJoinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 会员id
	private Integer memberId;
	// 活动id
	private Integer activityId;
	
	
	private ActivityEntity activity;
	
	// 店铺id
	private Integer storeId;

	private String realName;

	private String mobile;

	private String email;

	private String userNo;

	private String age;

	private Integer schoolId;
	
	private String schoolName;

	private Integer channelId;
	
	private String channelName;
	
	private String address;
	
	// 创建时间
	private Date createTime;
	
	private Integer status;
	
	private UserEntity user;

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
	 * 设置：会员id
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取：会员id
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * 设置：活动id
	 */
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	/**
	 * 获取：活动id
	 */
	public Integer getActivityId() {
		return activityId;
	}

	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：店铺id
	 */
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	/**
	 * 获取：店铺id
	 */
	public Integer getStoreId() {
		return storeId;
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

	public String getEmail () {
		return email ;
	}

	public void setEmail (String email ) {
		this.email  = email ;
	}

	public String getUserNo () {
		return userNo ;
	}

	public void setUserNo (String userNo ) {
		this.userNo  = userNo ;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public ActivityEntity getActivity() {
		return activity;
	}

	public void setActivity(ActivityEntity activity) {
		this.activity = activity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
