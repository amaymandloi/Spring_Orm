package com.yash.students.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.yash.students.entity.Student;
import com.yash.students.mapper.StudentRowMapper;

public class StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addStudent(Student student) {
		String sqlQuery = "insert into Student value(?,?,?,?,?,?,?,?,?,?)";
		Object[] args = { student.getStdId(), student.getStdName(), student.getFatherName(), student.getMotherName(),
				student.getClassId(), student.getAdd(), student.getPincode(), student.getAadharNumber(),
				student.getDob(), student.getDateOfAdmission() };
		
		jdbcTemplate.update(sqlQuery, args);

	}
	public Student getStudentById(int sid)
	{
		String query="select * from student where sid="+sid;
		List<Student> student=jdbcTemplate.query(query, new StudentRowMapper());
		return student.get(0);
	}
	public List<Integer> getStudentByClassId(int cid)
	{
		String classQuery = "select sid from student";
		List<Integer> allStudentIds = jdbcTemplate.queryForList(classQuery, Integer.class);
		return allStudentIds;
	}
	
	
}
