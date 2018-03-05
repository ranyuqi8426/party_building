package com.app.information.model;

import java.util.Date;

public class InformationLike {
//	private int news_like_id;
	private int news_id;
	private int create_cd;
	private Date create_time;
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getCreate_cd() {
		return create_cd;
	}
	public void setCreate_cd(int create_cd) {
		this.create_cd = create_cd;
	}
}
