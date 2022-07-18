package com.springorm.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BillItemDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public int getSellingItemById(int itemId)
    {
    	String sql="select count(itemid)+qty as qty from billitem where itemid='"+itemId+"'";
    	Integer sellingItemById=jdbcTemplate.queryForObject(sql,Integer.class);
    	if(sellingItemById==null)
    		return 0;
    	else
    	return sellingItemById;
    }
    public double getTotalSellingPerDayFromBillId(List<Integer> billIds)
    {
    	String idsInSql=String.join(",", Collections.nCopies(billIds.size(), "?"));
    	 String sql="select Sum(price) from billitem where billid in(%s)";
    	return jdbcTemplate.queryForObject(String.format(sql, idsInSql), billIds.toArray(),Double.class);
    }
    public double getAverageSellingPerDayFromBillId(List<Integer> billIds)
    {
    	String idsInSql=String.join(",", Collections.nCopies(billIds.size(), "?"));
    	 String sql="select avg(price) from billitem where billid in(%s)";
    	return jdbcTemplate.queryForObject(String.format(sql, idsInSql), billIds.toArray(),Double.class);
    }
    
}
