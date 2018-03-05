package com.app.Oldmy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldlifecircle.model.HappyParty;
import com.app.Oldlogin.model.SysLogin;
import com.app.Oldmy.model.HappyInfoShow;
import com.app.Oldmy.vo.CollectionVO;
import com.app.util.page.PageUtil;
@Repository
public class UserInfoMargerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 修改头像
	 * 
	 * @return
	 */
	public int updateHearUrl(String user_id,String HearUrl) {
		String sql = "update t_sys_user set url = ? where user_id = ?";
		return jdbcTemplate.update(sql,  HearUrl,user_id);
	}
	/**
	 * 修改用户信息
	 * @param SysLogin
	 * @return
	 */
	public int updateUserInfo(SysLogin SysLogin) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "update t_sys_user set realname = :realname,gender = :gender,age=:age,company=:company,post=:post,isdang=:isdang where user_id = :user_id";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(SysLogin);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 获取用户信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysLogin> getUserInfo(SysLogin SysLogin) {
		String sql = "select * from t_sys_user where ";
		sql +=" user_id = :user_id ";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(SysLogin);
		List<SysLogin> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(SysLogin.class));
		return list;
	}

}
