package com.app.Oldlifecircle.vo;

import java.util.Date;

import com.app.util.page.SearchPageVO;

public class HappyInfoShowVO extends SearchPageVO{
	private int show_id;
	private int user_id;
	//审核状态
	private String audit_status;
	//创建时间
	private String create_date_star;
	private String create_date_end;
	
	
	
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(String audit_status) {
		this.audit_status = audit_status;
	}
	public String getCreate_date_star() {
		return create_date_star;
	}
	public void setCreate_date_star(String create_date_star) {
		this.create_date_star = create_date_star;
	}
	public String getCreate_date_end() {
		return create_date_end;
	}
	public void setCreate_date_end(String create_date_end) {
		this.create_date_end = create_date_end;
	}
	
	
	
}
