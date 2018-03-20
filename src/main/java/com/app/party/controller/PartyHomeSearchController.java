package com.app.party.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.party.model.PartyHomeSearch;
import com.app.party.service.PartyHomeSearchService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/partyHomeSearch")
@Controller
public class PartyHomeSearchController {
	
	@Autowired
	private PartyHomeSearchService partyHomeSearchService;


	/**
	 * 申请加入党组织列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String floor_id,String user_id) {
		{
			int flag = partyHomeSearchService.list(floor_id,user_id);
			String json = "";
			
			if (flag == 1) {
				json = JsonUtil.createOperaStr(true, "您已提交申请！");
			}else if (flag == 2) {
				json = JsonUtil.createOperaStr(true, "申请成功！");
			}else{
				json = JsonUtil.createOperaStr(false, "还未申请！");
			}
			WebUtil.out(response, json);
		}
	}
	
	/**
	 * 加入党组织
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,PartyHomeSearch partyHomeSearch) {
		{
			int flag = partyHomeSearchService.add(partyHomeSearch);
			String json = "";
			
			if (flag == 1) {
				json = JsonUtil.createOperaStr(true, "申请成功！");
			}else{
				json = JsonUtil.createOperaStr(false, "申请失败！");
			}
			WebUtil.out(response, json);
		}
	}

}
