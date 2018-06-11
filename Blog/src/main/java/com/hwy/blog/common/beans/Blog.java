package com.hwy.blog.common.beans;

import java.util.Date;

public class Blog {
	private Integer b_id;
	private String b_title;
	private String b_content;
	private Integer b_label;
	private Integer b_category;
	private Date    b_createDate;
	private String  b_date;
	private String  b_htmlStr;
	
	
	public Integer getB_id() {
		return b_id;
	}
	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Integer getB_label() {
		return b_label;
	}
	public void setB_label(Integer b_label) {
		this.b_label = b_label;
	}
	public Integer getB_category() {
		return b_category;
	}
	public void setB_category(Integer b_category) {
		this.b_category = b_category;
	}
	public Date getB_createDate() {
		return b_createDate;
	}
	public void setB_createDate(Date b_createDate) {
		this.b_createDate = b_createDate;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_htmlStr() {
		return b_htmlStr;
	}
	public void setB_htmlStr(String b_htmlStr) {
		this.b_htmlStr = b_htmlStr;
	}
	
	
	
}
