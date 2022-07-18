package com.springorm.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BillDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public int getMaxItemPurchased()
    {
    	String sql="select max(c) from (select count(*) as c from bill group by customerid) as max";
    	return jdbcTemplate.queryForObject(sql,Integer.class);
    }
    
    public List<Integer> getCustomerIdBuyOftenItem(int max)
    {
    	String sql="select customerid from(select count(*) as c,customerid from bill group by customerid) as result where c="+max;
    	return jdbcTemplate.queryForList(sql, Integer.class);
    }
    
    public List<Date> getAllBillDates()
    {
    	String sql="select dateOfBill from bill group by dateOfBill";
    	return jdbcTemplate.queryForList(sql, Date.class);
    }
    
    public List<Integer> getBillIdFromDate(Date date)
    {
    	String sql="select billid from bill where dateOfBill ='"+date+"'";
    	return jdbcTemplate.queryForList(sql,Integer.class);
    }
    

}
