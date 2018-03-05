package com.app.party.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.party.dao.PartyApplyDao;
import com.app.party.model.PartyApply;

@Service
public class PartyApplyService {
	@Autowired
	private PartyApplyDao partyApplyDao;
	
	/**
	 * 申请党员列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public int list(String floor_id,String user_id) {
		List<PartyApply> list = partyApplyDao.list(floor_id,user_id);
		if(list == null || list.size()<=0){
			return 0;
		}else {
			if(list.get(0).getApply_status().equals("1")){
				return 1;
			}
			if(list.get(0).getApply_status().equals("2")){
				return 2;
			}
		}
		return 0;
	}
	/**
	 * 申请党员
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public int add(PartyApply partyApply) {
		return partyApplyDao.add(partyApply);
	}
	
	
}
