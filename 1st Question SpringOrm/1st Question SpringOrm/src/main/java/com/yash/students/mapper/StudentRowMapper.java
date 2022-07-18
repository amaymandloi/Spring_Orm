package com.yash.students.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.students.entity.Student;

public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStdId(rs.getInt("sid"));
		student.setStdName(rs.getString("sname"));
		student.setFatherName(rs.getString("father_name"));
		student.setMotherName(rs.getString("mother_name"));
		student.setClassId(rs.getInt("classid"));
		student.setAdd(rs.getString("add1"));
		student.setPincode(rs.getString("pincode"));
		student.setAadharNumber(rs.getString("aadharno"));
		student.setDob(rs.getDate("dob"));
		student.setDateOfAdmission(rs.getDate("dateofadmission"));
		return student;
	}

}
