package com.app.floorservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.floorservice.dao.WorkStationDao;
import com.app.floorservice.model.WorkStation;



@Service
public class WorkStationService {
	@Autowired
	private WorkStationDao WorkStationeDao;
	public List<WorkStation> list(WorkStation WorkStation) {
		return WorkStationeDao.list(WorkStation);
	}
	
	
	
}
