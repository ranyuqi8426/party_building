package com.app.userwork.model;

import java.util.Date;

public class Collection {
	private int collection_id;// 主键
	private int user_id;// 用户id
	private String collection_content_id;// 收藏内容id
	private String collection_content;// 收藏内容
	private String collection_content_type;// 收藏内容类型(1楼宇活动2约吧活动3商家活动4时讯（资讯）)
	private String collection_content_url;// 收藏内容链接
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getCollection_id() {
		return collection_id;
	}
	public void setCollection_id(int collection_id) {
		this.collection_id = collection_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCollection_content_id() {
		return collection_content_id;
	}
	public void setCollection_content_id(String collection_content_id) {
		this.collection_content_id = collection_content_id;
	}
	public String getCollection_content() {
		return collection_content;
	}
	public void setCollection_content(String collection_content) {
		this.collection_content = collection_content;
	}
	public String getCollection_content_type() {
		return collection_content_type;
	}
	public void setCollection_content_type(String collection_content_type) {
		this.collection_content_type = collection_content_type;
	}
	public String getCollection_content_url() {
		return collection_content_url;
	}
	public void setCollection_content_url(String collection_content_url) {
		this.collection_content_url = collection_content_url;
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
