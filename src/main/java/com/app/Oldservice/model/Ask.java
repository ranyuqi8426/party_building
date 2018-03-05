package com.app.Oldservice.model;

import java.util.Date;

public class Ask {

	private int ask_id;
	private String type;
	private int user_id;
	private String content;
	private int user_answer_id;
	//回答还是咨询
	private String kindof;
	private Date time;
	public int getAsk_id() {
		return ask_id;
	}
	public void setAsk_id(int ask_id) {
		this.ask_id = ask_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getUser_answer_id() {
		return user_answer_id;
	}
	public void setUser_answer_id(int user_answer_id) {
		this.user_answer_id = user_answer_id;
	}
	public String getKindof() {
		return kindof;
	}
	public void setKindof(String kindof) {
		this.kindof = kindof;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
	
}
