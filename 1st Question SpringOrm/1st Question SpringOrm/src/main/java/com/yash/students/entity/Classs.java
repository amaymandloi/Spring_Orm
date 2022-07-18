package com.yash.students.entity;

public class Classs {

	private int classId;
	private String className;
	private String section;

	public Classs() {

	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Classs [classId=" + classId + ", className=" + className + ", section=" + section + "]";
	}

}
