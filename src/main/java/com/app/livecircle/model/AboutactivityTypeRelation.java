package com.app.livecircle.model;

import java.util.Date;

public class AboutactivityTypeRelation extends AboutactivityType {
	private int typerelation_id;// 主键
	private int aboutactivity_type_id;// 活动类型ID
	private int user_id;// 用户ID

	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getTyperelation_id() {
		return typerelation_id;
	}
	public void setTyperelation_id(int typerelation_id) {
		this.typerelation_id = typerelation_id;
	}
	public int getAboutactivity_type_id() {
		return aboutactivity_type_id;
	}
	public void setAboutactivity_type_id(int aboutactivity_type_id) {
		this.aboutactivity_type_id = aboutactivity_type_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
