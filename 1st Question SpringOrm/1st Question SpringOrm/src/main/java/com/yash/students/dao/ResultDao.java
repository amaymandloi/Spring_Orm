package com.yash.students.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yash.students.entity.Classs;
import com.yash.students.entity.Result;
import com.yash.students.mapper.ResultRowMapper;

public class ResultDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addResult(Result result) {
		String sqlQuery = "insert into result value(?,?,?,?,?,?,?)";
		Object[] args = { result.getResultId(), result.getMaths(), result.getHindi(), result.getEnglish(),
				result.getScience(), result.getSanskrit(), result.getSid(), result.getDateTime() };

		jdbcTemplate.update(sqlQuery, args);
	}

	public List<Result> getAllResult() {
		String query="select * from result";
		List<Result> result= jdbcTemplate.query(query,new ResultRowMapper());
		return result;
	}
	public List<Result> getResultAbsentInOneExam()
	{
		String query="select * from result where maths=0 or hindi=0 or english=0 or science=0 or sanskrit=0";
		List<Result> result= jdbcTemplate.query(query,new ResultRowMapper());
		return result;
	}
	public List<Result> getResultByClassId(int cid)
	{
		String query="SELECT * FROM result WHERE sid in (select sid from student where classid="+cid+")";
		List<Result> resultByClassId=jdbcTemplate.query(query, new ResultRowMapper());
		return resultByClassId;
	}
	public List<Result> getResultByClassName(String classname)
	{
		String query="SELECT * FROM result WHERE sid in (select sid from student where classid in(select classid from class where classname='"+classname+"'))";   
		List<Result> resultByClassName=jdbcTemplate.query(query, new ResultRowMapper());
		return resultByClassName;
	}
	public Double getAverageOfEachSubject(int cid,String subject)
	{
		String query="SELECT avg("+subject+") FROM result WHERE sid in (select sid from student where classid="+cid+")";
		List<Double> averageOfEachSubject=jdbcTemplate.queryForList(query, Double.class);
		return averageOfEachSubject.get(0);
	}
	public Double getAverageOfEachSubjectPerClass(String classname,String subject)
	{
		String query="SELECT avg("+subject+") FROM result WHERE sid in (select sid from student where classid in(select classid from class where classname='"+classname+"'))";   
		List<Double> averageOfEachSubject=jdbcTemplate.queryForList(query, Double.class);
		return averageOfEachSubject.get(0);
	}
	
}

