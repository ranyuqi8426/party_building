package com.app.userwork.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.userwork.model.UserSign;


@Repository
public class UserSignDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 签到
	 * @author 冉玉琦
	 * @date 2018年3月4日
	 * @param user_id
	 * @return
	 */
	public int add(int user_id) {
		String sql = "insert into bns_sign_record(user_id)";
		sql += " values("+user_id+")";
		return jdbcTemplate.update(sql);
	}
	/**
	 * 查询签到记录
	 * @author 冉玉琦
	 * @date 2018年3月4日
	 * @param startDate
	 * @param endDate
	 * @param user_id
	 * @return
	 */
	public List<UserSign> list(String startDate, String endDate, int user_id) {
		String sql = "select t.* from bns_sign_record t where t.user_id=? "
				+ " and to_days(sign_time)=to_days(now()) "
				+ " order by t.sign_time desc ";
		Object[] params = new Object[] { user_id};
		List<UserSign> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(UserSign.class));
		return list;
	}

	
}
