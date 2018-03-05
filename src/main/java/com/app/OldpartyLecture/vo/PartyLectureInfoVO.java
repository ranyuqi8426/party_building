package com.app.OldpartyLecture.vo;

import com.app.util.page.SearchPageVO;

public class PartyLectureInfoVO extends SearchPageVO{
	private 	int	   learning_data_id;  
	private 	String	   user_id;
	//类型 1视频 2 书刊 3 资料
	private String learning_type;
	//类型 1视频 2 书刊 3 资料
	private String learning_data_type;
	
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
	public String getLearning_data_type() {
		return learning_data_type;
	}
	public void setLearning_data_type(String learning_data_type) {
		this.learning_data_type = learning_data_type;
	}
	public String getLearning_type() {
		return learning_type;
	}
	public void setLearning_type(String learning_type) {
		this.learning_type = learning_type;
	}            
	
}
