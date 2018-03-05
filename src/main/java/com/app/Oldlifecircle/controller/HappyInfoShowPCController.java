package com.app.Oldlifecircle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.Oldlifecircle.model.HappyInfoShow;
import com.app.Oldlifecircle.service.HappyInfoShowPCService;
import com.app.Oldlifecircle.service.HappyInfoShowService;
import com.app.Oldlifecircle.vo.HappyInfoShowVO;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.page.GlobalConst;
import com.app.util.session.SessionUtil;
import com.app.util.web.WebUtil;

import ch.qos.logback.core.status.Status;

/**
 *
 */
@Controller
@RequestMapping("/pc/happyinfoshow")
public class HappyInfoShowPCController extends BaseController {
	@Autowired
	private HappyInfoShowPCService HappyInfoShowService;

	/**
	 * 进入主界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sendcheck/happyshow");
		setBtnAutho(request, "HappyInfoShow");// 设置按钮权限
		return mv;
	}

	/**
	 * 列表
	 */
	@RequestMapping("/searchpc")
	public void searchPC(HttpServletRequest request, HttpServletResponse response, HappyInfoShowVO HappyInfoShowVO) {
		int user_id = SessionUtil.getUserSession(request).getUser_id();
		int count = HappyInfoShowService.listCount(HappyInfoShowVO);
		int pageIndex = WebUtil.getSafeInt(request.getParameter("page"), 1);
		int pageSize = WebUtil.getSafeInt(request.getParameter("limit"), GlobalConst.pageSize);
		String json = JsonUtil.createExtjsPageJson(count, HappyInfoShowService.list(HappyInfoShowVO, pageIndex, pageSize));
		WebUtil.out(response, json);
	}


	/**
	 * 审核
	 */
	@RequestMapping("/updatepc")
	public void updatePC(HttpServletRequest request, HttpServletResponse response, String show_id,String status) {
		int user_id = SessionUtil.getUserSession(request).getUser_id();
		int flag = HappyInfoShowService.update(show_id,status,user_id);
		if (flag == 0) {
			WebUtil.out(response, JsonUtil.createOperaStr(false, "审核失败"));
		} else if (flag == 1) {
			WebUtil.out(response, JsonUtil.createOperaStr(true, "审核成功"));
		} 
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deletepc")
	public void deletePC(HttpServletRequest request, HttpServletResponse response, String show_id) {
		int flag = HappyInfoShowService.delete(show_id);
		WebUtil.outOpera(response, flag);
	}
}
