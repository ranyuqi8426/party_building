package com.app.livecircle.model;

import java.util.Date;

import com.app.userwork.model.UserInfo;

public class BuildingUser extends UserInfo {
	private int flooractivity_relation_id;// 主键
	private int flooractivity_id;// 活动ID
	private String name;// 姓名
	private String phone;// 手机
	private String company;// 公司
	private String mailbox;// 邮箱
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getFlooractivity_relation_id() {
		return flooractivity_relation_id;
	}
	public void setFlooractivity_relation_id(int flooractivity_relation_id) {
		this.flooractivity_relation_id = flooractivity_relation_id;
	}
	public int getFlooractivity_id() {
		return flooractivity_id;
	}
	public void setFlooractivity_id(int flooractivity_id) {
		this.flooractivity_id = flooractivity_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
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
