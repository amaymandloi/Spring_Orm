package com.springorm.entity;

public class Subcategory {
	private int subcatid; 
	private int catid; 
	private String subcatname;
	
	
	public Subcategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSubcatid() {
		return subcatid;
	}
	public void setSubcatid(int subcatid) {
		this.subcatid = subcatid;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getSubcatname() {
		return subcatname;
	}
	public void setSubcatname(String subcatname) {
		this.subcatname = subcatname;
	}
	@Override
	public String toString() {
		return "Subcategory [subcatid=" + subcatid + ", catid=" + catid + ", subcatname=" + subcatname + "]";
	}
	public Subcategory(int subcatid, int catid, String subcatname) {
		super();
		this.subcatid = subcatid;
		this.catid = catid;
		this.subcatname = subcatname;
	}
	
	
	

}
