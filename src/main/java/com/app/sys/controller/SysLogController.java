package com.app.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.sys.service.SysLogService;
import com.app.sys.vo.SysLogSearchVO;
import com.app.util.controller.BaseController;
import com.app.util.date.DateUtil;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@Controller
@RequestMapping("/sys/log")
public class SysLogController extends BaseController {
	@Autowired
	private SysLogService sysLogService;

	/**
	 * 进入日志查看界面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/log");

		mv.addObject("e_date", DateUtil.getSystemDate());//查询终止日期
		mv.addObject("s_date", DateUtil.getOpeDate(DateUtil.getSystemDate(), -30));//查询起始日期

		return mv;
	}


	/**
	 * 下载操作日志
	 * @param request
	 * @param response
	 */
	@RequestMapping("/downloadLog")
	public void downloadLog(HttpServletRequest request, HttpServletResponse response) {
		int user_id = WebUtil.getSafeInt(request.getParameter("user_id"));
		String s_date = WebUtil.getSafeStr(request.getParameter("s_date"));
		String e_date = WebUtil.getSafeStr(request.getParameter("e_date"));
		SysLogSearchVO sysLogSearchVO = new SysLogSearchVO();
		sysLogSearchVO.setUser_id(user_id);
		sysLogSearchVO.setS_date(s_date);
		sysLogSearchVO.setE_date(e_date);
		sysLogService.exportLog(request.getSession().getServletContext().getRealPath("/download"), sysLogSearchVO, response);
	}
}
