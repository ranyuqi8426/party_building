package com.app.livecircle.model;

import java.util.Date;

public class ShowLike {
	private int show_like_id;// 点赞id
	private int show_id;// 主键
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getShow_like_id() {
		return show_like_id;
	}
	public void setShow_like_id(int show_like_id) {
		this.show_like_id = show_like_id;
	}
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
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
