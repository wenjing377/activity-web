package com.wfuhui.modules.market.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ActivityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 标题
	private String title;
	// 活动内容
	private String content;
	// 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date beginTime;
	// 结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	// 状态：2活动结束，1活动中
	private Integer status;

	// 创建时间
	private Date createTime;
	// 活动人数
	private Integer totalNumber;
	// 店铺id
	private Long storeId;

	private Integer joinNumber;

	private Integer categoryId;

	private String picUrl;

	private String resultPicUrl;

	private Integer type;

	private Integer category;

	private String massName;

	private String schoolName;
	private String adress;

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	private Integer flag;
	private Integer volunteerTime;

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置：活动内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取：活动内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置：开始时间
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 获取：开始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 设置：状态：0活动结束，1活动中
	 */

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态：2活动结束，1活动中
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：活动人数
	 */
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	/**
	 * 获取：活动人数
	 */
	public Integer getTotalNumber() {
		return totalNumber;
	}

	/**
	 * 设置：店铺id
	 */
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	/**
	 * 获取：店铺id
	 */
	public Long getStoreId() {
		return storeId;
	}

	public void setVolunteerTime(Integer volunteerTime) {
		this.volunteerTime = volunteerTime;
	}

	/**
	 * 获取志愿服务时间：
	 */
	public Integer getVolunteerTime() {
		return volunteerTime;
	}

	public Integer getJoinNumber() {
		if(joinNumber == null) {
			return 0;
		}
		return joinNumber;
	}

	public void setJoinNumber(Integer joinNumber) {
		this.joinNumber = joinNumber;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getResultPicUrl() {
		return resultPicUrl;
	}

	public void setResultPicUrl(String resultPicUrl) {
		this.resultPicUrl = resultPicUrl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getMassName() {
		return massName;
	}

	public void setMassName(String massName) {
		this.massName = massName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
