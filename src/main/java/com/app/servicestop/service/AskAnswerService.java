package com.app.servicestop.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.servicestop.dao.AskAnswerDao;
import com.app.servicestop.model.AskAnswer;
import com.app.servicestop.model.AskAnswerListNum;


@Service
public class AskAnswerService {
	@Autowired
	private AskAnswerDao askAnswerDao;
	
	/**
	 * 咨询问答列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<AskAnswer> list(String ask_type,String answer_status,String user_id,int pageSize) {
		List<AskAnswer> list = askAnswerDao.list(ask_type,answer_status,user_id,pageSize);
		
		return list;
	}
	/**
	 * 咨询问答列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<AskAnswerListNum> listCountByType(String ask_type,String user_id) {
		List<AskAnswerListNum> list = askAnswerDao.listCountByType(ask_type, user_id);
		
		return list;
	}
	/**
	 * 提问
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public int add(AskAnswer askAnswer) {
		askAnswer.setAsk_time(new Date(new Date().getTime()));
		// 状态0未回答1已回答
		askAnswer.setAnswer_status("0");
		return askAnswerDao.add(askAnswer);
	}
	/**
	 * 问题查询
	 * @author 冉玉琦
	 * @date 2018年3月19日
	 * @param ask_answer_id
	 * @return
	 */
	public AskAnswer get(int ask_answer_id) {
		return askAnswerDao.get(ask_answer_id);
	}
	
	
}
