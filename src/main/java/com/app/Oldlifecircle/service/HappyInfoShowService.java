package com.app.Oldlifecircle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldlifecircle.dao.HappyInfoShowDao;
import com.app.Oldlifecircle.model.HappyInfoShow;
import com.app.Oldlifecircle.model.UserCollection;
import com.app.Oldlifecircle.model.UserShow;
import com.app.Oldlifecircle.vo.HappyInfoShowVO;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
@Service
public class HappyInfoShowService {

	@Autowired
	private HappyInfoShowDao HappyInfoShowDao;

	public List<HappyInfoShow> list(HappyInfoShowVO HappyInfoShowVO) {
		List<HappyInfoShow> list = HappyInfoShowDao.list(HappyInfoShowVO);
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
	public List<HappyInfoShow> get(HappyInfoShowVO HappyInfoShowVO) {
		return HappyInfoShowDao.get(HappyInfoShowVO);
	}
	public int addUserShow(int id,int user_id) {
		UserShow userShow = new UserShow();
		userShow.setShow_id(id);
		//点赞
		userShow.setDo_type("2");
		userShow.setUser_id(user_id);
		return HappyInfoShowDao.addUserShow(userShow);
	}
	public int deleteUserShow(int id,int user_id) {
		return HappyInfoShowDao.deleteUserShow( id, user_id);
	}
	public int addCollection(int id,int user_id) {
		UserCollection userCollection = new UserCollection();
		userCollection.setCollection_id(id);
		//小白圈
		userCollection.setCollection_type("1");
		userCollection.setUser_id(user_id);
		return HappyInfoShowDao.addCollection(userCollection);
	}
	public int deleteCollection(int id,int user_id) {
		return HappyInfoShowDao.deleteCollection( id, user_id);
	}

	/**
	 * 新增
	 */
	public int add(HappyInfoShow happyInfoShow) {
		String filepath = "HappyInfoShow/"+happyInfoShow.getUser_id();
		String filename1 = "/"+DateUtil.getShortSystemTime()+"1.jpg";
		String filename2 = "/"+DateUtil.getShortSystemTime()+"2.jpg";
		String filename3 = "/"+DateUtil.getShortSystemTime()+"3.jpg";
		String filename4 = "/"+DateUtil.getShortSystemTime()+"4.jpg";
		String filename5 = "/"+DateUtil.getShortSystemTime()+"5.jpg";
		String filename6 = "/"+DateUtil.getShortSystemTime()+"6.jpg";
		String filename7 = "/"+DateUtil.getShortSystemTime()+"7.jpg";
		String filename8 = "/"+DateUtil.getShortSystemTime()+"8.jpg";
		String filename9 = "/"+DateUtil.getShortSystemTime()+"9.jpg";
		//未通过
		happyInfoShow.setAudit_status("2");
		happyInfoShow.setCreate_time(new java.sql.Date(new java.util.Date().getTime()));
		//创建
		happyInfoShow.setDo_type("1");
		//阅读人数
		happyInfoShow.setRead_num(1);
		if (happyInfoShow.getImg_ones()!=null) {
			boolean flag =ImgFile.GenerateImageForFile(happyInfoShow.getImg_ones(), filepath, filename1);
			if (flag) {
				happyInfoShow.setImg_one(ConstantUtil.weburl+filepath+filename1);
			}else {
				happyInfoShow.setImg_one("");
			}
		}
		if (happyInfoShow.getImg_twos()!=null) {
			boolean flag =ImgFile.GenerateImageForFile(happyInfoShow.getImg_twos(), filepath, filename2);
			if (flag) {
				happyInfoShow.setImg_two(ConstantUtil.weburl+filepath+filename2);
			}else {
				happyInfoShow.setImg_two("");
			}
				}
		if (happyInfoShow.getImg_threes()!=null) {
			boolean flag =ImgFile.GenerateImageForFile(happyInfoShow.getImg_threes(), filepath, filename3);
			if (flag) {
				happyInfoShow.setImg_three(ConstantUtil.weburl+filepath+filename3);
			}else {
				happyInfoShow.setImg_three("");
			}
		}
		
		if (happyInfoShow.getImg_fours()!=null) {
			boolean flag =ImgFile.GenerateImageForFile(happyInfoShow.getImg_fours(), filepath, filename4);
			if (flag) {
				happyInfoShow.setImg_four(ConstantUtil.weburl+filepath+filename4);
			}else {
				happyInfoShow.setImg_four("");
			}
		}
		if (happyInfoShow.getImg_fives()!=null) {
			boolean flag =ImgFile.GenerateImageForFile(happyInfoShow.getImg_fives(), filepath, filename5);
			if (flag) {
				happyInfoShow.setImg_five(ConstantUtil.weburl+filepath+filename5);
			}else {
				happyInfoShow.setImg_five("");
			}
		}
		if (happyInfoShow.getImg_sixs()!=null) {
			boolean flag =ImgFile.GenerateImageForFile(happyInfoShow.getImg_sixs(), filepath, filename6);
			if (flag) {
				happyInfoShow.setImg_six(ConstantUtil.weburl+filepath+filename6);
			}else {
				happyInfoShow.setImg_six("");
			}
		}
		if (happyInfoShow.getImg_sevens()!=null) {
			boolean flag =ImgFile.GenerateImageForFile(happyInfoShow.getImg_sevens(), filepath, filename7);
			if (flag) {
				happyInfoShow.setImg_seven(ConstantUtil.weburl+filepath+filename7);
			}else {
				happyInfoShow.setImg_seven("");
			}
		}
		if (happyInfoShow.getImg_eights()!=null) {
			boolean flag =ImgFile.GenerateImageForFile(happyInfoShow.getImg_eights(), filepath, filename8);
			if (flag) {
				happyInfoShow.setImg_eight(ConstantUtil.weburl+filepath+filename8);
			}else {
				happyInfoShow.setImg_eight("");
			}
		}
		if (happyInfoShow.getImg_nines()!=null) {
			boolean flag =ImgFile.GenerateImageForFile(happyInfoShow.getImg_nines(), filepath, filename9);
			if (flag) {
				happyInfoShow.setImg_nine(ConstantUtil.weburl+filepath+filename9);
			}else {
				happyInfoShow.setImg_nine("");
			}
		}

		
		return HappyInfoShowDao.add(happyInfoShow);
	}
	
	

}
