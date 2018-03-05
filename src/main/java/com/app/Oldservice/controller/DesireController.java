package com.app.Oldservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.Oldservice.model.Desire;
import com.app.Oldservice.service.DesireService;
import com.app.Oldservice.vo.DesireVO;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("service/Desire")
public class DesireController {
	@Autowired
	private DesireService desireService;
	// 分页问题
	// 查询所有心愿清单
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,DesireVO desireVO) {
		List<Desire> list = desireService.list(desireVO);
		String json = "";
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list,true,"");
		}else{
			json = JsonUtil.toJsonStr(list,false,"暂无数据");
		}
		WebUtil.out(response, json);
	}

	//查看详细信息
	@RequestMapping("/getOne")
	public void getOne(HttpServletRequest request, HttpServletResponse response,String want_id) {
		List<Desire> list = desireService.getOne(want_id);
		String json = "";
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list,true,"");
		}else{
			json = JsonUtil.toJsonStr(list,false,"加载失败，请稍后重试。");
		}
		WebUtil.out(response, json);
	}
	
	
	// 添加心愿
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Desire desire) {
		int flag = desireService.add(desire);
		String json = "";
		if (flag == 1) {
			json =JsonUtil.createOperaStr(true, "发布成功！");
		}else {
			json =JsonUtil.createOperaStr(false, "发布失败，请重新发布。");
		}
		WebUtil.out(response, json);
	}

	//完成心愿
	@RequestMapping("/finish")
	public void updateFinish(HttpServletRequest request, HttpServletResponse response,DesireVO desireVO) {
		int flag = desireService.updateFinish(desireVO);
		String json = "";
		if (flag == 1) {
			json =JsonUtil.createOperaStr(true, "认领成功！");
		}else if(flag == 3){
			json =JsonUtil.createOperaStr(false, "认领失败，无法认领自己发布的心愿");
		}else{
			json =JsonUtil.createOperaStr(false, "认领失败，请重新认领。");
		}
		WebUtil.out(response, json);
	}
	
	// 我的
	// 与我有关的心愿（发布\完成）
	@RequestMapping("/myDesire")
	public void myDesire() {

	}

}
