package com.app.userwork.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.servicestop.model.UserDiscount;
import com.app.userwork.model.MerchantDiscount;
import com.app.userwork.model.MerchantInfo;
import com.app.util.page.PageUtil;


@Repository
public class MerchantManegerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 申请商家
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @param 
	 * @return
	 */
	public int add(MerchantInfo merchantInfo) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_merchant_info (floor_id,merchant_name,merchant_content,merchant_position,merchant_img,contacts,contact_number,legal_persion,merchant_status,create_cd)";
		sql += " values(:floor_id,:merchant_name,:merchant_content,:merchant_position,:merchant_img,:contacts,:contact_number,:legal_persion,:merchant_status,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(merchantInfo);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 通过创建人Id 获取商家信息
	 * @author 冉玉琦
	 * @date 2018年4月7日
	 * @param user_id
	 * @return
	 */
	public List<MerchantInfo> getByUser_id(String user_id) {
		String sql = "select t.* from bns_merchant_info t where t.create_cd=?  ";
				
		Object[] params = new Object[] { user_id};
		List<MerchantInfo> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(MerchantInfo.class));
		return list;
	}
	/**
	 * 发布优惠活动
	 * @author 冉玉琦
	 * @date 2018年4月7日
	 * @param request
	 * @param response
	 * @param merchantInfo
	 */
	public int addDiscount(MerchantDiscount merchantDiscount) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_merchant_discount (floor_id,merchant_id,discount_name,discount_content,discount_img,discount_starttime,discount_endtime,sort_num,create_cd,discount_fraction,discount_money,discount_num,discount_state)";
		sql += " values(:floor_id,:merchant_id,:discount_name,:discount_content,:discount_img,:discount_starttime,:discount_endtime,:sort_num,:create_cd,:discount_fraction,:discount_money,:discount_num,:discount_state)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(merchantDiscount);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	/**
	 * 商家已发布活动
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @param user_id
	 * @return
	 */
	public List<MerchantDiscount> list1(int merchant_id,int pageSize) {
		String sql = "select t.* from bns_merchant_discount t where t.merchant_id=?  order by create_time desc";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { merchant_id};
		
		List<MerchantDiscount> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(MerchantDiscount.class));
		
		return list;
	}
	
	/**
	 * 商家已使用活动
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @param user_id
	 * @return
	 */
	public List<MerchantDiscount> list2(int merchant_id,int pageSize) {
		String sql = "select t.* from bns_merchant_discount t where 1=1 "
				+ " and t.merchant_id=?  "
				+ " and (select count(*)  from bns_user_discount a where a.discount_id = t.merchant_discount_id and a.operation_status = '1' )>0"
				+ " order by create_time desc";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { merchant_id};
		List<MerchantDiscount> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(MerchantDiscount.class));
		
		return list;
	}
	/**
	 * 商家活动使用情况查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param // 兑换状态 0未兑换1已兑换
	 */
	
	public  List<UserDiscount> listUse(int discount_id,int pageSize) {
		String sql = "select t.*,"
				+ "(select a.user_name from t_sys_user a where a.user_id = t.user_id) as user_name"
				+ " from bns_user_discount t where t.discount_id=?  and  operation_status = '1' ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { discount_id};
		List<UserDiscount> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(UserDiscount.class));
		return list;
	}
	
	/**
	 * 兑换优惠券
	 * @author 冉玉琦
	 * @date 2018年4月7日
	 * @param request
	 * @param response
	 * @param 	
	 * private Integer operation_user_cd;// 兑换操作人
		private String operation_status;// 兑换状态 0未兑换1已兑换
	 */
	public int addExchange(String user_id,int merchant_id, String operation_no) {
		String sql = " update bns_user_discount t set ";
				sql += " operation_user_cd = ?,";
				sql += " operation_status ='1'";
				sql += " where operation_no = ? ";
				sql += " and (select a.merchant_id from bns_merchant_discount a where a.merchant_discount_id = t.discount_id ) = ?";
				Object[] params = new Object[] { user_id,operation_no,merchant_id};
		return  jdbcTemplate.update(sql, params);
	}
	

}
