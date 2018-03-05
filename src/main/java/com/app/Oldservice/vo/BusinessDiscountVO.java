package com.app.Oldservice.vo;

import com.app.util.page.SearchPageVOPC;

public class BusinessDiscountVO extends SearchPageVOPC{
	private int user_id;
 private String title;
 private String date_start;
	private String date_end;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}
	public String getDate_end() {
		return date_end;
	}
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
