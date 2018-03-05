package com.app.Oldlifecircle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldlifecircle.dao.HappyInfoShowPCDao;
import com.app.Oldlifecircle.model.HappyInfoShow;
import com.app.Oldlifecircle.vo.HappyInfoShowVO;
import com.app.util.session.SessionUtil;


/**
 * 
 */
@Service
public class HappyInfoShowPCService {

	@Autowired
	private HappyInfoShowPCDao HappyInfoShowDao;

	/**
	 * 总数
	 */
	public int listCount(HappyInfoShowVO HappyInfoShowVO) {
		return HappyInfoShowDao.listCount(HappyInfoShowVO);
	}

	/**
	 * 列表
	 */
	public List<HappyInfoShow> list(HappyInfoShowVO HappyInfoShowVO, int pageIndex, int pageSize) {
		return HappyInfoShowDao.list(HappyInfoShowVO, pageIndex, pageSize);
	}

	/**
	 * 新增
	 */
	public int add(HappyInfoShow HappyInfoShow) {
		return HappyInfoShowDao.add(HappyInfoShow);
	}

	/**
	 * 修改
	 */
	public int update(String show_id,String Status,int auditor_id) {
		
		return HappyInfoShowDao.update(show_id,Status,auditor_id);
	}

	/**
	 * 删除
	 */
	public int delete(String id) {
		return HappyInfoShowDao.delete(id);
	}

}
