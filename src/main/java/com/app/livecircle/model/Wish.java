package com.app.livecircle.model;

import java.util.Date;

public class Wish {
	private int wish_id;// 主键
	private String wish_name;// 心愿标题
	private String wish_content;// 心愿内容
	private String wish_story;// 心愿故事
	private String wish_thank;// 感谢语(认领感言)
	private String wish_type;// 心愿状态（0、未认领 1、已认领）
	private String wish_username;// 联系人
	private String wish_phone;// 联系电话
	private String wish_img1;// 心愿图片1
	private String wish_img2;// 心愿图片2
	private String wish_img3;// 心愿图片3
	private String wish_imgnum;// 图片数量
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	
	
	private String create_name;// 创建人
	public int getWish_id() {
		return wish_id;
	}
	public void setWish_id(int wish_id) {
		this.wish_id = wish_id;
	}
	public String getWish_name() {
		return wish_name;
	}
	public void setWish_name(String wish_name) {
		this.wish_name = wish_name;
	}
	public String getWish_content() {
		return wish_content;
	}
	public void setWish_content(String wish_content) {
		this.wish_content = wish_content;
	}
	public String getWish_story() {
		return wish_story;
	}
	public void setWish_story(String wish_story) {
		this.wish_story = wish_story;
	}
	public String getWish_thank() {
		return wish_thank;
	}
	public void setWish_thank(String wish_thank) {
		this.wish_thank = wish_thank;
	}
	public String getWish_type() {
		return wish_type;
	}
	public void setWish_type(String wish_type) {
		this.wish_type = wish_type;
	}
	public String getWish_username() {
		return wish_username;
	}
	public void setWish_username(String wish_username) {
		this.wish_username = wish_username;
	}
	public String getWish_phone() {
		return wish_phone;
	}
	public void setWish_phone(String wish_phone) {
		this.wish_phone = wish_phone;
	}
	public String getWish_img1() {
		return wish_img1;
	}
	public void setWish_img1(String wish_img1) {
		this.wish_img1 = wish_img1;
	}
	public String getWish_img2() {
		return wish_img2;
	}
	public void setWish_img2(String wish_img2) {
		this.wish_img2 = wish_img2;
	}
	public String getWish_img3() {
		return wish_img3;
	}
	public void setWish_img3(String wish_img3) {
		this.wish_img3 = wish_img3;
	}
	public String getWish_imgnum() {
		return wish_imgnum;
	}
	public void setWish_imgnum(String wish_imgnum) {
		this.wish_imgnum = wish_imgnum;
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
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}

}


