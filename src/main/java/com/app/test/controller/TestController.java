package com.app.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.test.service.TestService;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("test")
public class TestController {
	@Autowired
	private TestService testService;
	@RequestMapping("/update")
	public void upadateSql(HttpServletRequest request, HttpServletResponse response,String oldUrl,String newUrl){
//		oldUrl = "172.17.67.4";
		newUrl = "172.27.35.12";
		testService.updateSql(oldUrl,newUrl);
		String json = "";
		WebUtil.out(response, json);
		
	}
}
