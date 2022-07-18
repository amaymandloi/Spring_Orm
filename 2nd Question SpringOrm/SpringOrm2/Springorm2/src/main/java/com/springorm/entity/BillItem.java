package com.springorm.entity;

public class BillItem {
	private int  biid;
	private int billid; 
	private int itemid;
	private int qty;
	private double price;
	
	public BillItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBiid() {
		return biid;
	}
	public void setBiid(int biid) {
		this.biid = biid;
	}
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Bill_item [biid=" + biid + ", billid=" + billid + ", itemid=" + itemid + ", qty=" + qty + ", price="
				+ price + "]";
	}
	public BillItem(int biid, int billid, int itemid, int qty, int price) {
		super();
		this.biid = biid;
		this.billid = billid;
		this.itemid = itemid;
		this.qty = qty;
		this.price = price;
	}
	
	

}
