package com.app.livecircle.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.livecircle.dao.BuildingDao;
import com.app.livecircle.model.Building;
import com.app.livecircle.model.BuildingUser;
import com.app.livecircle.model.BuildingUserSay;
import com.app.userwork.model.Collection;

@Service
public class BuildingService {
	@Autowired
	private BuildingDao buildingDao;
	
	/**
	 * 心愿列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<Building> list(String floor_id,String flooractivity_type,int pageSize) {
		List<Building> list = buildingDao.list(floor_id,flooractivity_type,pageSize);
		
		return list;
	}
	/**
	 * 心愿详情
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public Building get(String user_id,String list_id) {
		Building information = buildingDao.get(user_id,list_id);
		
		return information;
	}

	/**
	 * 楼宇活动参与人列表详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	public List<BuildingUser> getUserList(String list_id) {
		return buildingDao.getUserList(list_id);
	}
	/**
	 * 楼宇活动评论列表详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	public List<BuildingUserSay> getUserSayList(String list_id,int pageSize) {
		return buildingDao.getUserSayList(list_id,pageSize);
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
		return buildingDao.addLike(collection);
	}
	/**
	 * 取消收藏
	 * @return
	 */
	public int deleteLike(String list_id,int user_id,String type) {
		return buildingDao.deleteLike(list_id, user_id,type);
	}
	/**
	 * 参与活动
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param buildingUser
	 * @return
	 */
	public int addUser(BuildingUser buildingUser) {
		return buildingDao.addUser(buildingUser);
	}
	/**
	 * 评论
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param buildingUserSay
	 * @return
	 */
	public int addUserSay(BuildingUserSay buildingUserSay) {
		return buildingDao.addUserSay(buildingUserSay);
	}
}
