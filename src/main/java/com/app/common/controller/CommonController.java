package com.app.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.app.common.SysConfig;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.common.SysConfig;
import com.app.sys.service.SysRoleService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


/**
 * 公共处理方法，所有涉及数据库查询的下拉框，公共部分都在此定义 说明：这个类改完后及时提交，修改前先更新，避免冲突
 * 
 * @author chykong
 *
 */
@RequestMapping("/common")
@Controller
public class CommonController {
	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 角色列表
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listRoleCombobox")
	public void listRoleCombobox(HttpServletRequest request, HttpServletResponse response) {
		
		SysConfig sysConfig = new SysConfig();
		SysConfig sysConfig1 = new SysConfig();
		sysConfig1.setContent("aaaaaa");
		sysConfig.setContent("aaaaaa");
		sysConfig.setImgnum("1");
		sysConfig.setImgurl1("../images/cbd.jpg");
		sysConfig.setTime("2017-01-10");
		sysConfig.setTitle("成功");
		List<SysConfig> list =new ArrayList<>();
		list.add(sysConfig);
//		list.add(sysConfig1);
		System.out.println(JsonUtil.createOperTypeStr(1,JsonUtil.toStr(list)));
		WebUtil.out(response,JsonUtil.toStr(list));
	}
	

}
