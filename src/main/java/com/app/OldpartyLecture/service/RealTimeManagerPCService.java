package com.app.OldpartyLecture.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.OldpartyLecture.dao.RealTimeManagerPCDao;
import com.app.OldpartyLecture.model.RealTimeMessage;
import com.app.OldpartyLecture.vo.RealTimeMessagePCVO;

@Service
public class RealTimeManagerPCService {
	@Autowired
	private  RealTimeManagerPCDao  RealTimeManagerPCDao;
	private static String imgpath = "E:/resourcesfile/images/partyLectureVideoImg";
	private static String videopath = "E:/resourcesfile/video";
	/**
	 * 总数
	 */
	public int listCount(RealTimeMessagePCVO RealTimeMessagePCVO) {
		return  RealTimeManagerPCDao.listCount(RealTimeMessagePCVO);
	} 
	/**
	 * 新增
	 */
	public int add(RealTimeMessage RealTimeMessage) {
//		if(RealTimeMessage.getLearning_data()!=null&&RealTimeMessage.getLearning_pic()!=null){
//			String dateStr = DateUtil.getShortSystemTime();
//			String filepath = "";
//			String filename = "/"+dateStr+".mp4";
//			boolean flag = ImgFile.GenerateVideoForFile(RealTimeMessage.getLearning_data(),filepath ,filename );
//			if (flag) {
//				RealTimeMessage.setLearning_data_url(ConstantUtil.weburl+filepath+filename);
//			}else {
//				RealTimeMessage.setLearning_data_url("");
//			}
//			
//			String fileimgpath = "partyLectureVideoImg";
//			String fileimgname = "/"+dateStr+".jpg";
//			boolean flagimg = ImgFile.GenerateImageForFile(RealTimeMessage.getLearning_pic(),fileimgpath ,fileimgname );
//			if (flagimg) {
//				RealTimeMessage.setLearning_pic_url(ConstantUtil.weburl+filepath+filename);
//			}else {
//				RealTimeMessage.setLearning_pic_url("");
//			}
//		}
		RealTimeMessage.setRealtimeinfo_time(new Date(new java.util.Date().getTime()));
		return  RealTimeManagerPCDao.add(RealTimeMessage);
	}
	/**
	 * 修改
	 */
//	public int update(RealTimeMessage RealTimeMessage) {
//		return  RealTimeManagerPCDao.update(RealTimeMessage);
//	}
	/**
	 * 列表
	 */
	public List<RealTimeMessage> list(RealTimeMessagePCVO RealTimeMessagePCVO) {
		List<RealTimeMessage> list = RealTimeManagerPCDao.list(RealTimeMessagePCVO);
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
//				String Realtimeinfo_content = list.get(i).getRealtimeinfo_content();
//				if (Realtimeinfo_content != null && Realtimeinfo_content.length()>80) {
//					list.get(i).setRealtimeinfo_content(Realtimeinfo_content.substring(0, 80)+"......(阅读全文)");
//				}
				if(list.get(i).getImg_url3() != null&&!list.get(i).getImg_url3().equals("")){
					list.get(i).setImgnum(3);
				}else if(list.get(i).getImg_url2() != null&&!list.get(i).getImg_url2().equals("")){
					list.get(i).setImgnum(2);
				}else if(list.get(i).getImg_url1() != null&&!list.get(i).getImg_url1().equals("")){
					list.get(i).setImgnum(1);
				}
				
				
			}
			}
		return  list;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int realtimeinfo_id) {
//		RealTimeMessage RealTimeMessage =  RealTimeManagerPCDao.get(realtimeinfo_id);
		int flag =  RealTimeManagerPCDao.delete(realtimeinfo_id);
//		//删除文件
//		if(flag == 1){
//			String Learning_data_url = RealTimeMessage.getLearning_data_url();
//			if(StringUtil.isNotNullOrEmpty(Learning_data_url)){
//				ImgFile.deleteFile(videopath+Learning_data_url.substring(Learning_data_url.lastIndexOf("/")));
//			}
//			String Learning_pic_url = RealTimeMessage.getLearning_pic_url();
//			if (StringUtil.isNotNullOrEmpty(Learning_pic_url)) {
//				ImgFile.deleteFile(imgpath+Learning_pic_url.substring(Learning_pic_url.lastIndexOf("/")));
//			}
//			
//		}
		
		return flag;
	}
}
