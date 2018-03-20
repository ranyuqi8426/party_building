package com.app.party.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.party.model.PartyMoney;
import com.app.util.page.PageUtil;


@Repository
public class PartyMoneyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 党费缴纳列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public List<PartyMoney> list(String floor_id ,String user_id,int pageSize) {
		String sql = "select t.*,(select a.user_nicknm from t_sys_user a where a.user_id = t.user_id) as user_name from bns_party_money t where ";
				sql += "  t.USER_ID =? ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] {user_id };
		List<PartyMoney> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PartyMoney.class));
		return list;
	}
	
	
	/**
	 * 党费缴纳
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param partyApply
	 * @return
	 */
	public int add(PartyMoney partyMoney) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_party_money(user_id,pay_time,pay_money,party_home,create_cd)";
		sql += " values(:user_id,:pay_time,:pay_money,:party_home,:user_id)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(partyMoney);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	
	


}
