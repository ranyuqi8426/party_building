package com.app.information.model;

import java.util.Date;

public class information {
private int news_id;
private String news_type;
private String news_title;
private String news_img;
private String content;
private String author;//作者
private String create_cd;
private Date create_time;
private String floor_id;

//是否点赞 y是  n否  仅供详情查询使用
private String isLike;

public int getNews_id() {
	return news_id;
}

public void setNews_id(int news_id) {
	this.news_id = news_id;
}

public String getNews_type() {
	return news_type;
}

public void setNews_type(String news_type) {
	this.news_type = news_type;
}

public String getNews_title() {
	return news_title;
}

public void setNews_title(String news_title) {
	this.news_title = news_title;
}

public String getNews_img() {
	return news_img;
}

public void setNews_img(String news_img) {
	this.news_img = news_img;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
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

public String getIsLike() {
	return isLike;
}

public void setIsLike(String isLike) {
	this.isLike = isLike;
}



}
