package com.app.Oldlogin.model;

import java.util.Date;

public class SysLoginLog {
	private int userlogin_id;
	private int user_id;
	private Date login_date;
	private String login_location;
	private String login_ip;
	public int getUserlogin_id() {
		return userlogin_id;
	}
	public void setUserlogin_id(int userlogin_id) {
		this.userlogin_id = userlogin_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getLogin_date() {
		return login_date;
	}
	public void setLogin_date(Date login_date) {
		this.login_date = login_date;
	}
	public String getLogin_location() {
		return login_location;
	}
	public void setLogin_location(String login_location) {
		this.login_location = login_location;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	
}
