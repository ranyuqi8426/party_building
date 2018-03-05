package com.app.userwork.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.userwork.model.UserInfo;
import com.app.userwork.service.UserInfoService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/user")
@Controller
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;


	/**
	 * 保存用户信息
	 * @author 冉玉琦
	 * @date 2018年3月3日
	 * @param request
	 * @param response
	 * @param userInfo
	 */
	@RequestMapping("/update")
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo) {
		{
			UserInfo rtnUserInfo = userInfoService.updateUserInfo(userInfo);
			String json = "";
			if (rtnUserInfo != null) {
				json = JsonUtil.toJsonStr(rtnUserInfo, true, "");
			}else {
				json = JsonUtil.toJsonStr(rtnUserInfo, false, "保存失败");
			}
			WebUtil.out(response, json);
		}
	}

	

	

}
