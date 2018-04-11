package com.app.livecircle.model;

import java.util.Date;

public class WishStatus {
	private int wish_status_id;// 主键
	private int wish_id;// 心愿ID
	private String wish_status_cd;// 心愿状态代码
	private String wish_status_nm;// 心愿状态（每个心愿对应此表四条状态记录。1创建2审核3审核不通过4完成）
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getWish_status_id() {
		return wish_status_id;
	}
	public void setWish_status_id(int wish_status_id) {
		this.wish_status_id = wish_status_id;
	}
	public int getWish_id() {
		return wish_id;
	}
	public void setWish_id(int wish_id) {
		this.wish_id = wish_id;
	}
	public String getWish_status_cd() {
		return wish_status_cd;
	}
	public void setWish_status_cd(String wish_status_cd) {
		this.wish_status_cd = wish_status_cd;
	}
	public String getWish_status_nm() {
		return wish_status_nm;
	}
	public void setWish_status_nm(String wish_status_nm) {
		this.wish_status_nm = wish_status_nm;
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
