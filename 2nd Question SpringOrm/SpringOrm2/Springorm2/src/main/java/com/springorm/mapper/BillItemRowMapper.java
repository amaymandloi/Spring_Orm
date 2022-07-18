package com.springorm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springorm.entity.BillItem;

public class BillItemRowMapper implements RowMapper<BillItem>{

	public BillItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillItem billItem=new BillItem();
		billItem.setBiid(rs.getInt("biid"));
		billItem.setBillid(rs.getInt("billid"));
		billItem.setItemid(rs.getInt("itemid"));
		billItem.setQty(rs.getInt("qty"));
		billItem.setPrice(rs.getDouble("price"));
		return billItem;
	}

}
