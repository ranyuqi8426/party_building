package com.app.Oldmy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.app.Oldlogin.model.SysLogin;
import com.app.Oldmy.service.UserInfoMargerService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("my/userinfo")
public class UserInfoMargerController {
	@Autowired
	private UserInfoMargerService UserInfoMargerService;
	/*
	 * 修改用户头像
	 */
	@RequestMapping("/updatehearurl")
	public void updateHearUrl(HttpServletRequest request, HttpServletResponse response,String user_id,MultipartFile user_hear_url){
		String url = UserInfoMargerService.updateHearUrl(user_id,user_hear_url);
		String json = "";
		if (url != null) {
			json =JsonUtil.createOperaStr(true, url);
		}else {
			json =JsonUtil.createOperaStr(false, "修改失败");
		
		}
		WebUtil.out(response, json);
		
	}
	/**
	 * 修改
	 */
	@RequestMapping("/updateuserinfo")
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response, SysLogin SysLogin) {
		int flag = UserInfoMargerService.updateUserInfo(SysLogin);
		String json = "";
		if(flag == 1){
			json = JsonUtil.toJsonStr(UserInfoMargerService.getUserInfo(SysLogin),true,"");
		}
		WebUtil.out(response, json);
	}
}
