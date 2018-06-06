package com.bookStore.common.beans;

public class Notice {
	private Integer n_id;
	private String title;
	private String details;
	private String n_time;
	
	public Integer getN_id() {
		return n_id;
	}
	public void setN_id(Integer n_id) {
		this.n_id = n_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getN_time() {
		return n_time;
	}
	public void setN_time(String n_time) {
		this.n_time = n_time;
	}
	@Override
	public String toString() {
		return "Notice [n_id=" + n_id + ", title=" + title + ", details=" + details + ", n_time=" + n_time + "]";
	}

	
}
