package com.app.Oldmy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.Oldmy.model.Collection;
import com.app.Oldmy.model.HappyInfoShow;
import com.app.Oldmy.model.PartyLectureInfo;
import com.app.Oldmy.model.RealTimeMessage;
import com.app.Oldmy.service.CollectionService;
import com.app.Oldmy.vo.CollectionVO;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("my/Collection")
public class CollectionController {
	@Autowired
	private CollectionService CollectionService;
	//收藏晒晒查询主列表
	@RequestMapping("/listshaishai")
	public void listShaiShai(HttpServletRequest request, HttpServletResponse response,CollectionVO CollectionVO){
		List<HappyInfoShow> list = CollectionService.listShaiShai(CollectionVO);
		String json = "";
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list,true,"");
		}else{
			json = JsonUtil.toJsonStr(list,false,"暂无数据");
		}
		WebUtil.out(response, json);
		
	}
	//收藏实时资讯查询主列表
		@RequestMapping("/listmessage")
		public void listMessage(HttpServletRequest request, HttpServletResponse response,CollectionVO CollectionVO){
			List<RealTimeMessage> list = CollectionService.listMessage(CollectionVO);
			String json = "";
			if (list != null && list.size()>0) {
				json = JsonUtil.toJsonStr(list,true,"");
			}else{
				json = JsonUtil.toJsonStr(list,false,"暂无数据");
			}
			WebUtil.out(response, json);
			
		}
		//收藏理论知识查询主列表
		@RequestMapping("/listinfo")
		public void listInfo(HttpServletRequest request, HttpServletResponse response,CollectionVO CollectionVO){
			List<PartyLectureInfo> list = CollectionService.listInfo(CollectionVO);
			String json = "";
			if (list != null && list.size()>0) {
				json = JsonUtil.toJsonStr(list,true,"");
			}else{
				json = JsonUtil.toJsonStr(list,false,"暂无数据");
			}
			WebUtil.out(response, json);
			
		}
		//收藏视频查询主列表
		@RequestMapping("/listvideo")
		public void listVideo(HttpServletRequest request, HttpServletResponse response,CollectionVO CollectionVO){
			List<PartyLectureInfo> list = CollectionService.listVideo(CollectionVO);
			String json = "";
			if (list != null && list.size()>0) {
				json = JsonUtil.toJsonStr(list,true,"");
			}else{
				json = JsonUtil.toJsonStr(list,false,"暂无数据");
			}
			WebUtil.out(response, json);
			
		}
		//收藏书籍查询主列表
		@RequestMapping("/listBook")
		public void listBook(HttpServletRequest request, HttpServletResponse response,CollectionVO CollectionVO){
			List<PartyLectureInfo> list = CollectionService.listBook(CollectionVO);
			String json = "";
			if (list != null && list.size()>0) {
				json = JsonUtil.toJsonStr(list,true,"");
			}else{
				json = JsonUtil.toJsonStr(list,false,"暂无数据");
			}
			WebUtil.out(response, json);
			
		}
//查询一条记录
@RequestMapping("/getone")
public void get(HttpServletRequest request, HttpServletResponse response,String listId,String user_id){
	List<Collection> list = CollectionService.get(listId, user_id);
	String json = "";
	if (list != null && list.size()>0) {
		json = JsonUtil.toJsonStr(list,true,"");
	}else{
		json = JsonUtil.toJsonStr(list,false,"加载失败，请稍后重试。");
	}
	WebUtil.out(response, json);
	
}



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
