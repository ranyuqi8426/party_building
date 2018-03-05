package com.app.party.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.party.model.PartyHomeSearch;


@Repository
public class PartyHomeSearchDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 找组织列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public List<PartyHomeSearch> list(String floor_id ,String user_id) {
		String sql = "select t.* from bns_partyhome_search t where ";
				sql += " t.FLOOR_ID =? ";
				sql += " and t.CREATE_CD =? ";
		Object[] params = new Object[] {floor_id,user_id };
		List<PartyHomeSearch> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PartyHomeSearch.class));
		return list;
	}
	
	
	/**
	 * 找组织
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param partyHomeSearch
	 * @return
	 */
	public int add(PartyHomeSearch partyHomeSearch) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_partyhome_search (floor_id,search_name,search_phone,search_address,search_companyname,search_companyposition,search_userno,search_content,search_status,create_cd)";
		sql += " values(:floor_id,:search_name,:search_phone,:search_address,:search_companyname,:search_companyposition,:search_userno,:search_content,'1',:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(partyHomeSearch);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	


}
