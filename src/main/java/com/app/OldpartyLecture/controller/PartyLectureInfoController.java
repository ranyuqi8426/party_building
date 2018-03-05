package com.app.OldpartyLecture.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.OldpartyLecture.model.BookChapter;
import com.app.OldpartyLecture.model.BookText;
import com.app.OldpartyLecture.model.PartyLectureInfo;
import com.app.OldpartyLecture.service.PartyLectureInfoService;
import com.app.OldpartyLecture.vo.BookChapterVO;
import com.app.OldpartyLecture.vo.BookTextVO;
import com.app.OldpartyLecture.vo.PartyLectureInfoVO;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("partyLecture/PartyLectureInfo")
public class PartyLectureInfoController {
	@Autowired
	private PartyLectureInfoService PartyLectureInfoService;

	// 查询主列表
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response, PartyLectureInfoVO PartyLectureInfoVO) {
		List<PartyLectureInfo> list = PartyLectureInfoService.list(PartyLectureInfoVO);
		String json = "";
		if (list != null && list.size() > 0) {
			json = JsonUtil.toJsonStr(list, true, "");
		} else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据");
		}
		WebUtil.out(response, json);

	}

	// 查询一条记录
	@RequestMapping("/getone")
	public void get(HttpServletRequest request, HttpServletResponse response, PartyLectureInfoVO PartyLectureInfoVO) {
		List<PartyLectureInfo> list = PartyLectureInfoService.get(PartyLectureInfoVO);
		String json = "";
		if (list != null && list.size() > 0) {
			json = JsonUtil.toJsonStr(list, true, "");
		} else {
			json = JsonUtil.toJsonStr(list, false, "加载失败，请稍后重试。");
		}
		WebUtil.out(response, json);

	}
	/*
	 * 增加学习记录
	 */
	@RequestMapping("/addStudyRecord")
	public void addStudyRecord(HttpServletRequest request, HttpServletResponse response,int listId,String user_id,String type){
		int flag = PartyLectureInfoService.addStudyRecord(listId,user_id,type);
		String json = "";
		if (flag>0) {
			json =JsonUtil.createOperaStr(true, String.valueOf(flag));
		}else {
			json =JsonUtil.createOperaStr(false, "对不起，此学习不进行记录");
		
		}
		WebUtil.out(response, json);
		
	}
	/*
	 * 更新学习记录
	 */
	@RequestMapping("/updateStudyRecord")
	public void updateStudyRecord(HttpServletRequest request, HttpServletResponse response,int record_id,String learning_type,String time_num){
		int flag = PartyLectureInfoService.updateStudyRecord(record_id,learning_type,time_num);
		String json = "";
		if (flag == 1) {
			json =JsonUtil.createOperaStr(true, String.valueOf(flag));
		}else {
			json =JsonUtil.createOperaStr(false, "对不起，此学习不进行记分");
		
		}
		WebUtil.out(response, json);
		
	}
	
	/*
	 * 收藏理论
	 */
	@RequestMapping("/addCollection")
	public void addCollection(HttpServletRequest request, HttpServletResponse response,int listId,int user_id){
		int flag = PartyLectureInfoService.addCollection(listId,user_id);
		String json = "";
		if (flag == 1) {
			json =JsonUtil.createOperaStr(true, "收藏成功！");
		}else {
			json =JsonUtil.createOperaStr(false, "收藏失败，请重新操作。");
		
		}
		WebUtil.out(response, json);
		
	}
	/*
	 * 取消收藏理论
	 */
	@RequestMapping("/deleteCollection")
	public void deleteCollection(HttpServletRequest request, HttpServletResponse response,int listId,int user_id){
		int flag = PartyLectureInfoService.deleteCollection(listId,user_id);
		String json = "";
		if (flag == 1) {
			json =JsonUtil.createOperaStr(true, "取消成功！");
		}else {
			json =JsonUtil.createOperaStr(false, "取消失败，请重新操作。");
		
		}
		WebUtil.out(response, json);
		
	}
	// 查询书章节
		@RequestMapping("/listBook")
		public void listBook(HttpServletRequest request, HttpServletResponse response, BookChapterVO BookChapterVO) {
			List<BookChapter> list = PartyLectureInfoService.listBook(BookChapterVO);
			String json = "";
			if (list != null && list.size() > 0) {
				json = JsonUtil.toJsonStr(list, true, "");
			} else {
				json = JsonUtil.toJsonStr(list, false, "暂无数据");
			}
			WebUtil.out(response, json);

		}
		// 查询书章节内容
		@RequestMapping("/getBookContext")
		public void getBookContext(HttpServletRequest request, HttpServletResponse response, BookTextVO BookTextVO) {
			List<BookText> list = PartyLectureInfoService.getBookContext(BookTextVO);
			String json = "";
			if (list != null && list.size() > 0) {
				json = JsonUtil.toJsonStr(list, true, "");
			} else {
				json = JsonUtil.toJsonStr(list, false, "加载失败，请稍后重试。");
			}
			WebUtil.out(response, json);

		}
		/*
		 * 收藏
		 */
		@RequestMapping("/addTypeCollection")
		public void addTypeCollection(HttpServletRequest request, HttpServletResponse response,int listId,int user_id,String type){
			int flag = PartyLectureInfoService.addTypeCollection(listId,user_id,type);
			String json = "";
			if (flag == 1) {
				json =JsonUtil.createOperaStr(true, "收藏成功！");
			}else {
				json =JsonUtil.createOperaStr(false, "收藏失败，请重新操作。");
			
			}
			WebUtil.out(response, json);
			
		}
		/*
		 * 取消收藏
		 */
		@RequestMapping("/deleteTypeCollection")
		public void deleteTypeCollection(HttpServletRequest request, HttpServletResponse response,int listId,int user_id,String type){
			int flag = PartyLectureInfoService.deleteTypeCollection(listId,user_id,type);
			String json = "";
			if (flag == 1) {
				json =JsonUtil.createOperaStr(true, "取消成功！");
			}else {
				json =JsonUtil.createOperaStr(false, "取消失败，请重新操作。");
			
			}
			WebUtil.out(response, json);
			
		}

}
