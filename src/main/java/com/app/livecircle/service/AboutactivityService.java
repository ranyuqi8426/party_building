package com.app.livecircle.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.livecircle.dao.AboutactivityDao;
import com.app.livecircle.model.Aboutactivity;
import com.app.livecircle.model.AboutactivityType;
import com.app.livecircle.model.AboutactivityTypeRelation;
import com.app.livecircle.model.AboutactivityUser;
import com.app.userwork.model.Collection;

@Service
public class AboutactivityService {
	@Autowired
	private AboutactivityDao aboutactivityDao;
	
	/**
	 * 约吧活动列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<Aboutactivity> list(String floor_id,String flooractivity_type,int pageSize) {
		List<Aboutactivity> list = aboutactivityDao.list(floor_id,flooractivity_type,pageSize);
		
		return list;
	}
	/**
	 * 约吧活动详情
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public Aboutactivity get(String user_id,String list_id) {
		Aboutactivity aboutactivity = aboutactivityDao.get(user_id,list_id);
		return aboutactivity;
	}

	/**
	 * 新建活动
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 */
	public int add(Aboutactivity aboutactivity) {
		return aboutactivityDao.add(aboutactivity);
	}
	/**
	 * 收藏
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	public int addLike(int user_id,String collection_content_id,String collection_content_type,String content) {
		Collection collection = new Collection();
		collection.setUser_id(user_id);
		collection.setCollection_content_id(collection_content_id);;
		collection.setCollection_content_type(collection_content_type);
		collection.setCreate_cd(String.valueOf(user_id));;
		collection.setCollection_content(content);
		return aboutactivityDao.addLike(collection);
	}
	/**
	 * 取消收藏
	 * @return
	 */
	public int deleteLike(String list_id,int user_id,String type) {
		return aboutactivityDao.deleteLike(list_id, user_id,type);
	}
	/**
	 * 参与活动
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param buildingUser
	 * @return
	 */
	public int addUser(AboutactivityUser aboutactivityUser) {
		List<AboutactivityUser> list = aboutactivityDao.getAboutactivityUser(aboutactivityUser.getCreate_cd(),aboutactivityUser.getActivity_id());
		if (list != null && list.size()>0) {
			return 2;
		}
		aboutactivityDao.addUser(aboutactivityUser);
		return aboutactivityDao.updateComeNum(aboutactivityUser.getActivity_id());
	}
	/**
	 * 约吧活动类型查询
	 * @param request
	 * @param response
	 */
	public List<AboutactivityType> listType() {
		return aboutactivityDao.listType();
	}
	/**
	 * 约吧活动类型私人订制查询
	 * @param request
	 * @param response
	 */
	public List<AboutactivityTypeRelation> listTypeRelation(String user_id) {
		return aboutactivityDao.listTypeRelation(user_id);
	}
	/**
	 * 约吧活动类型私人订制清空
	 * @param request
	 * @param response
	 */
	public int deleteTypeRelation(String user_id) {
		return aboutactivityDao.deleteTypeRelation(user_id);
	}
	/**
	 * 我的 活动列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param pageSize 
	 * 活动类型 1我发布 2 我参与
	 * @return
	 */
	public List<Aboutactivity> listMy(String user_id, String type, int pageSize) {
		if (type == null) {
			return null;
		}
		if(type.equals("1")){
			return aboutactivityDao.listMyFor1(user_id,pageSize);
		}
		if(type.equals("2")){
			return aboutactivityDao.listMyFor2(user_id,pageSize);
		}
		return null;
	}
	
}
