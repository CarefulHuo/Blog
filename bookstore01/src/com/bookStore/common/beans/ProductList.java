package com.bookStore.common.beans;

public class ProductList {
	private String id;
	private String name;
	private String salenum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalenum() {
		return salenum;
	}
	public void setSalenum(String salenum) {
		this.salenum = salenum;
	}
	@Override
	public String toString() {
		return "ProductList [id=" + id + ", name=" + name + ", salenum=" + salenum + "]";
	}
	
	

}
