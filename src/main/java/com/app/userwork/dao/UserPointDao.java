package com.app.userwork.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.userwork.model.UserPoint;


@Repository
public class UserPointDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	/**
	 * 积分查询
	 * @author 冉玉琦
	 * @date 2018年3月4日
	 * @param user_id
	 * @return
	 */
	public UserPoint getPointForUserId(int user_id) {
		String sql = "select t.* from bns_point t where t.user_id=?  ";
				
		Object[] params = new Object[] { user_id};
		List<UserPoint> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(UserPoint.class));
		if (list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	
}
