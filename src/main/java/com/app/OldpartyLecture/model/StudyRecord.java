package com.app.OldpartyLecture.model;

import java.util.Date;

public class StudyRecord {
	   private int id;
	   private int learning_data_id;
	   private int user_id;
	   private Date learning_begin_time;
	   private Date learning_end_time;
	   private int learning_point;
	 //1视频//3理论//2书籍
	   private String learning_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLearning_data_id() {
		return learning_data_id;
	}
	public void setLearning_data_id(int learning_data_id) {
		this.learning_data_id = learning_data_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getLearning_begin_time() {
		return learning_begin_time;
	}
	public void setLearning_begin_time(Date learning_begin_time) {
		this.learning_begin_time = learning_begin_time;
	}
	public Date getLearning_end_time() {
		return learning_end_time;
	}
	public void setLearning_end_time(Date learning_end_time) {
		this.learning_end_time = learning_end_time;
	}
	public int getLearning_point() {
		return learning_point;
	}
	public void setLearning_point(int learning_point) {
		this.learning_point = learning_point;
	}
	public String getLearning_type() {
		return learning_type;
	}
	public void setLearning_type(String learning_type) {
		this.learning_type = learning_type;
	}
}
