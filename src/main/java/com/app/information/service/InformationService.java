package com.app.information.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.information.dao.InformationDao;
import com.app.information.model.InformationLike;
import com.app.information.model.information;

@Service
public class InformationService {
	@Autowired
	private InformationDao informationDao;
	
	/**
	 * 新闻资讯列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<information> list(String floorid,int pageSize) {
		List<information> list = informationDao.list(floorid,pageSize);
		
		return list;
	}
	/**
	 * 新闻资讯详情
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public information get(String user_id,String list_id) {
		information information = informationDao.get(user_id,list_id);
		
		return information;
	}
	
	/**
	 * 点赞
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	public int addLike(int news_id,int user_id) {
		InformationLike informationLike = new InformationLike();
		informationLike.setCreate_cd(user_id);
		informationLike.setNews_id(news_id);
		return informationDao.addLike(informationLike);
	}
	/**
	 * 取消点赞
	 * @return
	 */
	public int deleteLike(int list_id,int user_id) {
		return informationDao.deleteLike(list_id, user_id);
	}
}
