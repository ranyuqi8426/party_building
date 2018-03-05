//package com.app.party.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.app.information.model.information;
//import com.app.information.service.InformationService;
//import com.app.util.json.JsonUtil;
//import com.app.util.web.WebUtil;
//
//
//@RequestMapping("/information")
//@Controller
//public class PartyCaseController {
//	
//	@Autowired
//	private InformationService informationService;
//
//
//	/**
//	 * 新闻资讯列表查询
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping("/list")
//	public void list(HttpServletRequest request, HttpServletResponse response,String userid,String floorid,int pageSize) {
//		{
//			List<information> list = informationService.list(floorid,pageSize);
//			String json = "";
//			
//			if (list != null && list.size()>0) {
//				json = JsonUtil.toJsonStr(list, true, "");
//			}else {
//				json = JsonUtil.toJsonStr(list, false, "暂无数据！");
//			}
//			WebUtil.out(response, json);
//		}
//	}
//	
//	/**
//	 * 新闻资讯详情
//	 * @author 冉玉琦
//	 * @date 2018年3月2日
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping("/get")
//	public void get(HttpServletRequest request, HttpServletResponse response,String user_id,String list_id) {
//		{
//			information information = informationService.get(user_id,list_id);
//			String json = "";
//			
//			if (information != null) {
//				json = JsonUtil.toJsonStr(information, true, "");
//			}else {
//				json = JsonUtil.toJsonStr(information, false, "暂无数据！");
//			}
//			WebUtil.out(response, json);
//		}
//	}
//
//	/**
//	 * 点赞
//	 * @author 冉玉琦
//	 * @date 2018年3月2日
//	 * @param informationLike
//	 */
//	@RequestMapping("/like")
//	public void addLike(HttpServletRequest request, HttpServletResponse response,int user_id,int list_id) {
//		int falg = informationService.addLike(list_id,user_id);
//		String json = "";
//		
//		if (falg == 1) {
//			json = JsonUtil.createOperaStr(true, "点赞成功！");
//		}else {
//			json = JsonUtil.createOperaStr(false, "点赞失败！");
//		}
//		WebUtil.out(response, json);
//	}
//	/**
//	 * 取消点赞
//	 * @return
//	 */
//	@RequestMapping("/notlike")
//	public void deleteLike(HttpServletRequest request, HttpServletResponse response,int user_id,int list_id) {
//		int falg = informationService.deleteLike(list_id, user_id);
//		String json = "";
//		
//		if (falg > 0 ) {
//			json = JsonUtil.createOperaStr(true, "取消成功！");
//		}else {
//			json = JsonUtil.createOperaStr(false, "取消失败！");
//		}
//		WebUtil.out(response, json);
//	}
//
//}
