package com.app.Oldservice.model;

import java.util.Date;

public class BuildingService {
	private int building_act_id;
	private int user_id;
	private String building_id;
	private String title;
	private String content;
	private int auditor_id;
	private String audit_status;
	private Date time;
	private String status;
	private String name; //楼宇名称
	private String username; //发布人
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(String audit_status) {
		this.audit_status = audit_status;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBuilding_act_id() {
		return building_act_id;
	}
	public void setBuilding_act_id(int building_act_id) {
		this.building_act_id = building_act_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAuditor_id() {
		return auditor_id;
	}
	public void setAuditor_id(int auditor_id) {
		this.auditor_id = auditor_id;
	}
}