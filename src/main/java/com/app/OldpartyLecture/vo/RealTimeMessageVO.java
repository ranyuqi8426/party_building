package com.app.OldpartyLecture.vo;

import com.app.util.page.SearchPageVO;

/**
 * 实时资讯手机VO
 * @author 冉玉琦
 * @date 2017年10月29日
 */
public class RealTimeMessageVO extends SearchPageVO{
	private int realtimeinfo_id;
	private int user_id;
	
	
	
	public int getRealtimeinfo_id() {
		return realtimeinfo_id;
	}
	public void setRealtimeinfo_id(int realtimeinfo_id) {
		this.realtimeinfo_id = realtimeinfo_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
