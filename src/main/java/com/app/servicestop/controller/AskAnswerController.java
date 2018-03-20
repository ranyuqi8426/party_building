package com.app.servicestop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.servicestop.model.AskAnswer;
import com.app.servicestop.model.AskAnswerListNum;
import com.app.servicestop.service.AskAnswerService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/askAnswer")
@Controller
public class AskAnswerController {
	
	@Autowired
	private AskAnswerService answerService;


	/**
	 * 咨询问答列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String ask_type,String answer_status,String user_id,int pageSize) {
		{
			List<AskAnswer> list = answerService.list(ask_type,answer_status,user_id,pageSize);
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
	 * 咨询问答列表条数查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listCountByType")
	public void listCountByType(HttpServletRequest request, HttpServletResponse response,String ask_type,String user_id) {
		{
			List<AskAnswerListNum> list = answerService.listCountByType(ask_type,user_id);
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
	 * 咨询问题查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response,int ask_answer_id) {
		{
			AskAnswer askAnswer = answerService.get(ask_answer_id);
			String json = "";
			
			if (askAnswer != null) {
				json = JsonUtil.toJsonStr(askAnswer, true, "");
			}else {
				json = JsonUtil.toJsonStr(askAnswer, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}
	
	/**
	 * 提问
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,AskAnswer askAnswer) {
		{
			int flag = answerService.add(askAnswer);
			String json = "";
			
			if (flag == 1) {
				json = JsonUtil.createOperaStr(true, "提问成功！");
			}else{
				json = JsonUtil.createOperaStr(false, "提问失败！");
			}
			WebUtil.out(response, json);
		}
	}


}
