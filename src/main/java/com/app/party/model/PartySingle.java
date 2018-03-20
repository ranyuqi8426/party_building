package com.app.party.model;

import java.util.Date;

/**
 * Created by LiNan on 2018-03-07. Description: id 主题 时间 内容 地点 两张图片 状态 楼宇id 创建人
 * 创建时间 修改人 修改时间
 */
public class PartySingle {
	private int content_id;// 主键
	private String content_type;// 分类：1联系群众；2规范建设；3组织覆盖
	private String content_title;// 标题
	private Date content_time;// 活动时间
	private String content_local;// 地点
	private String content_img;// 封面
	private String content;// 内容
	private String img1;//
	private String img2;//
	private String img3;//
	private String img4;//
	private String img5;//
	private String status;// 审核状态:1未审核；2审核通过；3未通过
	private String floor_id;// 楼宇id
	private String is_top;// 是否置顶状态：1未置顶，2置顶
	private String is_top_img;// 如果置顶，上传一张大图
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	public String getContent_title() {
		return content_title;
	}
	public void setContent_title(String content_title) {
		this.content_title = content_title;
	}
	public Date getContent_time() {
		return content_time;
	}
	public void setContent_time(Date content_time) {
		this.content_time = content_time;
	}
	public String getContent_local() {
		return content_local;
	}
	public void setContent_local(String content_local) {
		this.content_local = content_local;
	}
	public String getContent_img() {
		return content_img;
	}
	public void setContent_img(String content_img) {
		this.content_img = content_img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public String getImg5() {
		return img5;
	}
	public void setImg5(String img5) {
		this.img5 = img5;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(String floor_id) {
		this.floor_id = floor_id;
	}
	public String getIs_top() {
		return is_top;
	}
	public void setIs_top(String is_top) {
		this.is_top = is_top;
	}
	public String getIs_top_img() {
		return is_top_img;
	}
	public void setIs_top_img(String is_top_img) {
		this.is_top_img = is_top_img;
	}
	public String getCreate_cd() {
		return create_cd;
	}
	public void setCreate_cd(String create_cd) {
		this.create_cd = create_cd;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
