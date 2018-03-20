package com.app.servicestop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.servicestop.model.AskAnswer;
import com.app.servicestop.model.AskAnswerListNum;
import com.app.util.page.PageUtil;


@Repository
public class AskAnswerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 咨询问答列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 * @param ask_type;// 类型（1心理2健康3法律）
	 * @param private String answer_status;// 状态0未回答1已回答
	 */
	public List<AskAnswer> list(String ask_type,String answer_status,String user_id,int pageSize){
		String sql = "select t.* from bns_ask_answer t where t.ask_user_id=? and ask_type = ? and answer_status = ?   ";
		if (answer_status!=null&&answer_status.equals("0")) {
			sql +=" order by t.ask_content desc ";
		}else {
			sql +=" order by t.answer_content desc ";
		}
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { user_id,ask_type,answer_status};
		List<AskAnswer> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AskAnswer.class));
		return list;
	}
	/**
	 * 咨询问答列表条数查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 * @param ask_user_id;// 
	 */
	public List<AskAnswerListNum> listCountByType(String ask_type,String user_id){
		String sql = "select count(*) as num,ask_type from bns_ask_answer where ask_user_id =?  group by ask_type ";
		Object[] params = new Object[] { user_id};
		List<AskAnswerListNum> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AskAnswerListNum.class));
		return list;
	}
	/**
	 * 问题查询
	 * @author 冉玉琦
	 * @date 2018年3月19日
	 * @param ask_answer_id
	 * @return
	 */
	public AskAnswer get(int ask_answer_id) {
		String sql = "select t.* from bns_ask_answer t where t.ask_answer_id=?  ";
		Object[] params = new Object[] { ask_answer_id};
		List<AskAnswer> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AskAnswer.class));
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	
	/**
	 * 提问
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param partyApply
	 * @return
	 */
	public int add(AskAnswer askAnswer) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_ask_answer(floor_id,ask_type,ask_user_id,ask_content,answer_user_id,answer_content,answer_status,ask_time,answer_time)";
		sql += " values(:floor_id,:ask_type,:ask_user_id,:ask_content,:answer_user_id,:answer_content,:answer_status,:ask_time,:answer_time)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(askAnswer);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	
	
	


}
