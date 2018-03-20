package com.app.party.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.party.model.PartySingle;

/**
 * Created by LiNan on 2018-03-07.
 * Description:
 */
@Repository
public class PartySingleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PartySingle> list(String build_id, String user_id, String content_type,String party_single_status) {
        String sql = "select * from bns_content   where floor_id =? and status = ? and content_type =?";
//        sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
        Object[] params = new Object[] {build_id ,party_single_status, content_type};
        List<PartySingle> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PartySingle.class));
        return list;
    }

    public PartySingle getOne(String partySinge_id, String content_type) {
        String sql = "select t.* from bns_content  where t.content_id =?";
        Object[] params = new Object[] {partySinge_id};
        List<PartySingle> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PartySingle.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public int add(PartySingle partySingle) {

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into bns_content  " +
                " (content_type,content_title,content_time,content_local,content_img,content,img1,img2,img3,img4,img5,status,floor_id,is_top,is_top_img,create_cd)";
        sql += "  values(:content_type,:content_title,:content_time,:content_local,:content_img,:content,:img1,:img2,:img3,:img4,:img5,:status,:floor_id,:is_top,:is_top_img,:create_cd)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(partySingle);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public int update(PartySingle partySingle) {
        String sql = "update bns_content  " +
                "  set party_single_title=:party_single_title,party_single_time=:party_single_time,party_single_content=:party_single_content,party_single_place=:party_single_place,party_single_pic1=:party_single_pic1,party_single_pic2=:party_single_pic2,party_single_status=:party_single_status,build_id=:build_id,update_user_id=:update_user_id,update_time=:update_time)";
        sql+= "  where content_id=:content_id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(partySingle);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public int delete(String party_single_id) {
        String sql = "delete from bns_content   where content_id=?";
        return jdbcTemplate.update(sql, party_single_id);
    }
}
