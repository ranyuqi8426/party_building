package com.app.userwork.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.userwork.model.BnsFloor;
import com.app.userwork.model.LoginLog;
import com.app.userwork.model.UserInfo;


@Repository
public class LoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 增加登录日志
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param loginLog
	 */
	public void addLoginLog(LoginLog loginLog) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_sys_user_login(user_id,user_ip,userlogin_type)";
		sql += " values(:user_id,:user_ip,:userlogin_type)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(loginLog);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 获取楼宇列表
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 */
	public List<BnsFloor> queryFloorList() {
		String sql = "select t.* from bns_floor t  order by t.floor_name  ";
		Object[] params = new Object[] {};
		List<BnsFloor> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(BnsFloor.class));
		return list;
	}
	/**
	 * 注册
	 * 注册后初始化数据
	 * 积分表 、用户角色表(普通用户1)  插入初始化记录
	 * @author 冉玉琦
	 * @date 2018年3月3日
	 * @param userInfo
	 * @return
	 */
	public int add(UserInfo userInfo) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_sys_user (user_cd,user_password,phone)";
		sql += " values(:user_cd,:user_password,:phone)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userInfo);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int user_id = namedParameterJdbcTemplate.update(sql,paramSource, keyHolder, new String[]{"user_id"});
		if(user_id != 0){
			String sql1 = "insert into bns_point (user_id,add_point,reduce_point,create_cd)";
			sql1 += " values("+user_id+",0,0,"+user_id+")";
			jdbcTemplate.update(sql1);
			String sql2 = "insert into t_sys_user_role (user_id,role_id)";
			sql2 += " values("+user_id+",1)";
			jdbcTemplate.update(sql2);
			return 1;
		}
		return 0;
		
	}
	

}
