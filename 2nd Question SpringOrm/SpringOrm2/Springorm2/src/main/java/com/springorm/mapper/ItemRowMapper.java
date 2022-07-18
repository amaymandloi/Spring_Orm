package com.springorm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springorm.entity.Item;

public class ItemRowMapper implements RowMapper<Item> {

	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item =new Item();
		item.setItemid(rs.getInt("itemid"));
		item.setIname(rs.getString("iname"));
		item.setSubcatid(rs.getInt("subcatid"));
		item.setPrice(rs.getDouble("price"));
		item.setDom(rs.getDate("dom"));
		item.setDate_of_expiry(rs.getDate("date_of_expiry"));
		item.setInstock(rs.getBoolean("instock"));
		item.setDiscount(rs.getDouble("discount"));
		return item;
	}

}
