package com.app.servicestop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.servicestop.model.WebViewConfig;
import com.app.servicestop.model.WebViewGovernmentUrlConfig;
import com.app.servicestop.model.WebViewLifeConfig;
import com.app.servicestop.model.WebViewLifeUrlConfig;
import com.app.servicestop.model.WebViewUrlConfig;


@Repository
public class WebViewConfigDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 商务列表
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 */
	public List<WebViewConfig> list(){
		String sql = "select t.* from bns_merchant_config t where 1=1 ";
			sql +=" order by t.sort_num  ";
		Object[] params = new Object[] {};
		List<WebViewConfig> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(WebViewConfig.class));
		return list;
	}
	/**
	 * 商务商家列表
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 * @param merchant_config_id;// 
	 */
	public List<WebViewUrlConfig> listBusiness(String merchant_config_id){
		String sql = "select t.* from bns_merchant_configurl t where merchant_config_id =? ";
		sql +=" order by t.sort_num  ";
		Object[] params = new Object[] {merchant_config_id};
		List<WebViewUrlConfig> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(WebViewUrlConfig.class));
		return list;
	}
	public List<WebViewLifeConfig> listLife() {
		String sql = "select t.* from bns_life_config2 t where 1=1 ";
		sql +=" order by t.sort_num  ";
	Object[] params = new Object[] {};
	List<WebViewLifeConfig> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(WebViewLifeConfig.class));
	return list;
	}
	public List<WebViewLifeUrlConfig> listLifeBusiness(String life_config_id) {
		String sql = "select t.* from bns_life_configurl2 t where merchant_config_id =? ";
		sql +=" order by t.sort_num  ";
		Object[] params = new Object[] {life_config_id};
		List<WebViewLifeUrlConfig> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(WebViewLifeUrlConfig.class));
		return list;
	}
	public WebViewGovernmentUrlConfig listGovernment(String floor_id) {
		String sql = "select t.* from bns_government_config t where floor_id =? ";
		Object[] params = new Object[] {floor_id};
		List<WebViewGovernmentUrlConfig> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(WebViewGovernmentUrlConfig.class));
		if (list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	

}
