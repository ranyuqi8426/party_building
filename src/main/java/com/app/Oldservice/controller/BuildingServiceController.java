package com.app.Oldservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.Oldservice.model.Ask;
import com.app.Oldservice.model.BuildingInfo;
import com.app.Oldservice.model.BuildingService;
import com.app.Oldservice.service.BuildingServiceService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("service/buildingService")
public class BuildingServiceController {
	@Autowired
	private BuildingServiceService buildingServiceService;
	//楼宇查询（前台楼宇列表）
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response, BuildingInfo buildingInfo) {
		List<BuildingInfo> list = buildingServiceService.list(buildingInfo);
		String json = "";
		if (list != null && list.size() > 0) {
			json = JsonUtil.toJsonStr(list, true, "");
		} else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据");
		}
		WebUtil.out(response, json);

	}
	//楼宇服务查询
	@RequestMapping("/getOne")
	public void ServiceList(HttpServletRequest request, HttpServletResponse response, BuildingInfo buildingInfo) {
		List<BuildingService> list = buildingServiceService.ServiceList(buildingInfo);
		String json = "";
		if (list != null && list.size() > 0) {
			json = JsonUtil.toJsonStr(list, true, "");
		} else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据");
		}
		WebUtil.out(response, json);

	}
	
	//楼宇服务发布getOne
	@RequestMapping("/publishBuildingServcice")
	public void add(HttpServletRequest request, HttpServletResponse response, BuildingService buildingService) {
		int flag = buildingServiceService.add(buildingService);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "发布成功！");
		} else {
			json = JsonUtil.createOperaStr(false, "发布失败，请重新发布。");
		}
		WebUtil.out(response, json);
	}
	
	//咨询信息查询
	@RequestMapping("/askList")
	public void askList(HttpServletRequest request, HttpServletResponse response, Ask ask) {
		//user_id + type 等同于主键 ask_id
		List<Ask> list = buildingServiceService.askList(ask);
		String json = "";
		if (list != null && list.size() > 0) {
			json = JsonUtil.toJsonStr(list, true, "");
		} else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据");
		}
		WebUtil.out(response, json);

	}
	
	//匿名或实名
	//咨询信息发布
	@RequestMapping("/ask")
	public void addPublish(HttpServletRequest request, HttpServletResponse response, Ask ask) {
		int flag = buildingServiceService.addPublish(ask);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "发送成功！");
		} else {
			json = JsonUtil.createOperaStr(false, "发送失败，请重新发送。");
		}
		WebUtil.out(response, json);
	}
}
