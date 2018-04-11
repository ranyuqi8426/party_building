package com.app.livecircle.model;

import java.util.Date;

public class AboutactivityType {
	private int aboutactivity_type_id;// 主键
	private String activity_type_code;// 活动类型代码
	private String activity_type_name;// 活动类型名称
	private Integer sort_num;// 排序位

	private String create_cd;// 创建人
	private Date create_time;// 创建时间

	public int getAboutactivity_type_id() {
		return aboutactivity_type_id;
	}

	public void setAboutactivity_type_id(int aboutactivity_type_id) {
		this.aboutactivity_type_id = aboutactivity_type_id;
	}

	public String getActivity_type_code() {
		return activity_type_code;
	}

	public void setActivity_type_code(String activity_type_code) {
		this.activity_type_code = activity_type_code;
	}

	public String getActivity_type_name() {
		return activity_type_name;
	}

	public void setActivity_type_name(String activity_type_name) {
		this.activity_type_name = activity_type_name;
	}

	public Integer getSort_num() {
		return sort_num;
	}

	public void setSort_num(Integer sort_num) {
		this.sort_num = sort_num;
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
