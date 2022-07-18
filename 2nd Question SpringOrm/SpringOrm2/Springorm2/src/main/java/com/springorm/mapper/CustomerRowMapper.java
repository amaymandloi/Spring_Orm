package com.springorm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springorm.entity.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer=new Customer();
		customer.setCustomerid(rs.getInt("customerid"));
		customer.setCustomername(rs.getString("customername"));
		customer.setEmail(rs.getString("email"));
		customer.setDateofbirth(rs.getDate("dateOfBirth"));
		customer.setAdd1(rs.getString("add1"));
		customer.setPincode(rs.getString("pincode"));
		return customer;
	}

}
