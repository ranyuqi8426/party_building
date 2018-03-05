package com.app.userwork.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.userwork.model.UserSign;
import com.app.userwork.service.UserSignService;
import com.app.util.constant.ConstantUtil;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/userSign")
@Controller
public class UserSignController {
	
	@Autowired
	private UserSignService userSignService;


	/**
	 * 获取签到规则
	 * @author 冉玉琦
	 * @date 2018年3月3日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/rule")
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) {
		{
			String json = JsonUtil.createOperaStr(true, ConstantUtil.signRule);
			WebUtil.out(response, json);
		}
	}
	/**
	 * 签到
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,int user_id) {
		int falg = userSignService.add(user_id);
		String json = "";
		
		if (falg == 1) {
			json = JsonUtil.createOperaStr(true, "签到成功！");
		}else if(falg == 0){
			json = JsonUtil.createOperaStr(false, "今天已签到！");
		}else {
			json = JsonUtil.createOperaStr(false, "签到失败!");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 签到记录查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,int year,int month,int user_id) {
		List<UserSign> list = userSignService.list(year,month,user_id);
		String json = "";
		
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list, true, "");
		}else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据！");
		}
		WebUtil.out(response, json);
	}
	

	

}
