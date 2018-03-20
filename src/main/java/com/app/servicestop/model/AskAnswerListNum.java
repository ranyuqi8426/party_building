package com.app.servicestop.model;

/**
 * 咨询问答条数
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class AskAnswerListNum {
	private String ask_type;// 类型（1心理2健康3法律）
	private int num;// 咨询人
	public String getAsk_type() {
		return ask_type;
	}
	public void setAsk_type(String ask_type) {
		this.ask_type = ask_type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}
