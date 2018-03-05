package com.app.party.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.party.model.PartyHomeApply;


@Repository
public class PartyHomeApplyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 成立组织列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public List<PartyHomeApply> list(String floor_id ,String user_id) {
		String sql = "select t.* from bns_partyhome_apply t where ";
				sql += " t.FLOOR_ID =? ";
				sql += " and t.CREATE_CD =? ";
		Object[] params = new Object[] {floor_id,user_id };
		List<PartyHomeApply> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PartyHomeApply.class));
		return list;
	}
	
	
	/**
	 * 成立组织
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param partyApply
	 * @return
	 */
	public int add(PartyHomeApply partyHomeApply) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_partyhome_apply(floor_id,company_name,apply_num,phone,user_name,company_position,apply_status,create_cd)";
		sql += " values(:floor_id,:company_name,:apply_num,:phone,:user_name,:company_position,'1',:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(partyHomeApply);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	


}
