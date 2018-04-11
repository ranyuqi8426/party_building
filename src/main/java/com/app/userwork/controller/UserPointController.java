package com.app.userwork.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.userwork.model.UserPoint;
import com.app.userwork.model.UserPointRecord;
import com.app.userwork.service.UserPointService;
import com.app.util.constant.ConstantUtil;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/userPoint")
@Controller
public class UserPointController {
	
	@Autowired
	private UserPointService userPointService;
	


	/**
	 * 获取积分规则
	 * @author 冉玉琦
	 * @date 2018年3月3日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/rule")
	public void getPointRule(HttpServletRequest request, HttpServletResponse response) {
		{
			String json = JsonUtil.createOperaStr(true, ConstantUtil.pointRule);
			WebUtil.out(response, json);
		}
	}
	/**
	 * 积分排行查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/listPoint")
	public void listPoint(HttpServletRequest request, HttpServletResponse response,Integer user_id) {
		List<UserPoint> list = userPointService.listPoint();
		String json = "";
		
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list, true, "");
		}else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 我的积分记录查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,int user_id) {
		List<UserPointRecord> list = userPointService.list(user_id);
		String json = "";
		
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list, true, "");
		}else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据！");
		}
		WebUtil.out(response, json);
	}
	
	
	/**
	 * 我的积分查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response,int user_id) {
		UserPoint list = userPointService.get(user_id);
		String json = "";
		
		if (list != null) {
			json = JsonUtil.toJsonStr(list, true, "");
		}else {
			json = JsonUtil.toJsonStr(list, false, "暂无积分！");
		}
		WebUtil.out(response, json);
	}
}
