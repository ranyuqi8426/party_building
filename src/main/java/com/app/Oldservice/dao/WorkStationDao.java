package com.app.Oldservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldservice.model.CreateParty;
import com.app.Oldservice.model.GoParty;
import com.app.Oldservice.model.WorkStation;
import com.app.util.page.PageUtil;



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
		String sql = "select * from t_data_worklocation where 1=1 ";
		sql += createSearchSql(WorkStation);
		sql = PageUtil.createMysqlPageSql(sql,WorkStation.getPage(),WorkStation.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(WorkStation);
		List<WorkStation> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(WorkStation.class));
		return list;
	}
	/**
	 * 新建 我是党员/我要入党
	 * @return
	 */
	public int addparty(GoParty GoParty) {
		String sql = "insert into t_user_goparty(user_id,work_info_id,party_name,party_sex,party_no,company,party_tel,party_address,party_type,party_status,audit_id,audit_date,create_date) ";
		sql+="values(:user_id,:work_info_id,:party_name,:party_sex,:party_no,:company,:party_tel,:party_address,:party_type,:party_status,:audit_id,:audit_date,:create_date)";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(GoParty);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 新建党组织
	 * @return
	 */
	public int addpartyteam(CreateParty CreateParty) {
		String sql = "insert into t_user_createparty(user_id,work_info_id,company_name,party_num,contacts,contacts_tel,company_address,party_status,audit_id,audit_date,create_date) ";
		sql += "values(:user_id,:work_info_id,:company_name,:party_num,:contacts,:contacts_tel,:company_address,:party_status,:audit_id,:audit_date,:create_date)";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(CreateParty);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

}
