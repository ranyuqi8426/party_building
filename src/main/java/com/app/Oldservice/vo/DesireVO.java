package com.app.Oldservice.vo;

import java.util.Date;

import com.app.util.page.SearchPageVO;

public class DesireVO extends SearchPageVO{
	private int want_id;
	private int user_id;
	private int finish_id;
	private Date create_time;
	private String status;
	private String audit_status;
	

	public String getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(String audit_status) {
		this.audit_status = audit_status;
	}
	public int getWant_id() {
		return want_id;
	}
	public void setWant_id(int want_id) {
		this.want_id = want_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFinish_id() {
		return finish_id;
	}
	public void setFinish_id(int finish_id) {
		this.finish_id = finish_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
