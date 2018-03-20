package com.app.floorservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.floorservice.model.WorkStation;
import com.app.floorservice.service.WorkStationService;
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
	
}
