package com.app.livecircle.model;

import java.util.Date;

public class Show {
	private int show_id;// 主键
	private String show_content;// 晒晒内容
	private String show_status;// 晒晒状态（1、创建成功2发布成功（审核））
	private String show_img1;// 图片1
	private String show_img2;// 图片2
	private String show_img3;// 图片3
	private String show_num;// 图片数
	private String show_position;// 位置信息
	private String create_cd;// 创建人
	private Date create_time;// 创建时间

	private String show_like_id;// 点赞id 
	
	private String user_name;// 真实姓名
	private String head_img_url;//头像
	private String like_num;//点赞数
	private String say_num;//评论数
	

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public String getShow_content() {
		return show_content;
	}

	public void setShow_content(String show_content) {
		this.show_content = show_content;
	}

	public String getShow_status() {
		return show_status;
	}

	public void setShow_status(String show_status) {
		this.show_status = show_status;
	}

	public String getShow_img1() {
		return show_img1;
	}

	public void setShow_img1(String show_img1) {
		this.show_img1 = show_img1;
	}

	public String getShow_img2() {
		return show_img2;
	}

	public void setShow_img2(String show_img2) {
		this.show_img2 = show_img2;
	}

	public String getShow_img3() {
		return show_img3;
	}

	public void setShow_img3(String show_img3) {
		this.show_img3 = show_img3;
	}

	public String getShow_num() {
		return show_num;
	}

	public void setShow_num(String show_num) {
		this.show_num = show_num;
	}

	public String getShow_position() {
		return show_position;
	}

	public void setShow_position(String show_position) {
		this.show_position = show_position;
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

	public String getShow_like_id() {
		return show_like_id;
	}

	public void setShow_like_id(String show_like_id) {
		this.show_like_id = show_like_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getHead_img_url() {
		return head_img_url;
	}

	public void setHead_img_url(String head_img_url) {
		this.head_img_url = head_img_url;
	}

	public String getLike_num() {
		return like_num;
	}

	public void setLike_num(String like_num) {
		this.like_num = like_num;
	}

	public String getSay_num() {
		return say_num;
	}

	public void setSay_num(String say_num) {
		this.say_num = say_num;
	}

}
