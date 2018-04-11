package com.app.userwork.model;

import java.util.Date;

public class UserPointRecord {
	private int party_apply_id;// 主键
	private String apply_name;// 用户名称
	private String apply_age;// 获得积分（获得为+消费为-）
	private String apply_phone;// 获得方式（1签到2消费）
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getParty_apply_id() {
		return party_apply_id;
	}
	public void setParty_apply_id(int party_apply_id) {
		this.party_apply_id = party_apply_id;
	}
	public String getApply_name() {
		return apply_name;
	}
	public void setApply_name(String apply_name) {
		this.apply_name = apply_name;
	}
	public String getApply_age() {
		return apply_age;
	}
	public void setApply_age(String apply_age) {
		this.apply_age = apply_age;
	}
	public String getApply_phone() {
		return apply_phone;
	}
	public void setApply_phone(String apply_phone) {
		this.apply_phone = apply_phone;
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
