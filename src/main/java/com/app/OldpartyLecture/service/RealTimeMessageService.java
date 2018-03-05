package com.app.OldpartyLecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldlifecircle.model.UserCollection;
import com.app.OldpartyLecture.dao.RealTimeMessageDao;
import com.app.OldpartyLecture.model.RealTimeMessage;
import com.app.OldpartyLecture.vo.RealTimeMessageVO;
@Service
public class RealTimeMessageService {

	@Autowired
	private RealTimeMessageDao RealTimeMessageDao;

	public List<RealTimeMessage> list(RealTimeMessageVO RealTimeMessageVO) {
		List<RealTimeMessage> list = RealTimeMessageDao.list(RealTimeMessageVO);
		if(list!=null){
		for (int i = 0; i < list.size(); i++) {
			String Realtimeinfo_content = list.get(i).getRealtimeinfo_content();
			if (Realtimeinfo_content != null && Realtimeinfo_content.length()>80) {
				list.get(i).setRealtimeinfo_content(Realtimeinfo_content.substring(0, 80)+"......(阅读全文)");
			}
			if(list.get(i).getImg_url3() != null&&!list.get(i).getImg_url3().equals("")){
				list.get(i).setImgnum(3);
			}else if(list.get(i).getImg_url2() != null&&!list.get(i).getImg_url2().equals("")){
				list.get(i).setImgnum(2);
			}else if(list.get(i).getImg_url1() != null&&!list.get(i).getImg_url1().equals("")){
				list.get(i).setImgnum(1);
			}
			
			
		}
		}
		return list;
	}
	public List<RealTimeMessage> get(RealTimeMessageVO RealTimeMessageVO) {
		return RealTimeMessageDao.get(RealTimeMessageVO);
	}
	public int addCollection(int id,int user_id) {
		UserCollection userCollection = new UserCollection();
		userCollection.setCollection_id(id);
		//信息咨询
		userCollection.setCollection_type("2");
		userCollection.setUser_id(user_id);
		return RealTimeMessageDao.addCollection(userCollection);
	}
	public int deleteCollection(int id,int user_id) {
		return RealTimeMessageDao.deleteCollection( id, user_id);
	}



}
