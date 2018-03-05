package com.app.party.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.party.model.PartyCase;
import com.app.util.page.PageUtil;


@Repository
public class PartyCaseDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 身边榜样列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public List<PartyCase> list(String floorid ,int pageSize,String isDop) {
		String sql = "select t.* from bns_party_case t where ";
				sql += " t.IS_TOP =? ";
				sql += " order by  t.CREATE_TIME desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] {isDop };
		List<PartyCase> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PartyCase.class));
		return list;
	}
	
	
	/**
	 * 身边榜样详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PartyCase get(String list_id) {
		String sql = "select t.* from bns_news t where t.news_id=? ";
		Object[] params = new Object[] { list_id };
		List<PartyCase> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(PartyCase.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	
	


}
