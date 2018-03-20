package com.app.servicestop.model;

import java.util.Date;

public class Policy {
	private int policy_id;// 主键
	private String policy_type;// 政策类型1 白领 2企业
	private String policy_status;// 状态标记：1未发布，2已发布
	private String policy_name;// 标题
	private String policy_content;// 内容
	private String policy_img;// 图片
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	private String floor_id;// 楼宇ID
	public int getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}
	public String getPolicy_type() {
		return policy_type;
	}
	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}
	public String getPolicy_status() {
		return policy_status;
	}
	public void setPolicy_status(String policy_status) {
		this.policy_status = policy_status;
	}
	public String getPolicy_name() {
		return policy_name;
	}
	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}
	public String getPolicy_content() {
		return policy_content;
	}
	public void setPolicy_content(String policy_content) {
		this.policy_content = policy_content;
	}
	public String getPolicy_img() {
		return policy_img;
	}
	public void setPolicy_img(String policy_img) {
		this.policy_img = policy_img;
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
	public String getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(String floor_id) {
		this.floor_id = floor_id;
	}
	
	
}
