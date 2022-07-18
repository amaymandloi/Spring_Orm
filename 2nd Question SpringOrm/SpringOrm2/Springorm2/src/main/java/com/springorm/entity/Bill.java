package com.springorm.entity;

import java.sql.Date;

public class Bill {

	private int  billid ;
	private int customerid;
	private Date dateofbill;
	
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public Date getDateofbill() {
		return dateofbill;
	}
	public void setDateofbill(Date dateofbill) {
		this.dateofbill = dateofbill;
	}
	@Override
	public String toString() {
		return "Bill [billid=" + billid + ", customerid=" + customerid + ", dateofbill=" + dateofbill + "]";
	}
	public Bill(int billid, int customerid, Date dateofbill) {
		super();
		this.billid = billid;
		this.customerid = customerid;
		this.dateofbill = dateofbill;
	}
	
	
	
}
