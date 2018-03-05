package com.app.userwork.model;

import java.util.Date;

public class LoginLog {
	private int userlogin_id;
	private String user_id;
	private String user_ip;
	private String userlogin_type;
	private Date userlogin_time1;
	public int getUserlogin_id() {
		return userlogin_id;
	}
	public void setUserlogin_id(int userlogin_id) {
		this.userlogin_id = userlogin_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getUserlogin_type() {
		return userlogin_type;
	}
	public void setUserlogin_type(String userlogin_type) {
		this.userlogin_type = userlogin_type;
	}
	public Date getUserlogin_time1() {
		return userlogin_time1;
	}
	public void setUserlogin_time1(Date userlogin_time1) {
		this.userlogin_time1 = userlogin_time1;
	}
	
	
}
