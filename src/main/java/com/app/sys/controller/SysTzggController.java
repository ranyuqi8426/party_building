package com.app.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.sys.model.SysTzgg;
import com.app.sys.service.SysTzggService;
import com.app.sys.vo.SysTzggSearchVO;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.session.SessionUtil;
import com.app.util.web.WebUtil;

/**
 * 通知公告
 * @author 崔明超
 * @date 2017年1月16
 *
 */
@RequestMapping("/sys/tzgg")
@Controller
public class SysTzggController extends BaseController {

	@Autowired
	private SysTzggService sysTzggService;

	/**
	 * 进入通知公告信息维护界面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/tzgg");
		mv.addObject("username", SessionUtil.getUserSession(request).getRealname());// 当前登陆人
		setBtnAutho(request, "SysTzgg");
		return mv;
	}

	/**
	 * 添加通知公告信息
	 * 
	 * @param request
	 * @param response
	 * @param sysTzgg
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, SysTzgg sysTzgg) {
		int flag = sysTzggService.add(sysTzgg);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}

	/**
	 * 修改通知公告信息
	 * 
	 * @param request
	 * @param response
	 * @param sysTzgg
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, SysTzgg sysTzgg) {
		int flag = sysTzggService.update(sysTzgg);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}

	/**
	 * 删除通知公告信息
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, int id) {
		int flag = sysTzggService.delete(id);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "删除失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
	}



}

