package com.app.servicestop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.servicestop.model.Policy;
import com.app.servicestop.service.PolicyService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/policy")
@Controller
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;


	/**
	 * 政策发布列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String userid,String floorid,String policy_type,int pageSize) {
		{
			List<Policy> list = policyService.list(floorid,policy_type,pageSize);
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
	 * 政策发布查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response,String list_id) {
		{
			Policy list = policyService.get(list_id);
			String json = "";
			
			if (list != null ) {
				json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}

}
