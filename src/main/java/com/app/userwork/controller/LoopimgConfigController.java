package com.app.userwork.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.userwork.model.LoopimgConfig;
import com.app.userwork.service.LoopimgConfigService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/loopimg")
@Controller
public class LoopimgConfigController {
	
	@Autowired
	private LoopimgConfigService loopimgConfigService;


	
	
	/**
	 * 获取轮播图列表
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 */
	@RequestMapping("/list")
	public void queryFloorList(HttpServletRequest request, HttpServletResponse response,String source_type) {
		{
			List<LoopimgConfig> list = loopimgConfigService.queryLoopimgConfigList(source_type);
			String json = "";
			
			if (list != null && list.size()>0) {
				json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "图片加载失败");
			}
			WebUtil.out(response, json);
		}
	}

	


}
