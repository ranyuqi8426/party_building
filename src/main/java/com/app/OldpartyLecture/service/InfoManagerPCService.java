package com.app.OldpartyLecture.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.OldpartyLecture.dao.InfoManagerPCDao;
import com.app.OldpartyLecture.model.DataManagerPC;
import com.app.OldpartyLecture.model.PartyLectureInfo;
import com.app.OldpartyLecture.vo.DataManagerPCVO;

@Service
public class InfoManagerPCService {
	@Autowired
	private InfoManagerPCDao InfoManagerPCDao;
	/**
	 * 总数
	 */
	public int listCount(DataManagerPCVO dataManagerPCVO) {
		return InfoManagerPCDao.listCount(dataManagerPCVO);
	} 
	/**
	 * 新增
	 */
	public int add(DataManagerPC dataManagerPC) {
		dataManagerPC.setCreate_date(new Date(new java.util.Date().getTime()));
		//3、理论知识
		dataManagerPC.setLearning_data_type("3");
		return InfoManagerPCDao.add(dataManagerPC);
	}
	/**
	 * 修改
	 */
	public int update(DataManagerPC dataManagerPC) {
		dataManagerPC.setCreate_date(new Date(new java.util.Date().getTime()));
		return InfoManagerPCDao.update(dataManagerPC);
	}
	/**
	 * 列表
	 */
	public List<DataManagerPC> list(DataManagerPCVO dataManagerPCVO) {
		List<DataManagerPC> list = InfoManagerPCDao.list(dataManagerPCVO);
//		if(list!=null){
//			for (int i = 0; i < list.size(); i++) {
//				String Realtimeinfo_content = list.get(i).getLearning_content();
//				if (Realtimeinfo_content != null && Realtimeinfo_content.length()>50) {
//					list.get(i).setLearning_content(Realtimeinfo_content.substring(0, 50)+"......(阅读全文)");
//				}
//			}
//			}
		return list;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int learning_data_id) {
		return InfoManagerPCDao.delete(learning_data_id);
	}
}
