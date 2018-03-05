package com.app.OldpartyLecture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.OldpartyLecture.model.DataManagerPC;
import com.app.OldpartyLecture.service.InfoManagerPCService;
import com.app.OldpartyLecture.vo.DataManagerPCVO;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.session.SessionUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("pc/info")
public class InfoManagerPCController extends BaseController{
	@Autowired
	private InfoManagerPCService InfoManagerPCService;
	/**
	 * 进入主界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/contentmaintain/infomaintain");
		setBtnAutho(request, "infomaintain");// 设置按钮权限
		return mv;
	}

	/**
	 * 列表
	 * @throws Exception 
	 */
	@RequestMapping("/search")
	public void search(HttpServletRequest request, HttpServletResponse response, DataManagerPCVO dataManagerPCVO) throws Exception {
		int count = InfoManagerPCService.listCount(dataManagerPCVO);
		String json = JsonUtil.createExtjsPageJson(count, InfoManagerPCService.list(dataManagerPCVO));
		WebUtil.out(response, json);
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, DataManagerPC dataManagerPC) {
		dataManagerPC.setCreate_user_id(SessionUtil.getUserSession(request).getUser_id());
		int flag = InfoManagerPCService.add(dataManagerPC);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, DataManagerPC dataManagerPC) {
		dataManagerPC.setCreate_user_id(SessionUtil.getUserSession(request).getUser_id());
		int flag = InfoManagerPCService.update(dataManagerPC);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
	
	 
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, int learning_data_id) {
		int flag = InfoManagerPCService.delete(learning_data_id);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "删除失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
	}
}
