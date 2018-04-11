package com.app.livecircle.model;

import java.util.Date;

public class AboutactivityUser {
	private int aboutactivity_relation_id;// 主键
	private int activity_id;// 活动ID
	private String name;// 姓名
	private String company;// 公司
	private String phone;// 手机号

	private String create_cd;// 创建人
	private Date create_time;// 创建时间

	

	public int getAboutactivity_relation_id() {
		return aboutactivity_relation_id;
	}

	public void setAboutactivity_relation_id(int aboutactivity_relation_id) {
		this.aboutactivity_relation_id = aboutactivity_relation_id;
	}

	public int getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
