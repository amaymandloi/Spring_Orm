package com.springorm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springorm.entity.Item;
import com.springorm.mapper.ItemRowMapper;

public class ItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Integer countItemBySubCategory(int subCategoryId) {
		String sql = "select count(*) from item where subcatid='" + subCategoryId + "'";
		int countItemBySubCategory = jdbcTemplate.queryForObject(sql, Integer.class);
		return countItemBySubCategory;

	}

	public int countItemByCategory(int categoryId) {
		String sql = "select count(*) from item where subcatid in(select subcatid from subcategory where catid="
				+ categoryId + ")";
		int countItemByCategory = jdbcTemplate.queryForObject(sql, Integer.class);
		return countItemByCategory;
	}

	public int countItemOutOfStock() {
		String sql = "select count(*) from item where instock=false";
		int itemOutOfStock = jdbcTemplate.queryForObject(sql, Integer.class);
		return itemOutOfStock;
	}

	public int countItemOutOfStockByCategory(int cid) {
		String sql = "select count(*) from item where instock=false and subcatid in(select subcatid from subcategory where catid="
				+ cid + ")";
		int itemsOutOfStockByCategory = jdbcTemplate.queryForObject(sql, Integer.class);
		return itemsOutOfStockByCategory;
	}

	public List<Item> itemOutOfStock() {
		String sql = "select * from item where instock=false";
		List<Item> itemOutOfStock = jdbcTemplate.query(sql, new ItemRowMapper());
		return itemOutOfStock;
	}

	public List<Item> itemGreaterThanAveragePrice() {
		String sql = "select * from item where price > (select avg(price) from item)";
		List<Item> itemGreaterAveragePrice = jdbcTemplate.query(sql, new ItemRowMapper());
		return itemGreaterAveragePrice;
	}

	public Item getItemHavingHighestDiscount() {
		String sql = "select * from item where discount =(select max(discount) from item)";
		Item itemHavingHighestDiscount = jdbcTemplate.queryForObject(sql, new ItemRowMapper());
		return itemHavingHighestDiscount;
	}

	public List<Item> getItemLowestSelling() {
		String sql1 = "Select * from item where itemid NOT in (select itemid from billitem)";
		String sql2="Select * from item where itemid in (Select itemId from billitem where itemid in (select itemid from item group by itemid) AND qty=(select min(qty) from billitem))";
		List<Item> itemLowestSelling1 = jdbcTemplate.query(sql1, new ItemRowMapper());
		if (itemLowestSelling1 == null) {
			List<Item> itemLowestSelling2 = jdbcTemplate.query(sql2, new ItemRowMapper());
			return itemLowestSelling2;
		} else
			return itemLowestSelling1;
	}
	public List<Item> getItems()
	{
		String sql="select * from item";
		return jdbcTemplate.query(sql,new ItemRowMapper());
	}
	

}
