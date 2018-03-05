package com.app.OldpartyLecture.model;

import java.util.Date;

public class PartyLectureInfo {
	private 	int	   	   learning_data_id;  
	private 	String	   user_id;            
	private 	String	   learning_data_title;       
	private 	String	   learning_data_url;  
	private 	String	   learning_content;       
	private 	String	   learning_pic_url;  
	private 	String	   learning_data_type;       
	private 	int	   create_user_id;  
	private	 Date	   create_date;   
	 private String learning_study_id;
	//收藏Id
	private String collection_id;
	//创建者
	private String create_name;
	//查看数
	private int read_num = 0;
	//学习记录id
	private int id ;
		
	public int getLearning_data_id() {
		return learning_data_id;
	}
	public void setLearning_data_id(int learning_data_id) {
		this.learning_data_id = learning_data_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getCollection_id() {
		return collection_id;
	}
	public void setCollection_id(String collection_id) {
		this.collection_id = collection_id;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	public int getRead_num() {
		return read_num;
	}
	public void setRead_num(int read_num) {
		this.read_num = read_num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLearning_study_id() {
		return learning_study_id;
	}
	public void setLearning_study_id(String learning_study_id) {
		this.learning_study_id = learning_study_id;
	}
	
	
	
	

}
