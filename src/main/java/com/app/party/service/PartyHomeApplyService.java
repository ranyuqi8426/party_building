package com.app.party.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.party.dao.PartyHomeApplyDao;
import com.app.party.model.PartyHomeApply;

@Service
public class PartyHomeApplyService {
	@Autowired
	private PartyHomeApplyDao partyHomeApplyDao;
	
	/**
	 * 成立组织列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public int list(String floor_id,String user_id) {
		List<PartyHomeApply> list = partyHomeApplyDao.list(floor_id,user_id);
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
	 * 成立组织
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public int add(PartyHomeApply partyHomeApply) {
		return partyHomeApplyDao.add(partyHomeApply);
	}
	
	
}
