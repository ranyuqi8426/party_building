package com.app.servicestop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.servicestop.dao.WebViewConfigDao;
import com.app.servicestop.model.WebViewConfig;
import com.app.servicestop.model.WebViewGovernmentUrlConfig;
import com.app.servicestop.model.WebViewLifeConfig;
import com.app.servicestop.model.WebViewLifeUrlConfig;
import com.app.servicestop.model.WebViewUrlConfig;

@Service
public class WebViewConfigService {
	@Autowired
	private WebViewConfigDao webViewConfigDao;
	
	/**
	 * 商务列表
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<WebViewConfig> list() {
		List<WebViewConfig> list = webViewConfigDao.list();
		
		return list;
	}
	/**
	 *商务商家列表
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<WebViewUrlConfig> listBusiness(String merchant_config_id) {
		List<WebViewUrlConfig> list = webViewConfigDao.listBusiness(merchant_config_id);
		
		return list;
	}
	public List<WebViewLifeConfig> listLife() {
		return  webViewConfigDao.listLife();
	}
	public List<WebViewLifeUrlConfig> listLifeBusiness(String life_config_id) {
		return webViewConfigDao.listLifeBusiness(life_config_id);
	}
	public WebViewGovernmentUrlConfig listGovernment(String floor_id) {
		return webViewConfigDao.listGovernment(floor_id);
	}
	
	
}
