package com.app.party.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.party.model.PartyMoney;
import com.app.party.service.PartyMoneyService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/partyMoney")
@Controller
public class PartyMoneyController {
	
	@Autowired
	private PartyMoneyService partyMoneyService;


	/**
	 * 党费缴纳列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String floor_id,String user_id,int pageSize ) {
		{
			List<PartyMoney> list = partyMoneyService.list(floor_id,user_id,pageSize);
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
	 * 党费缴纳
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,PartyMoney partyMoney) {
		{
			int flag = partyMoneyService.add(partyMoney);
			String json = "";
			
			if (flag == 1) {
				json = JsonUtil.createOperaStr(true, "缴纳成功！");
			}else{
				json = JsonUtil.createOperaStr(false, "缴纳失败！");
			}
			WebUtil.out(response, json);
		}
	}


}
