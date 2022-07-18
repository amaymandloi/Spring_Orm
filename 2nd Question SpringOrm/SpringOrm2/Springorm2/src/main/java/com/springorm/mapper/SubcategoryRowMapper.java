package com.springorm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springorm.entity.Subcategory;

public class SubcategoryRowMapper implements RowMapper<Subcategory>{

	public Subcategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subcategory subCategory=new Subcategory();
		subCategory.setSubcatid(rs.getInt("subcatid"));
		subCategory.setCatid(rs.getInt("catid"));
		subCategory.setSubcatname(rs.getString("subcatname"));
		return subCategory;
	}

}
