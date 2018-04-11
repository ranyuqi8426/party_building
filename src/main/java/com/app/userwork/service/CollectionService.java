package com.app.userwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.userwork.dao.CollectionDao;
import com.app.userwork.model.Collection;
import com.app.userwork.vo.CollectionVO;

@Service
public class CollectionService {

	@Autowired
	private CollectionDao CollectionDao;
	public List<Collection> list(CollectionVO CollectionVO) {
		List<Collection> list = CollectionDao.list(CollectionVO);
		return list;
	}
//	
//	public List<Collection> get(String id,String uid) {
//		return CollectionDao.get(id,uid);
//	} 
//	

	/**
	 * 删除
	 */
	public int delete(String account_id) {
		return CollectionDao.delete(account_id);
	}
}
