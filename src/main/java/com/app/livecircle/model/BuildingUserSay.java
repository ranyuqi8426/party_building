package com.app.livecircle.model;

import java.util.Date;

import com.app.userwork.model.UserInfo;

public class BuildingUserSay extends UserInfo {
	private int flooractivity_message_id;// 主键
	private int flooractivity_id;// 活动ID
	private String flooractivity_message;// 评论内容
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getFlooractivity_message_id() {
		return flooractivity_message_id;
	}
	public void setFlooractivity_message_id(int flooractivity_message_id) {
		this.flooractivity_message_id = flooractivity_message_id;
	}
	public int getFlooractivity_id() {
		return flooractivity_id;
	}
	public void setFlooractivity_id(int flooractivity_id) {
		this.flooractivity_id = flooractivity_id;
	}
	public String getFlooractivity_message() {
		return flooractivity_message;
	}
	public void setFlooractivity_message(String flooractivity_message) {
		this.flooractivity_message = flooractivity_message;
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

}
