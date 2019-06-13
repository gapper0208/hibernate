package com.woniuxy.z_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.woniuxy.r_hql.Emp;

public class AppTest {
	
	
	private List<Emp> read(String ename) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url,"root","123");
		String sql = "select * from emp where ename = ?";
		System.out.println("sql:" + sql);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ename);
		ResultSet rs = ps.executeQuery();
		List<Emp> list = new ArrayList<>();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setSal(rs.getDouble("sal"));
			emp.setHiredate(rs.getDate("hiredate"));
			emp.setDept(null);
			list.add(emp);
		}
		return list;
	}
	
	@Test
	public void test() throws Exception {
		
		List<Emp> list = read("Áõ½¨¹ú");
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
		
		
	}
}
