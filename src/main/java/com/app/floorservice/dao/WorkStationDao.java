package com.app.floorservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.floorservice.model.WorkStation;



@Repository
public class WorkStationDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 生成查询条件
	 */
	private String createSearchSql(WorkStation WorkStation) {
		String sql = "";
		return sql;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WorkStation> list(WorkStation WorkStation) {
		String sql = "select * from bns_floor where 1=1 and IS_DEL = 0";
		sql += createSearchSql(WorkStation);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(WorkStation);
		List<WorkStation> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(WorkStation.class));
		return list;
	}
	

}
