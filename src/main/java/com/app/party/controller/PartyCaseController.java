package com.app.party.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.party.model.PartyCase;
import com.app.party.service.PartyCaseService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/partycase")
@Controller
public class PartyCaseController {
	
	@Autowired
	private PartyCaseService partyCaseService;


	/**
	 * 身边榜样列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String floorid,int pageSize,String isDop) {
		{
			List<PartyCase> list = partyCaseService.list(floorid,pageSize,isDop);
			String json = "";
			
			if (list != null && list.size()>0) {
				json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}
	
	/**
	 * 身边榜样详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response,String user_id,String list_id) {
		{
			PartyCase information = partyCaseService.get(list_id);
			String json = "";
			
			if (information != null) {
				json = JsonUtil.toJsonStr(information, true, "");
			}else {
				json = JsonUtil.toJsonStr(information, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}


}
