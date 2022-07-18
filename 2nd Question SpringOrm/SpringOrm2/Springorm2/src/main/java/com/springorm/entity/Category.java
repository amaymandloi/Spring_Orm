package com.springorm.entity;

public class Category {
	private int  catid;
	private String catname;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	@Override
	public String toString() {
		return "Category [catid=" + catid + ", catname=" + catname + "]";
	}
	public Category(int catid, String catname) {
		super();
		this.catid = catid;
		this.catname = catname;
	}
	

}
