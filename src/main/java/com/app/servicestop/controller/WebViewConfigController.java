package com.app.servicestop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.servicestop.model.WebViewConfig;
import com.app.servicestop.model.WebViewGovernmentUrlConfig;
import com.app.servicestop.model.WebViewLifeConfig;
import com.app.servicestop.model.WebViewLifeUrlConfig;
import com.app.servicestop.model.WebViewUrlConfig;
import com.app.servicestop.service.WebViewConfigService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/webviewconfig")
@Controller
public class WebViewConfigController {
	
	@Autowired
	private WebViewConfigService webViewConfigService;


	/**
	 * 商务列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		{
			
		List<WebViewConfig> list = webViewConfigService.list();
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
	 * 商务商家列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listBusiness")
	public void listBusiness(HttpServletRequest request, HttpServletResponse response,String merchant_config_id) {
		{
			List<WebViewUrlConfig> list = webViewConfigService.listBusiness(merchant_config_id);
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
	 * 生活列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listLife")
	public void listLife(HttpServletRequest request, HttpServletResponse response) {
		{
			
		List<WebViewLifeConfig> list = webViewConfigService.listLife();
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
	 * 生活商家列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listLifeBusiness")
	public void listLifeBusiness(HttpServletRequest request, HttpServletResponse response,String life_config_id) {
		{
			List<WebViewLifeUrlConfig> list = webViewConfigService.listLifeBusiness(life_config_id);
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
	 * 政务url列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listGovernment")
	public void listGovernment(HttpServletRequest request, HttpServletResponse response,String floor_id) {
		{
			WebViewGovernmentUrlConfig list = webViewConfigService.listGovernment(floor_id);
			String json = "";
			
			if (list != null) {
				json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}

}
