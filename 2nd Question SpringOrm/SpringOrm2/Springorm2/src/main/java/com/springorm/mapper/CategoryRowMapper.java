package com.springorm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springorm.entity.Category;

public class CategoryRowMapper implements RowMapper<Category>{

	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category=new Category(rs.getInt("catid"), rs.getString("catname"));
		return category;
	}

}
