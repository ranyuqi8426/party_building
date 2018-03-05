package com.app.OldpartyLecture.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class DataManagerPC {
	private int learning_data_id;
	private String learning_data_title;
	private String learning_data_url;
	private String learning_content;
	private String learning_pic_url;
	private String learning_data_type;
	private int create_user_id;
	private Date create_date;
	
	
	private MultipartFile learning_data;
	private MultipartFile learning_pic;
	
	private String create_user_name;
	
	public int getLearning_data_id() {
		return learning_data_id;
	}
	public void setLearning_data_id(int learning_data_id) {
		this.learning_data_id = learning_data_id;
	}
	public String getLearning_data_title() {
		return learning_data_title;
	}
	public void setLearning_data_title(String learning_data_title) {
		this.learning_data_title = learning_data_title;
	}
	public String getLearning_data_url() {
		return learning_data_url;
	}
	public void setLearning_data_url(String learning_data_url) {
		this.learning_data_url = learning_data_url;
	}
	public String getLearning_content() {
		return learning_content;
	}
	public void setLearning_content(String learning_content) {
		this.learning_content = learning_content;
	}
	public String getLearning_pic_url() {
		return learning_pic_url;
	}
	public void setLearning_pic_url(String learning_pic_url) {
		this.learning_pic_url = learning_pic_url;
	}
	public String getLearning_data_type() {
		return learning_data_type;
	}
	public void setLearning_data_type(String learning_data_type) {
		this.learning_data_type = learning_data_type;
	}
	public int getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(int create_user_id) {
		this.create_user_id = create_user_id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public MultipartFile getLearning_data() {
		return learning_data;
	}
	public void setLearning_data(MultipartFile learning_data) {
		this.learning_data = learning_data;
	}
	public MultipartFile getLearning_pic() {
		return learning_pic;
	}
	public void setLearning_pic(MultipartFile learning_pic) {
		this.learning_pic = learning_pic;
	}
	public String getCreate_user_name() {
		return create_user_name;
	}
	public void setCreate_user_name(String create_user_name) {
		this.create_user_name = create_user_name;
	}

}
