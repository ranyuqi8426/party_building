package com.app.userwork.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.userwork.model.UserPoint;
import com.app.userwork.model.UserPointRecord;


@Repository
public class UserPointDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 个人积分查询
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

	/**
	 * 积分记录
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @param user_id
	 * @return
	 */
	public List<UserPointRecord> list(int user_id) {
		String sql = "select t.* from bns_point_record t where t.create_cd=?  ";
		
		Object[] params = new Object[] { user_id};
		List<UserPointRecord> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(UserPointRecord.class));
		
		return list;
	}

	/**
	 * 积分表
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @return
	 */
	public List<UserPoint> listPoint() {
		String sql = "select * from bns_point t,t_sys_user a where t.user_id = a.user_id  order by t.add_point desc";
		Object[] params = new Object[] {};
		List<UserPoint> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(UserPoint.class));
		
		return list;
	}
	/**
	 * 新增积分记录
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @param user_id
	 * @return
	 */
	public int add(UserPointRecord userPointRecord) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_point_record (apply_name,apply_age,apply_phone,create_cd)";
		sql += " values(:apply_name,:apply_age,:apply_phone,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userPointRecord);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 修改积分
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @param user_id
	 * @return
	 */

	public int updateUserPoint(int add_point, int reduce_point, String user_id ) {
		String sql = " update bns_point set ";
				sql += " add_point = (add_point + ?),";
				sql += " reduce_point =(reduce_point + ?),";
				sql += " where create_cd = ?";
				Object[] params = new Object[] { add_point,reduce_point,user_id};
		return  jdbcTemplate.update(sql, params);
	}

}
