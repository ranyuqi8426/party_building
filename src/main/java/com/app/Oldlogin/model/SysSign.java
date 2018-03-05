package com.app.Oldlogin.model;

import java.util.Date;

public class SysSign {
	   private int sign_id;
	   private int user_id;
	   private Date last_login_date;
	   private int total_times;
	   private int continue_times;
	public int getSign_id() {
		return sign_id;
	}
	public void setSign_id(int sign_id) {
		this.sign_id = sign_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}
	public int getTotal_times() {
		return total_times;
	}
	public void setTotal_times(int total_times) {
		this.total_times = total_times;
	}
	public int getContinue_times() {
		return continue_times;
	}
	public void setContinue_times(int continue_times) {
		this.continue_times = continue_times;
	}
	   
	   
}
