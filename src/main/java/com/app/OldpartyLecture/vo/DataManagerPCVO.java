package com.app.OldpartyLecture.vo;

import com.app.util.page.SearchPageVOPC;
/**
 * PC党课VO
 * @author 冉玉琦
 * @date 2017年10月29日
 */
public class DataManagerPCVO extends SearchPageVOPC{
	private String date_start;
	private String date_end;
	private String learning_data_title;
	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}
	public String getDate_end() {
		return date_end;
	}
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
	public String getLearning_data_title() {
		return learning_data_title;
	}
	public void setLearning_data_title(String learning_data_title) {
		this.learning_data_title = learning_data_title;
	}
}
