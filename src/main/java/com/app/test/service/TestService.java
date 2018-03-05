package com.app.test.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldlifecircle.model.HappyInfoShow;
import com.app.Oldlifecircle.model.HappyParty;
import com.app.Oldlogin.model.SysLogin;
import com.app.OldpartyLecture.model.PartyLectureInfo;
import com.app.OldpartyLecture.model.RealTimeMessage;
import com.app.Oldservice.model.Business;
import com.app.Oldservice.model.Desire;
import com.app.test.dao.TestDao;
import com.app.util.string.StringUtil;


@Service
public class TestService {
	@Autowired 
	private TestDao testDao;
	public void updateSql(String oldUrl,String newUrl) {
		List<HappyParty> list = testDao.querySql();
		for (int i = 0; i < list.size(); i++) {
			if (StringUtil.isNotNullOrEmpty(list.get(i).getImg_url())) {
				list.get(i).setImg_url(list.get(i).getImg_url().replace(oldUrl, newUrl));
			}
			System.out.println(testDao.updateSql(list.get(i)));
		}
		 
		List<PartyLectureInfo> list1 = testDao.querySql1();
		for (int i = 0; i < list1.size(); i++) {
			if (StringUtil.isNotNullOrEmpty(list1.get(i).getLearning_data_url())) {
				list1.get(i).setLearning_data_url(list1.get(i).getLearning_data_url().replace(oldUrl, newUrl));
			}
			if (StringUtil.isNotNullOrEmpty(list1.get(i).getLearning_pic_url())) {
				list1.get(i).setLearning_pic_url(list1.get(i).getLearning_pic_url().replace(oldUrl, newUrl));
			}
			System.out.println(testDao.updateSql1(list1.get(i)));
		}
		 
		 List<RealTimeMessage>  list2= testDao.querySql2();
		 for (int i = 0; i < list2.size(); i++) {
			 if (StringUtil.isNotNullOrEmpty(list2.get(i).getImg_url1())) {
				list2.get(i).setImg_url1(list2.get(i).getImg_url1().replace(oldUrl, newUrl));
			 }
			if (StringUtil.isNotNullOrEmpty(list2.get(i).getImg_url2())) {
				list2.get(i).setImg_url2(list2.get(i).getImg_url2().replace(oldUrl, newUrl));
			}
			if (StringUtil.isNotNullOrEmpty(list2.get(i).getImg_url3())) {
				list2.get(i).setImg_url3(list2.get(i).getImg_url3().replace(oldUrl, newUrl));
			}
			 System.out.println(testDao.updateSql2(list2.get(i)));
		}
		
		 List<HappyInfoShow> list3= testDao.querySql3();
		 for (int i = 0; i < list3.size(); i++) {
			 if (StringUtil.isNotNullOrEmpty(list3.get(i).getImg_one())) {
				list3.get(i).setImg_one(list3.get(i).getImg_one().replace(oldUrl, newUrl));
			 }
			 if (StringUtil.isNotNullOrEmpty(list3.get(i).getImg_two())) {
				list3.get(i).setImg_two(list3.get(i).getImg_two().replace(oldUrl, newUrl));
			 }
			 if (StringUtil.isNotNullOrEmpty(list3.get(i).getImg_three())) {
				list3.get(i).setImg_three(list3.get(i).getImg_three().replace(oldUrl, newUrl));
			 }
			 if (StringUtil.isNotNullOrEmpty(list3.get(i).getImg_four())) {
				list3.get(i).setImg_four(list3.get(i).getImg_four().replace(oldUrl, newUrl));
			 }
			 if (StringUtil.isNotNullOrEmpty(list3.get(i).getImg_five())) {
				list3.get(i).setImg_five(list3.get(i).getImg_five().replace(oldUrl, newUrl));
			 }
			 if (StringUtil.isNotNullOrEmpty(list3.get(i).getImg_six())) {
				list3.get(i).setImg_six(list3.get(i).getImg_six().replace(oldUrl, newUrl));
			 }
			 if (StringUtil.isNotNullOrEmpty(list3.get(i).getImg_seven())) {
				list3.get(i).setImg_seven(list3.get(i).getImg_seven().replace(oldUrl, newUrl));
			 }
			 if (StringUtil.isNotNullOrEmpty(list3.get(i).getImg_eight())) {
				list3.get(i).setImg_eight(list3.get(i).getImg_eight().replace(oldUrl, newUrl));
			 }
			 if (StringUtil.isNotNullOrEmpty(list3.get(i).getImg_nine())) {
				list3.get(i).setImg_nine(list3.get(i).getImg_nine().replace(oldUrl, newUrl));
			 }
			 System.out.println(testDao.updateSql3(list3.get(i)));
			}
		
		 List<SysLogin> list4= testDao.querySql4();
		 for (int i = 0; i < list4.size(); i++) {
			 if (StringUtil.isNotNullOrEmpty(list4.get(i).getUrl())) {
				list4.get(i).setUrl(list4.get(i).getUrl().replace(oldUrl, newUrl));
			 }
			 System.out.println( testDao.updateSql4(list4.get(i)));
			}
		 
		 List<Business>  list5= testDao.querySql5();
		 for (int i = 0; i < list5.size(); i++) {
			 if (StringUtil.isNotNullOrEmpty(list5.get(i).getPic_url1())) {
				list5.get(i).setPic_url1(list5.get(i).getPic_url1().replace(oldUrl, newUrl));
			 }
			 System.out.println(testDao.updateSql5(list5.get(i)));
			}
		 
		 List<Desire>  list6= testDao.querySql6();
		 for (int i = 0; i < list6.size(); i++) {
			 if (StringUtil.isNotNullOrEmpty(list6.get(i).getPic_url1())) {
				list6.get(i).setPic_url1(list6.get(i).getPic_url1().replace(oldUrl, newUrl));
			 }
			 System.out.println(testDao.updateSql6(list6.get(i)));
			}
		
		 
		
	}
}
