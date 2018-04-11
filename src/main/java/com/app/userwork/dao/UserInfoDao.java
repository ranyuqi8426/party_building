package com.app.userwork.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.userwork.model.UserInfo;
import com.app.userwork.vo.UserInfoVO;
import com.app.util.string.StringUtil;


@Repository
public class UserInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	/**
	 * 获取用户信息  id
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 * @param user_id
	 * @return
	 */
	public UserInfo userInfoForId(int user_id) {
		String sql = "select * from t_sys_user t left join t_sys_user_role a on a.user_id = t.user_id where t.user_id=?  ";
		Object[] params = new Object[] { user_id };
		List<UserInfo> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(UserInfo.class));
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 获取用户信息 name
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 * @param username
	 * @param pwd
	 * @return
	 */
	public List<UserInfo> userInfoForName(String user_cd) {
		String sql = "select * from t_sys_user t left join t_sys_user_role a on a.user_id = t.user_id where user_cd=? ";
		Object[] params = new Object[] { user_cd };
		List<UserInfo> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(UserInfo.class));
		return list;
	}
	/**
	 * 获取用户信息  微信QQ
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 * @param username
	 * @param pwd
	 * @return
	 */
	public List<UserInfo> userInfoForOpenId(String user_tencent) {
		String sql = "select * from t_sys_user t left join t_sys_user_role a on a.user_id = t.user_id where user_tencent=? ";
		Object[] params = new Object[] { user_tencent };
		List<UserInfo> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(UserInfo.class));
		return list;
	}
	
	/**
	 * 保存用户信息
	 * @author 冉玉琦
	 * @date 2018年3月3日
	 * @param userInfo
	 * @return
	 */
	public UserInfo updateUserInfo(UserInfo userInfo) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = " update t_sys_user set ";
				sql += " floor_id = :floor_id,";
				if (StringUtil.isNotNullOrEmpty(userInfo.getUser_name())) {
					sql += " user_name = :user_name,";
					sql += " user_nicknm = :user_name,";
				}
				if (StringUtil.isNotNullOrEmpty(userInfo.getSex())) {
					sql += " sex = :sex,";
				}
				if (StringUtil.isNotNullOrEmpty(userInfo.getAge())) {
					sql += " age = :age,";
				}
				if (StringUtil.isNotNullOrEmpty(userInfo.getPolitical_type())) {
					sql += " political_type = :political_type,";
				}
				if (StringUtil.isNotNullOrEmpty(userInfo.getUser_no())) {
					sql += " user_no =:user_no,";
				}
				if (StringUtil.isNotNullOrEmpty(userInfo.getCompany_work())) {
					sql += " company_work =:company_work,";
				}
				if (StringUtil.isNotNullOrEmpty(userInfo.getCompany_rank())) {
					sql += " company_rank =:company_rank,";
				}
				if (StringUtil.isNotNullOrEmpty(userInfo.getHobby())) {
					sql += " hobby =:hobby,";
				}
				if (StringUtil.isNotNullOrEmpty(userInfo.getPhone())) {
					sql += " phone = :phone,";
				}
				if (StringUtil.isNotNullOrEmpty(userInfo.getHome_address())) {
					sql += " home_address =:home_address,";
				}
				
				
				if (StringUtil.isNotNullOrEmpty(userInfo.getHead_img_url())) {
					sql += " head_img_url =:head_img_url,";
				}
				sql = sql.substring(0, sql.length()-1);
				sql += " where user_id = :user_id";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userInfo);
		 if(namedParameterJdbcTemplate.update(sql, paramSource)==1){
			return userInfoForId(userInfo.getUser_id());
		 }
		 return null;
	}
	/**
	 * 修改密码
	 * @author 冉玉琦
	 * @date 2018年3月3日
	 * @param userInfo
	 * @return
	 */
	public int updatePWD(UserInfoVO userInfo) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = " update t_sys_user set ";
				if (StringUtil.isNotNullOrEmpty(userInfo.getNewpsd())) {
					sql += " user_password = :newpsd";
				}
				sql += " where user_id = :user_id and user_password = :oldpsd ";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userInfo);
		 return namedParameterJdbcTemplate.update(sql, paramSource);
	}


}
