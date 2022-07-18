package com.springorm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springorm.entity.Category;
import com.springorm.mapper.CategoryRowMapper;

public class CategoryDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Category> getAllCategory(){
    	String sql="select * from category";
    	return jdbcTemplate.query(sql, new CategoryRowMapper());
    }
}
