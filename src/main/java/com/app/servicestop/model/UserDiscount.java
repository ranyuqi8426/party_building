package com.app.servicestop.model;

import java.util.Date;

public class UserDiscount extends Discount{
	private int user_discount_id;// 主键
	private int user_id;// 用户id
	private int discount_id;// 优惠券id
	private String operation_no;// 兑换码
	private Integer operation_user_cd;// 兑换操作人
	private String operation_status;// 兑换状态 0未兑换1已兑换
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	
	
	private String user_name;//用户翻译字段
	
	public int getUser_discount_id() {
		return user_discount_id;
	}
	public void setUser_discount_id(int user_discount_id) {
		this.user_discount_id = user_discount_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}
	public String getOperation_no() {
		return operation_no;
	}
	public void setOperation_no(String operation_no) {
		this.operation_no = operation_no;
	}
	public Integer getOperation_user_cd() {
		return operation_user_cd;
	}
	public void setOperation_user_cd(Integer operation_user_cd) {
		this.operation_user_cd = operation_user_cd;
	}
	public String getOperation_status() {
		return operation_status;
	}
	public void setOperation_status(String operation_status) {
		this.operation_status = operation_status;
	}
	public String getCreate_cd() {
		return create_cd;
	}
	public void setCreate_cd(String create_cd) {
		this.create_cd = create_cd;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
