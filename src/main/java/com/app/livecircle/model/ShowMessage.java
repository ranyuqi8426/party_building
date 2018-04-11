package com.app.livecircle.model;

import java.util.Date;

public class ShowMessage {
	private int show_message_id;// id
	private int show_id;// 主键
	private String show_message;//评论消息
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
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
	public int getShow_message_id() {
		return show_message_id;
	}
	public void setShow_message_id(int show_message_id) {
		this.show_message_id = show_message_id;
	}
	public String getShow_message() {
		return show_message;
	}
	public void setShow_message(String show_message) {
		this.show_message = show_message;
	}

	

	

}
