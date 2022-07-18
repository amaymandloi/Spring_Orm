package com.springorm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springorm.entity.Customer;
import com.springorm.mapper.CustomerRowMapper;

public class CustomerDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Customer getCustomerFromId(int id)
    {
    	String sql="select * from customer where customerid="+id;
    	return jdbcTemplate.queryForObject(sql,new CustomerRowMapper());
    	
    }
    
}
