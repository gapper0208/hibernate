package com.woniuxy.j_many2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable{
	private Integer sid;
	private String sname;
	private Set<Teacher> teachers = new HashSet<>();
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
}
