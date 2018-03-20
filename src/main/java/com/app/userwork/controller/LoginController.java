package com.app.userwork.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.userwork.model.BnsFloor;
import com.app.userwork.model.UserInfo;
import com.app.userwork.service.LoginService;
import com.app.util.json.JsonUtil;
import com.app.util.string.StringUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	private LoginService LoginService;


	/**
	 * 登录校验
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 */
	@RequestMapping("/baseCheckLogin")
	public void checkLogin(HttpServletRequest request, HttpServletResponse response, String username, String password) {
		{
			String ip = StringUtil.getIp(request);
			UserInfo userInfo = LoginService.checkLogin(username,password,ip);
			String json = "";
			
			if (userInfo != null) {
				json = JsonUtil.toJsonStr(userInfo, true, "");
			}else {
				json = JsonUtil.toJsonStr(userInfo, false, "用户名密码错误");
			}
			WebUtil.out(response, json);
		}
	}
	/**
	 * 第三方登录
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 */
	@RequestMapping("/WXQQLogin")
	public void WXQQLogin(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo,String LoginType) {
		{
			String ip = StringUtil.getIp(request);
			UserInfo userInfos = LoginService.checkWXQQLogin(userInfo,ip,LoginType);
			String json = "";
			
			if (userInfos != null) {
				json = JsonUtil.toJsonStr(userInfos, true, "");
			}else {
				json = JsonUtil.toJsonStr(userInfos, false, "加载失败，请重新登录！");
			}
			WebUtil.out(response, json);
		}
	}
	/**
	 * 注册
	 * @author 冉玉琦
	 * @date 2018年3月3日
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, String user_cd,String user_password) {
		{
			int flag = LoginService.add(user_cd,user_password);
			String json = "";
			
			if (flag == 1) {
				json = JsonUtil.createOperaStr(true, "注册成功！");
			}else if(flag == 2){
				json = JsonUtil.createOperaStr(false, "手机号已被占用！");
			}else {
				json = JsonUtil.createOperaStr(false, "失败成功！");
			}
			WebUtil.out(response, json);
		}
	}
	/**
	 * 获取楼宇列表
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 */
	@RequestMapping("/floorList")
	public void queryFloorList(HttpServletRequest request, HttpServletResponse response) {
		{
			List<BnsFloor> list = LoginService.queryFloorList();
			String json = "";
			
			if (list != null && list.size()>0) {
				json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "加载数据失败");
			}
			WebUtil.out(response, json);
		}
	}

	


}
