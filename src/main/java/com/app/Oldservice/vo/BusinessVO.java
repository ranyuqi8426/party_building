package com.app.Oldservice.vo;

import java.util.Date;

import com.app.util.page.SearchPageVO;

public class BusinessVO extends SearchPageVO{
	private Date endTime;
	private int user_id;

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	

    
}
