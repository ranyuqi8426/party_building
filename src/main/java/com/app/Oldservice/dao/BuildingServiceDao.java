package com.app.Oldservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldservice.model.Ask;
import com.app.Oldservice.model.BuildingInfo;
import com.app.Oldservice.model.BuildingService;
import com.app.util.page.PageUtil;



@Repository
public class BuildingServiceDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 生成查询条件
	 */
	private String createSearchSql(BuildingInfo buildingInfo) {
		String sql = "";
		return sql;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BuildingInfo> list(BuildingInfo buildingInfo) {
		String sql = "select * from T_DATA_BUILDING_INFO where 1=1 ";
		sql += createSearchSql(buildingInfo);
		sql = PageUtil.createMysqlPageSql(sql,buildingInfo.getPage(),buildingInfo.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(buildingInfo);
		List<BuildingInfo> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(BuildingInfo.class));
		return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BuildingService> ServiceList(BuildingInfo buildingInfo) {
		String sql = "select * from T_USER_BUILDING_ACT where building_id=? ";
		//要求必须审核通过
		//等有审核端后再加上
//		sql += " and AUDIT_STATUS = 1";
		sql = PageUtil.createMysqlPageSql(sql, buildingInfo.getPage(), buildingInfo.getLimit());
		Object[] params = new Object[] { buildingInfo.getBuilding_id() };
		List<BuildingService> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(BuildingService.class));
		return list;
	}
	public int add(BuildingService buildingService) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into T_USER_BUILDING_ACT(USER_ID,BUILDING_ID,TITLE,CONTENT,AUDITOR_ID,AUDIT_STATUS,TIME,STATUS) values(:user_id,:building_id,:title,:content,:auditor_id,:audit_status,:time,:status)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(buildingService);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	public int addPublish(Ask ask) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into T_USER_ASK(TYPE,USER_ID,CONTENT,KINDOF,TIME,USER_ANSWER_ID) values(:type,:user_id,:content,:kindof,:time,:user_answer_id)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(ask);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Ask> askList(Ask ask) {
		String sql = "select * from T_USER_ASK where 1=1 ";
		sql += " and user_id = " + ask.getUser_id();
		sql += " and type = " + ask.getType();
		sql += " order by time";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(ask);
		List<Ask> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(Ask.class));
		return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BuildingInfo> oneInfo(String buildingId) {
		String sql = "select * from T_DATA_BUILDING_INFO where building_id=? ";
		Object[] params = new Object[] { buildingId };
		List<BuildingInfo> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(BuildingInfo.class));
		return list;
	}

}
