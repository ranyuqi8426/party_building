package com.app.OldpartyLecture.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldlifecircle.model.UserCollection;
import com.app.Oldlogin.dao.LodSysLoginDao;
import com.app.Oldlogin.model.PointLog;
import com.app.OldpartyLecture.dao.PartyLectureInfoDao;
import com.app.OldpartyLecture.model.BookChapter;
import com.app.OldpartyLecture.model.BookText;
import com.app.OldpartyLecture.model.PartyLectureInfo;
import com.app.OldpartyLecture.model.StudyRecord;
import com.app.OldpartyLecture.vo.BookChapterVO;
import com.app.OldpartyLecture.vo.BookTextVO;
import com.app.OldpartyLecture.vo.PartyLectureInfoVO;
import com.app.util.point.PointUtil;
@Service
public class PartyLectureInfoService {

	@Autowired
	private PartyLectureInfoDao PartyLectureInfoDao;
	@Autowired
	private LodSysLoginDao sysLoginDao;

	public List<PartyLectureInfo> list(PartyLectureInfoVO PartyLectureInfoVO) {
		List<PartyLectureInfo> list = PartyLectureInfoDao.list(PartyLectureInfoVO);
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				String Realtimeinfo_content = list.get(i).getLearning_content();
				if (Realtimeinfo_content != null && Realtimeinfo_content.length()>80) {
					list.get(i).setLearning_content(Realtimeinfo_content.substring(0, 80)+"......(阅读全文)");
				}
			}
			}
		return list;
	}
	public List<PartyLectureInfo> get(PartyLectureInfoVO PartyLectureInfoVO) {
		return PartyLectureInfoDao.get(PartyLectureInfoVO);
	}
	public int addCollection(int id,int user_id) {
		UserCollection userCollection = new UserCollection();
		userCollection.setCollection_id(id);
		//理论学习
		userCollection.setCollection_type("3");
		userCollection.setUser_id(user_id);
		return PartyLectureInfoDao.addCollection(userCollection);
	}
	public int deleteCollection(int id,int user_id) {
		return PartyLectureInfoDao.deleteCollection( id, user_id,"3");
	}
	public List<BookChapter> listBook(BookChapterVO BookChapterVO) {
		List<BookChapter> list = PartyLectureInfoDao.addBook(BookChapterVO);
		return list;
	} 
	public List<BookText> getBookContext(BookTextVO BookTextVO) {
		return PartyLectureInfoDao.getBookContext(BookTextVO);
	}
	public int addTypeCollection(int id,int user_id,String type) {
		UserCollection userCollection = new UserCollection();
		userCollection.setCollection_id(id);
		//4视频  5书刊
		userCollection.setCollection_type(type);
		userCollection.setUser_id(user_id);
		return PartyLectureInfoDao.addCollection(userCollection);
	}
	public int deleteTypeCollection(int id,int user_id,String type) {
		return PartyLectureInfoDao.deleteCollection( id, user_id,type);
	}
	public int addStudyRecord(int id,String user_id,String type) {
		PartyLectureInfoVO partyLectureInfoVO = new PartyLectureInfoVO();
		partyLectureInfoVO.setLearning_data_id(id);
		partyLectureInfoVO.setUser_id(user_id);
		
		if(type != null&&type.equals("2")){
			//书籍
			partyLectureInfoVO.setLearning_type("2");
		}else{
			//视频
			partyLectureInfoVO.setLearning_type("1");
		}
		return PartyLectureInfoDao.addStudyRecord(partyLectureInfoVO);
	}
	public int updateStudyRecord(int record_id,String learning_type,String time_num) {
		StudyRecord studyRecord = new StudyRecord();
		studyRecord.setId(record_id);
//		studyRecord.setLearning_type(learning_type);
		studyRecord.setLearning_end_time(new Date(new java.util.Date().getTime()));
		
		//积分计算
		int num = PointUtil.getPointNum(time_num, learning_type);
		studyRecord.setLearning_point(num);
		int flag = PartyLectureInfoDao.updateStudyRecord(studyRecord);
		if (flag == 1) {
			PointLog pointLog = new PointLog();
			pointLog.setCreate_date(new java.sql.Date(new java.util.Date().getTime()));
			pointLog.setPoint_num(num);
			//学习
			pointLog.setPoint_type(learning_type);
			List<StudyRecord> list = PartyLectureInfoDao.getStudyRecord(record_id);
			if (list!=null&&list.size()>0) {
				pointLog.setUser_id(list.get(0).getUser_id());
				sysLoginDao.addPointLog(pointLog);
			}
		}
		return flag;
	}

}
