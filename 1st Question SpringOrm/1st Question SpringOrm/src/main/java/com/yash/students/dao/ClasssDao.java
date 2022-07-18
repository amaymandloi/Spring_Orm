package com.yash.students.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yash.students.entity.Classs;
import com.yash.students.mapper.ClassRowMapper;

public class ClasssDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addClasss(Classs classs) {
		String sqlQuery = "insert into class value(?,?,?)";
		Object[] args = { classs.getClassId(), classs.getClassName(), classs.getSection() };

		jdbcTemplate.update(sqlQuery, args);
	}

	public List<Classs> getAllClasses() {
		String classQuery = "select * from class";
		List<Classs> allClasses = jdbcTemplate.query(classQuery, new ClassRowMapper());
		return allClasses;
	}

	public List<Classs> getAllClassIds() {
		String classQuery = "select * from class";
		List<Classs> allClassIds = jdbcTemplate.query(classQuery,new ClassRowMapper());
		return allClassIds;
	}
	
	public List<Classs> getAllClassName()
	{
		String query="select * from class group by classname";
		List<Classs> classnames=jdbcTemplate.query(query,new ClassRowMapper());
		return classnames;
	}

}
