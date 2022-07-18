package com.springorm.entity;

import java.sql.Date;

public class Item {

	private int itemid;
	private String iname;
	private int subcatid;
	private double price;
	private Date dom;
	private Date date_of_expiry;
	private boolean instock;
	private double discount;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getSubcatid() {
		return subcatid;
	}
	public void setSubcatid(int subcatid) {
		this.subcatid = subcatid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDom() {
		return dom;
	}
	public void setDom(Date dom) {
		this.dom = dom;
	}
	public Date getDate_of_expiry() {
		return date_of_expiry;
	}
	public void setDate_of_expiry(Date date_of_expiry) {
		this.date_of_expiry = date_of_expiry;
	}
	public boolean isInstock() {
		return instock;
	}
	public void setInstock(boolean instock) {
		this.instock = instock;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", iname=" + iname + ", subcatid=" + subcatid + ", price=" + price + ", dom="
				+ dom + ", date_of_expiry=" + date_of_expiry + ", instock=" + instock + ", discount=" + discount + "]";
	}
	

}
