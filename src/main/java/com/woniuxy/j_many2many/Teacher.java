package com.woniuxy.j_many2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements Serializable{
	private Integer tid;
	private String tname;
	private Set<Student> students = new HashSet<>();
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + "]";
	}
}
