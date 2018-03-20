package com.app.servicestop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.servicestop.model.Discount;
import com.app.servicestop.model.UserDiscount;
import com.app.util.page.PageUtil;


@Repository
public class DiscountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 优惠列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 */
	public List<Discount> list(String floor_id,int pageSize){
		String sql = "select t.* from bns_merchant_discount t where t.floor_id=? and unix_timestamp(discount_endtime) > unix_timestamp(NOW())    ";
			sql +=" order by t.sort_num  ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { floor_id};
		List<Discount> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Discount.class));
		return list;
	}
	
	/**
	 * 优惠劵查询
	 * @author 冉玉琦
	 * @date 2018年3月19日
	 * @param ask_answer_id
	 * @return
	 */
	public Discount get(int merchant_discount_id) {
		String sql = "select t.*,(select count(*)  from bns_user_discount a where a.discount_id = t.merchant_discount_id) as num  from bns_merchant_discount t where t.merchant_discount_id=?  ";
		Object[] params = new Object[] { merchant_discount_id};
		List<Discount> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Discount.class));
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 优惠领取列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 */
	public List<UserDiscount> listUser(int discount_id){
		String sql = "select t.* from bns_user_discount t where t.discount_id=?  ";
		Object[] params = new Object[] { discount_id};
		return  jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(UserDiscount.class));
	}
	
	/**
	 * 领取优惠
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param partyApply
	 * @return
	 */
	public int add(UserDiscount userDiscount) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_user_discount(user_id,discount_id,operation_no,operation_user_cd,operation_status,create_cd)";
		sql += " values(:user_id,:discount_id,:operation_no,:operation_user_cd,:operation_status,:user_id)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userDiscount);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	
	
	


}
