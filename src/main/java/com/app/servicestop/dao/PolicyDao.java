package com.app.servicestop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.servicestop.model.Policy;
import com.app.util.page.PageUtil;


@Repository
public class PolicyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 政策发布列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public List<Policy> list(String floorid,String policy_type,int pageSize) {
		String sql = "select t.* from bns_policy t where t.floor_id=? and policy_type = ? and policy_status ='2' order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { floorid,policy_type};
		List<Policy> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Policy.class));
		return list;
	}
	



}
