package com.app.userwork.model;

import java.util.Date;

public class UserSign {
	private int user_id;// 签到用户
	private Date sign_time;// 签到时间
	private String continuity_sign_num;//本月连续签到数
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getSign_time() {
		return sign_time;
	}
	public void setSign_time(Date sign_time) {
		this.sign_time = sign_time;
	}
	public String getContinuity_sign_num() {
		return continuity_sign_num;
	}
	public void setContinuity_sign_num(String continuity_sign_num) {
		this.continuity_sign_num = continuity_sign_num;
	}


	
}
