package com.app.Oldlogin.dao;

import java.util.Date;

public class SysSignLog {
	   private int sign_log_id;
	 private Date login_time;
	 private int user_id;
	public int getSign_log_id() {
		return sign_log_id;
	}
	public void setSign_log_id(int sign_log_id) {
		this.sign_log_id = sign_log_id;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
