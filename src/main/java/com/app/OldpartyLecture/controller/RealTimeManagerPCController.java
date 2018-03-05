package com.app.OldpartyLecture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.OldpartyLecture.model.RealTimeMessage;
import com.app.OldpartyLecture.service.RealTimeManagerPCService;
import com.app.OldpartyLecture.vo.RealTimeMessagePCVO;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.session.SessionUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("pc/realtime")
public class RealTimeManagerPCController extends BaseController{
	@Autowired
	private RealTimeManagerPCService RealTimeManagerPCService;
	/**
	 * 进入主界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/contentmaintain/realtime");
		setBtnAutho(request, "realtime");// 设置按钮权限
		return mv;
	}

	/**
	 * 列表
	 * @throws Exception 
	 */
	@RequestMapping("/search")
	public void search(HttpServletRequest request, HttpServletResponse response, RealTimeMessagePCVO RealTimeMessagePCVO) throws Exception {
		int count = RealTimeManagerPCService.listCount(RealTimeMessagePCVO);
		String json = JsonUtil.createExtjsPageJson(count, RealTimeManagerPCService.list(RealTimeMessagePCVO));
		WebUtil.out(response, json);
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, RealTimeMessage RealTimeMessage) {
		RealTimeMessage.setUpload_id(SessionUtil.getUserSession(request).getUser_id());
		int flag = RealTimeManagerPCService.add(RealTimeMessage);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
	
	
	/**
	 * 修改
	 */
//	@RequestMapping("/update")
//	public void update(HttpServletRequest request, HttpServletResponse response, RealTimeMessage RealTimeMessage) {
//		int flag = RealTimeManagerPCService.update(RealTimeMessage);
//		if (flag == 0)
//			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
//		else if (flag == 1)
//			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
//	}
	
	 
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, int realtimeinfo_id) {
		int flag = RealTimeManagerPCService.delete(realtimeinfo_id);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "删除失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
	}
}
