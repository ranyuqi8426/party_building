package com.app.OldpartyLecture.vo;

import com.app.util.page.SearchPageVO;
import com.app.util.page.SearchPageVOPC;

/**
 * 实时资讯PCVO
 * @author 冉玉琦
 * @date 2017年10月29日
 */
public class RealTimeMessagePCVO extends SearchPageVOPC{
	
	private String realtimeinfo_title;
	private String date_start;
	private String date_end;
	
	public String getRealtimeinfo_title() {
		return realtimeinfo_title;
	}
	public void setRealtimeinfo_title(String realtimeinfo_title) {
		this.realtimeinfo_title = realtimeinfo_title;
	}
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
}
