package com.app.userwork.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.userwork.dao.LoopimgConfigDao;
import com.app.userwork.model.LoopimgConfig;

@Service
public class LoopimgConfigService {
	@Autowired
	private LoopimgConfigDao loopimgConfigDao;
	
	
	/**
	 * 轮播图列表
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 */
	public List<LoopimgConfig> queryLoopimgConfigList(String source_type) {
		return loopimgConfigDao.queryLoopimgConfigList(source_type);
	}
}
