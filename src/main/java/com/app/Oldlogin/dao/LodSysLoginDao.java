package com.app.Oldlogin.dao;

import java.util.Date;
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

import com.app.Oldlogin.dao.SysUserLocation;
import com.app.Oldlogin.model.PointLog;
import com.app.Oldlogin.model.SysLogin;
import com.app.Oldlogin.model.SysPoint;
import com.app.Oldlogin.model.SysSign;
import com.app.Oldlogin.vo.SysLoginVO;
import com.app.util.string.StringUtil;

@Repository
public class LodSysLoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysLogin> list(SysLoginVO SysLoginVO) {
		String sql = "select * from t_sys_user t where 1=1 ";
		sql += createSearchSql(SysLoginVO);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(SysLoginVO);
		List<SysLogin> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(SysLogin.class));
		return list;
	}
	/**
	 * 生成查询条件
	 */
	private String createSearchSql(SysLoginVO sysLoginVO) {
		String sql = "";
	if (StringUtil.isNotNullOrEmpty(sysLoginVO.getUsername())) {
		sql += " and username = :username";
	}
	if (StringUtil.isNotNullOrEmpty(sysLoginVO.getPassword())) {
		sql += " and password = :password";
	}

		return sql;
	}
	/**
	 * 新增
	 */
	public int add(SysLogin SysLogin) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_sys_user(username,password,mobile,status,role_id,createtime) values(:username,:password,:mobile,:status,:role_id,:createtime)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(SysLogin);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int rc = namedParameterJdbcTemplate.update(sql,paramSource, keyHolder, new String[]{"user_id"});
		if (rc!=0) {
		//签到表插入记录
		SysSign sysSign = new SysSign();
		sysSign.setUser_id(rc);
		sysSign.setContinue_times(0);
		sysSign.setTotal_times(0);
		addSignRecord(sysSign);
		//积分表插入记录
		SysPoint sysPoint = new SysPoint();
		sysPoint.setUser_id(rc);
		sysPoint.setPoint(0);
		sysPoint.setUsed_point(0);
		addPointRecord(sysPoint);
		//位置信息表插入记录
		SysUserLocation sysUserLocation = new SysUserLocation();
		sysUserLocation.setUser_id(rc);
		sysUserLocation.setLasttime(new java.sql.Date(new Date().getTime()));
		addUserLocationRecord(sysUserLocation);
		}
		return rc;
	}
	/**
	 * 积分表插入记录
	 */
	public int addPointRecord(SysPoint sysPoint) {
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_user_point (user_id,point,used_point) values(:user_id,:point,:used_point)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysPoint);
		int flag = namedParameterJdbcTemplate.update(sql,paramSource);
		return flag;
	}
	/**
	 * 位置信息表插入记录
	 */
	public int addUserLocationRecord(SysUserLocation sysUserLocation) {
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_user_location (user_id,lasttime) values(:user_id,:lasttime)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysUserLocation);
		int flag = namedParameterJdbcTemplate.update(sql,paramSource);
		return flag;
	}
	/**
	 * 签到表插入记录
	 */
	public int addSignRecord(SysSign sysSign) {
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_user_sign (user_id,total_times,continue_times) values(:user_id,:total_times,:continue_times)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysSign);
		int flag = namedParameterJdbcTemplate.update(sql,paramSource);
		return flag;
	}
	/**
	 * 签到
	 */
	public int addSign(SysSignLog sysSignLog) {
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_user_sign_log(login_time,user_id) values(:login_time,:user_id)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysSignLog);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int rc = namedParameterJdbcTemplate.update(sql,paramSource, keyHolder, new String[]{"id"});
		
		return rc;
	}
	/**
	 * 获取用户签到记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysSign> getSignRecord(int user_id) {
		String sql = "select t.* from t_user_sign t where t.user_id=?";
		Object[] params = new Object[] { user_id };
		List<SysSign> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(SysSign.class));
		return list;
	}
	/**
	 * 获取用户 签到日志
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysSignLog> getSignLog(int user_id) {
		String sql = "select t.* from t_user_sign_log t where t.user_id=? order by login_time desc,sign_log_id desc ";
		Object[] params = new Object[] { user_id };
		List<SysSignLog> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(SysSignLog.class));
		return list;
	}
	/**
	 * 获取用户三个月 签到日志
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysSignLog> getSignPartLog(int user_id ,Date starDate,Date endDate) {
		String sql = "select t.* from t_user_sign_log t where t.user_id=? and login_time >= ? and login_time <= ? order by login_time desc,sign_log_id desc ";
		Object[] params = new Object[] { user_id,starDate,endDate};
		List<SysSignLog> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(SysSignLog.class));
		return list;
	}
	/**
	 * 更新签到表
	 */
	public int updateSign(SysSign SysSign) {
		String sql = "update t_user_sign set last_login_date=:last_login_date,total_times=:total_times,continue_times=:continue_times where user_id=:user_id";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(SysSign);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	
	
	
	
	
	
	/**
	 * 插入积分记录
	 */
	public int addPointLog(PointLog pointLog) {
		String sql = "insert into t_user_point_log(point_num,user_id,point_type,create_date) values(:point_num,:user_id,:point_type,:create_date)";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(pointLog);
		int flag = namedParameterJdbcTemplate.update(sql, paramSource);
		if (flag == 1) {
			return updatePoint(pointLog.getPoint_num(),pointLog.getUser_id());
		}
		return 0;
	}
	/**
	 * 获取用户积分日志
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PointLog> getPointLog(String user_id) {
		String sql = "select t.* from t_user_point_log t where t.user_id=? order by create_date desc ";
		Object[] params = new Object[] { user_id };
		List<PointLog> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(PointLog.class));
		return list;
	}
	/**
	 * 获取用户积分信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysPoint> getPoint(String user_id) {
		String sql = "select t.* from t_user_point t where t.user_id=? ";
		Object[] params = new Object[] { user_id };
		List<SysPoint> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(SysPoint.class));
		return list;
	}
	/**
	 * 修改总积分
	 */
	public int updatePoint(int num,int user_id) {
		String sql = "update  t_user_point set POINT = POINT+? where user_id = ?";
		return jdbcTemplate.update(sql, num ,user_id);
	}

}
