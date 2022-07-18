package com.springorm.entity;

import java.sql.Date;

public class Customer {
	private int customerid;
	private String customername;
	private String email;
	private Date dateofbirth;
	private String add1;
	private String pincode;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", email=" + email
				+ ", dateofbirth=" + dateofbirth + ", add1=" + add1 + ", pincode=" + pincode + "]";
	}
	public Customer(int customerid, String customername, String email, Date dateofbirth, String add1,
			String pincode) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.email = email;
		this.dateofbirth = dateofbirth;
		this.add1 = add1;
		this.pincode = pincode;
	}

	
	
}
