package com.yash.students.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.students.entity.Result;

public class ResultRowMapper implements RowMapper<Result> {

	public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
		Result result=new Result();
		result.setResultId(rs.getInt("resultid"));
		result.setMaths(rs.getDouble("maths"));
		result.setHindi(rs.getDouble("hindi"));
		result.setEnglish(rs.getDouble("english"));
		result.setScience(rs.getDouble("science"));
		result.setSanskrit(rs.getDouble("sanskrit"));
		result.setSid(rs.getInt("sid"));
		result.setDateTime(rs.getDate("dateresult"));
		return result;
	}

}
