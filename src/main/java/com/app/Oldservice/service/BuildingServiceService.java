package com.app.Oldservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldservice.dao.BuildingServiceDao;
import com.app.Oldservice.dao.DesireDao;
import com.app.Oldservice.model.Ask;
import com.app.Oldservice.model.BuildingInfo;
import com.app.Oldservice.model.BuildingService;
import com.app.Oldservice.model.User;

@Service
public class BuildingServiceService {
	@Autowired
	private BuildingServiceDao buildingServiceDao;
	@Autowired
	private DesireDao desireDao;
	public List<BuildingInfo> list(BuildingInfo buildingInfo) {
		return buildingServiceDao.list(buildingInfo);
	}

	public List<BuildingService> ServiceList(BuildingInfo buildingInfo) {
		List<BuildingService> listOne = buildingServiceDao.ServiceList(buildingInfo);
		//得到楼宇Name
		List<BuildingInfo> oneInfo = buildingServiceDao.oneInfo(String.valueOf(buildingInfo.getBuilding_id()));
		String name = oneInfo.get(0).getName();
		for(BuildingService one : listOne) {
			List<User> listBiz = desireDao.getUserName(one.getUser_id());
			String userName = listBiz.get(0).getUsername();
			one.setUsername(userName);
			one.setName(name);
		}
		return listOne;
	}

	public int add(BuildingService buildingService) {
		//初始化审核
		buildingService.setAuditor_id(0);
		buildingService.setAudit_status("0");
		buildingService.setTime(new Date());
		buildingService.setStatus("0");
		return buildingServiceDao.add(buildingService);
	}

	public List<Ask> askList(Ask ask) {
		//type 1 心理\2健康\3政策
		//kindof 1 提问\2回答
		return buildingServiceDao.askList(ask);
	}

	public int addPublish(Ask ask) {
		//初始化回答人id
		//后台做相应处理的时候要初始化用户的id，通过id进行查找
		ask.setUser_answer_id(0);
		ask.setKindof("self");
		ask.setTime(new Date());
		return buildingServiceDao.addPublish(ask);
	}



	
	
}
