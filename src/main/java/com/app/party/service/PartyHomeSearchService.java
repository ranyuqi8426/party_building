package com.app.party.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.party.dao.PartyHomeSearchDao;
import com.app.party.model.PartyHomeSearch;

@Service
public class PartyHomeSearchService {
	@Autowired
	private PartyHomeSearchDao partyHomeSearchDao;
	
	/**
	 * 找组织列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public int list(String floor_id,String user_id) {
		List<PartyHomeSearch> list = partyHomeSearchDao.list(floor_id,user_id);
		if(list == null || list.size()<=0){
			return 0;
		}else {
			if(list.get(0).getSearch_status().equals("1")){
				return 1;
			}
			if(list.get(0).getSearch_status().equals("2")){
				return 2;
			}
		}
		return 0;
	}
	/**
	 * 找组织
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public int add(PartyHomeSearch partyHomeSearch) {
		return partyHomeSearchDao.add(partyHomeSearch);
	}
	
	
}
