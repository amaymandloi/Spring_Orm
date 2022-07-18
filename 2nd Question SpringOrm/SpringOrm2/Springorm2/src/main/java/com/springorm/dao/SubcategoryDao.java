package com.springorm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springorm.entity.Subcategory;
import com.springorm.mapper.SubcategoryRowMapper;

public class SubcategoryDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Subcategory> getAllSubCategory()
    {
    	String sql="select * from subcategory";
    	List<Subcategory> subCategories=jdbcTemplate.query(sql, new SubcategoryRowMapper());
    	return subCategories;
    }
    
    
}
