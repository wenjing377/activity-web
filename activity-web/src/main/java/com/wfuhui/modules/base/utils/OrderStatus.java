package com.wfuhui.modules.base.utils;

public enum OrderStatus {
	CREATE(1, "代付款");
	
	private Integer id;
	private String name;
	
	
	OrderStatus(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
}
