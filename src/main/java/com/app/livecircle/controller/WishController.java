package com.app.livecircle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.livecircle.model.Wish;
import com.app.livecircle.model.WishStatus;
import com.app.livecircle.service.WishService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/wish")
@Controller
public class WishController {
	
	@Autowired
	private WishService wishService;

	
	/**
	 * 心愿列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String userid,String wish_type,int pageSize) {
		{
			List<Wish> list = wishService.list(wish_type,pageSize);
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
	 * 心愿详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response,String user_id,String list_id) {
		{
			String json = "";
			Wish wish = wishService.get(list_id);
			if (wish != null) {
				List<WishStatus> list = wishService.getWishStatus(list_id);
				if (list != null && list.size()>0) {
					json = "{\"success\":" + true + ",\"list1\":" + JsonUtil.toStr(wish) + ",\"list2\":" + JsonUtil.toStr(list) + "}";
				}else {
					json = JsonUtil.toJsonStr(list, false, "暂无数据！");
				}
				
			}else {
				json = JsonUtil.toJsonStr(wish, false, "暂无数据！");
			}
			
			
			
			
			WebUtil.out(response, json);
		}
	}

	/**
	 * 新建心愿
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Wish wish) {
		int falg = wishService.add(wish);
		String json = "";
		
		if (falg == 1) {
			json = JsonUtil.createOperaStr(true, "发布成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "发布失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 认领心愿
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response,WishStatus wishStatus) {
		int falg = wishService.update(wishStatus);
		String json = "";
		
		if (falg == 1) {
			json = JsonUtil.createOperaStr(true, "认领成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "认领失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 我的 心愿列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param pageSize 
	 * wish_status_nm（wish_status_nm） 1创建（发布）   2审核3审核不通过   4完成(认领)
	 * @return
	 */
	@RequestMapping("/listMy")
	public void listMy(HttpServletRequest request, HttpServletResponse response,String user_id,String wish_status_nm,int pageSize) {
		List<Wish> list = wishService.listMy(user_id,wish_status_nm,pageSize);
		String json = "";
		
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list, true, "");
		}else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据！");
		}
		WebUtil.out(response, json);
	}

}
