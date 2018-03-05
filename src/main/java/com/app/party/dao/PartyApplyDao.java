package com.app.party.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.party.model.PartyApply;


@Repository
public class PartyApplyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 申请党员列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public List<PartyApply> list(String floor_id ,String user_id) {
		String sql = "select t.* from bns_party_apply t where ";
				sql += " t.FLOOR_ID =? ";
				sql += " and t.CREATE_CD =? ";
		Object[] params = new Object[] {floor_id,user_id };
		List<PartyApply> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PartyApply.class));
		return list;
	}
	
	
	/**
	 * 申请党员
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param partyApply
	 * @return
	 */
	public int add(PartyApply partyApply) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_party_apply(floor_id,apply_name,apply_age,apply_phone,apply_sex,apply_status,create_cd)";
		sql += " values(:floor_id,:apply_name,:apply_age,:apply_phone,:apply_sex,'1',:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(partyApply);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	
	


}
