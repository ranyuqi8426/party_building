package com.app.party.model;

import java.util.Date;

/**
 * Created by LiNan on 2018-03-07.
 * Description: id  主题 时间 内容 地点 两张图片  状态  楼宇id 创建人 创建时间 修改人 修改时间
 */
public class PartySingle {
    private int party_single_id;// 主键
    private String party_single_title;// 主题
    private Date party_single_time;// 日期
    private String party_single_content;// 内容
    private String party_single_place;// 地点
    private String party_single_pic1;// 图片1
    private String party_single_pic2;// 图片2
    private String party_single_status;// 状态
    private String build_id;// 楼宇ID
    private String create_user_id;// 创建人
    private Date create_time;// 创建时间
    private String update_user_id;// 修改人
    private Date update_time;// 创建时间

    public int getParty_single_id() {
        return party_single_id;
    }

    public void setParty_single_id(int party_single_id) {
        this.party_single_id = party_single_id;
    }

    public String getParty_single_title() {
        return party_single_title;
    }

    public void setParty_single_title(String party_single_title) {
        this.party_single_title = party_single_title;
    }

    public Date getParty_single_time() {
        return party_single_time;
    }

    public void setParty_single_time(Date party_single_time) {
        this.party_single_time = party_single_time;
    }

    public String getParty_single_content() {
        return party_single_content;
    }

    public void setParty_single_content(String party_single_content) {
        this.party_single_content = party_single_content;
    }

    public String getParty_single_place() {
        return party_single_place;
    }

    public void setParty_single_place(String party_single_place) {
        this.party_single_place = party_single_place;
    }

    public String getParty_single_pic1() {
        return party_single_pic1;
    }

    public void setParty_single_pic1(String party_single_pic1) {
        this.party_single_pic1 = party_single_pic1;
    }

    public String getParty_single_pic2() {
        return party_single_pic2;
    }

    public void setParty_single_pic2(String party_single_pic2) {
        this.party_single_pic2 = party_single_pic2;
    }

    public String getParty_single_status() {
        return party_single_status;
    }

    public void setParty_single_status(String party_single_status) {
        this.party_single_status = party_single_status;
    }

    public String getBuild_id() {
        return build_id;
    }

    public void setBuild_id(String build_id) {
        this.build_id = build_id;
    }

    public String getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(String create_user_id) {
        this.create_user_id = create_user_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_user_id() {
        return update_user_id;
    }

    public void setUpdate_user_id(String update_user_id) {
        this.update_user_id = update_user_id;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
