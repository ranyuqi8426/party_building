package com.app.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldlifecircle.model.HappyInfoShow;
import com.app.Oldlifecircle.model.HappyParty;
import com.app.Oldlogin.model.SysLogin;
import com.app.OldpartyLecture.model.PartyLectureInfo;
import com.app.OldpartyLecture.model.RealTimeMessage;
import com.app.Oldservice.model.Business;
import com.app.Oldservice.model.Desire;
@Repository
public class TestDao {
@Autowired
private JdbcTemplate jdbcTemplate;
public List<HappyParty> querySql() {
	String sql = "select * from t_data_activity t where 1=1";
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(HappyParty.class));
}
public int updateSql(HappyParty list) {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	String sql = "update t_data_activity set img_url = :img_url where activity_id = :activity_id";
	SqlParameterSource paramSource = new BeanPropertySqlParameterSource(list);
	return namedParameterJdbcTemplate.update(sql, paramSource);
}
	

public List<PartyLectureInfo> querySql1() {
	String sql = "select * from t_data_learn t where 1=1";
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PartyLectureInfo.class));
}
public int updateSql1(PartyLectureInfo list) {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	String sql = "update t_data_learn set learning_data_url = :learning_data_url , learning_pic_url = :learning_pic_url where learning_data_id = :learning_data_id";
	SqlParameterSource paramSource = new BeanPropertySqlParameterSource(list);
	return namedParameterJdbcTemplate.update(sql, paramSource);
}


public List<RealTimeMessage>  querySql2() {
	String sql = "select * from t_data_realtime t where 1=1";
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RealTimeMessage.class));
}
public int updateSql2(RealTimeMessage list) {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	String sql = "update t_data_realtime set img_url1 = :img_url1 , img_url2 = :img_url2 , img_url3 = :img_url3  where realtimeinfo_id = :realtimeinfo_id";
	SqlParameterSource paramSource = new BeanPropertySqlParameterSource(list);
	return namedParameterJdbcTemplate.update(sql, paramSource);
}


public List<HappyInfoShow>  querySql3() {
	String sql = "select * from t_data_show t where 1=1";
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(HappyInfoShow.class));
}
public int updateSql3(HappyInfoShow list) {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	String sql = "update t_data_show set img_one=:img_one,img_two=:img_two,img_three=:img_three,img_four=:img_four,img_five=:img_five,img_six=:img_six,img_seven=:img_seven,img_eight=:img_eight,img_nine=:img_nine where show_id = :show_id";
	SqlParameterSource paramSource = new BeanPropertySqlParameterSource(list);
	return namedParameterJdbcTemplate.update(sql, paramSource);
}


public List<SysLogin> querySql4() {
	String sql = "select * from t_sys_user t where 1=1";
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SysLogin.class));
}
public int updateSql4(SysLogin list) {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	String sql = "update t_sys_user set url = :url where user_id = :user_id";
	SqlParameterSource paramSource = new BeanPropertySqlParameterSource(list);
	return namedParameterJdbcTemplate.update(sql, paramSource);
}


public List<Business>  querySql5() {
	String sql = "select * from t_user_sale t where 1=1";
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Business.class));
}
public int updateSql5(Business list) {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	String sql = "update t_user_sale set pic_url1 = :pic_url1 where biz_id = :biz_id";
	SqlParameterSource paramSource = new BeanPropertySqlParameterSource(list);
	return namedParameterJdbcTemplate.update(sql, paramSource);
}


public List<Desire>  querySql6() {
	String sql = "select * from t_user_want t where 1=1";
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Desire.class));
}
public int updateSql6(Desire list) {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	String sql = "update t_user_want set  pic_url1 = :pic_url1 where want_id = :want_id";
	SqlParameterSource paramSource = new BeanPropertySqlParameterSource(list);
	return namedParameterJdbcTemplate.update(sql, paramSource);
}

}
