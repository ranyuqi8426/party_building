package com.app.Oldmy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldmy.dao.CollectionDao;
import com.app.Oldmy.model.Collection;
import com.app.Oldmy.model.HappyInfoShow;
import com.app.Oldmy.model.PartyLectureInfo;
import com.app.Oldmy.model.RealTimeMessage;
import com.app.Oldmy.vo.CollectionVO;
@Service
public class CollectionService {

	@Autowired
	private CollectionDao CollectionDao;
	public List<HappyInfoShow> listShaiShai(CollectionVO CollectionVO) {
		List<HappyInfoShow> list = CollectionDao.listShaiShai(CollectionVO);
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				String Realtimeinfo_content = list.get(i).getContent();
				if (Realtimeinfo_content != null && Realtimeinfo_content.length()>80) {
					list.get(i).setContent(Realtimeinfo_content.substring(0, 80)+"......(阅读全文)");
				}
				if(list.get(i).getImg_nine() != null&&!list.get(i).getImg_nine().equals("")){
					list.get(i).setImgnum(9);
				}else if(list.get(i).getImg_eight()!= null&&!list.get(i).getImg_eight().equals("")){
					list.get(i).setImgnum(8);
				}else if(list.get(i).getImg_seven() != null&&!list.get(i).getImg_seven().equals("")){
					list.get(i).setImgnum(7);
				}else if(list.get(i).getImg_six() != null&&!list.get(i).getImg_six().equals("")){
					list.get(i).setImgnum(6);
				}else if(list.get(i).getImg_five() != null&&!list.get(i).getImg_five().equals("")){
					list.get(i).setImgnum(5);
				}else if(list.get(i).getImg_four() != null&&!list.get(i).getImg_four().equals("")){
					list.get(i).setImgnum(4);
				}else if(list.get(i).getImg_three() != null&&!list.get(i).getImg_three().equals("")){
					list.get(i).setImgnum(3);
				}else if(list.get(i).getImg_two() != null&&!list.get(i).getImg_two().equals("")){
					list.get(i).setImgnum(2);
				}else if(list.get(i).getImg_one() != null&&!list.get(i).getImg_one().equals("")){
					list.get(i).setImgnum(1);
				}
				
			}
			}
		return list;
	}
	public List<RealTimeMessage> listMessage(CollectionVO CollectionVO) {
		List<RealTimeMessage> list = CollectionDao.listMessage(CollectionVO);
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
	public List<PartyLectureInfo> listInfo(CollectionVO CollectionVO) {
		return CollectionDao.listInfo(CollectionVO);
	}
	public List<PartyLectureInfo> listVideo(CollectionVO CollectionVO) {
		return CollectionDao.listVideo(CollectionVO);
	}
	public List<PartyLectureInfo> listBook(CollectionVO CollectionVO) {
		return CollectionDao.listBook(CollectionVO);
	}
	public List<Collection> get(String id,String uid) {
		return CollectionDao.get(id,uid);
	} 
	

	/**
	 * 删除
	 */
	public int delete(String account_id) {
		return CollectionDao.delete(account_id);
	}
}
