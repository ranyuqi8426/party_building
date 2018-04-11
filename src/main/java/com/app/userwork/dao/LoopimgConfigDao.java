package com.app.userwork.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.userwork.model.LoopimgConfig;


@Repository
public class LoopimgConfigDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 轮播图列表
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 */
	public List<LoopimgConfig> queryLoopimgConfigList(String source_type) {
		String sql = "select t.* from bns_loopimg_config t  where  is_delete = 'n' and source_type = ? order by t.sort_num  ";
		Object[] params = new Object[] {source_type};
		List<LoopimgConfig> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(LoopimgConfig.class));
		return list;
	}


}
