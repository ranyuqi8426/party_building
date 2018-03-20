package com.app.servicestop.model;

import java.util.Date;

/**
 * 咨询问答
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class AskAnswer {
	private int ask_answer_id;// 主键
	private Integer floor_id;// 楼宇ID
	private String ask_type;// 类型（1心理2健康3法律）
	private Integer ask_user_id;// 咨询人
	private String ask_content;// 咨询问题
	private Integer answer_user_id;// 回答人
	private String answer_content;// 回答问题
	private String answer_status;// 状态0未回答1已回答
	private Date ask_time;// 提问时间
	private Date answer_time;// 回答时间
	public int getAsk_answer_id() {
		return ask_answer_id;
	}
	public void setAsk_answer_id(int ask_answer_id) {
		this.ask_answer_id = ask_answer_id;
	}
	public Integer getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(Integer floor_id) {
		this.floor_id = floor_id;
	}
	public String getAsk_type() {
		return ask_type;
	}
	public void setAsk_type(String ask_type) {
		this.ask_type = ask_type;
	}
	public Integer getAsk_user_id() {
		return ask_user_id;
	}
	public void setAsk_user_id(Integer ask_user_id) {
		this.ask_user_id = ask_user_id;
	}
	public String getAsk_content() {
		return ask_content;
	}
	public void setAsk_content(String ask_content) {
		this.ask_content = ask_content;
	}
	public Integer getAnswer_user_id() {
		return answer_user_id;
	}
	public void setAnswer_user_id(Integer answer_user_id) {
		this.answer_user_id = answer_user_id;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public String getAnswer_status() {
		return answer_status;
	}
	public void setAnswer_status(String answer_status) {
		this.answer_status = answer_status;
	}
	public Date getAsk_time() {
		return ask_time;
	}
	public void setAsk_time(Date ask_time) {
		this.ask_time = ask_time;
	}
	public Date getAnswer_time() {
		return answer_time;
	}
	public void setAnswer_time(Date answer_time) {
		this.answer_time = answer_time;
	}

}
