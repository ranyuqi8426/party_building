package com.app.Oldservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.Oldservice.model.CreateParty;
import com.app.Oldservice.model.GoParty;
import com.app.Oldservice.model.WorkStation;
import com.app.Oldservice.service.WorkStationService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("WorkStation")
public class WorkStationController {
	@Autowired
	private WorkStationService WorkStationService;
	//楼宇工作站查询（地图标注）
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response, WorkStation WorkStation) {
		List<WorkStation> list = WorkStationService.list(WorkStation);
		String json = "";
		if (list != null && list.size() > 0) {
			json = JsonUtil.toJsonStr(list, true, "");
		} else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据");
		}
		WebUtil.out(response, json);

	}
	/**
	 * 入党/我是党员
	 * @param request
	 * @param response
	 * @param WorkStation
	 */
	@RequestMapping("/addparty")
	public void addparty(HttpServletRequest request, HttpServletResponse response, GoParty GoParty) {
		int flag =  WorkStationService.addparty(GoParty);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "提交成功！");
		} else {
			json = JsonUtil.createOperaStr(false, "提交失败，请重新提交。");
		}
		WebUtil.out(response, json);

	}
	/**
	 * 成立党组织
	 * @param request
	 * @param response
	 * @param WorkStation
	 */
	
	@RequestMapping("/addpartyteam")
	public void addpartyteam(HttpServletRequest request, HttpServletResponse response, CreateParty CreateParty) {
		int flag =  WorkStationService.addpartyteam(CreateParty);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "提交成功！");
		} else {
			json = JsonUtil.createOperaStr(false, "提交失败，请重新提交。");
		}
		WebUtil.out(response, json);

	}
}
