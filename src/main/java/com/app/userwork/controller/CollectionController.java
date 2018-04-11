package com.app.userwork.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.userwork.model.Collection;
import com.app.userwork.service.CollectionService;
import com.app.userwork.vo.CollectionVO;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("my/collection")
public class CollectionController {
	@Autowired
	private CollectionService CollectionService;
	//收藏晒晒查询主列表
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,CollectionVO CollectionVO){
		List<Collection> list = CollectionService.list(CollectionVO);
		String json = "";
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list,true,"");
		}else{
			json = JsonUtil.toJsonStr(list,false,"暂无数据");
		}
		WebUtil.out(response, json);
		
	}
//	
////查询一条记录
//@RequestMapping("/getone")
//public void get(HttpServletRequest request, HttpServletResponse response,String listId,String user_id){
//	List<Collection> list = CollectionService.get(listId, user_id);
//	String json = "";
//	if (list != null && list.size()>0) {
//		json = JsonUtil.toJsonStr(list,true,"");
//	}else{
//		json = JsonUtil.toJsonStr(list,false,"加载失败，请稍后重试。");
//	}
//	WebUtil.out(response, json);
//	
//}

//
/**
 * 删除
 */
@RequestMapping("/delete")
public void delete(HttpServletRequest request, HttpServletResponse response, String list_id) {
	int flag = CollectionService.delete(list_id);
	WebUtil.outOpera(response, flag);
}
}
