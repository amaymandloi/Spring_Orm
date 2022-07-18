package com.springorm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springorm.entity.Bill;

public class BillRowMapper implements RowMapper<Bill>{

	public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bill bill=new Bill();
		bill.setBillid(rs.getInt("billid"));
		bill.setCustomerid(rs.getInt("customerid"));
		bill.setDateofbill(rs.getDate("dateOfBill"));
		return bill;
	}

}
