package com.woniuxy.i_one2many;

import org.hibernate.Session;
import org.junit.Test;

// emp一方在维护关系，dept没有维护关系
// 因为在Emp.hbm.xml中描述出了两张表的表结构，所以算作emp维护关系！
// 所谓的维护关系，就是对外键列的值进行维护。
public class AppTest2 {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		Dept d = new Dept();
		d.setDname("开发部");
		
		
		Emp e = new Emp();
		e.setEname("刘欢");
		
		Emp e2 = new Emp();
		e2.setEname("葛优");
		
		
		// #################################################################################################
		
		// 让部门记住员工
//		d.getEmps().add(e);
//		d.getEmps().add(e2);
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Dept (dname) values (?)
//		s.save(e);		// e.getClass() --> Emp --> Emp.hbm.xml
//		s.save(e2);		// e2.getClass() --> Emp --> Emp.hbm.xml
//		s.save(d);		// d.getClass() --> Dept --> Dept.hbm.xml  
		
		// #################################################################################################
		
		// 让员工记住部门
//		e.setDept(d);
//		e2.setDept(d);
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Dept (dname) values (?)
//		Hibernate: update Emp set ename=?, sal=?, hiredate=?, dept_id=? where eid=?
//		Hibernate: update Emp set ename=?, sal=?, hiredate=?, dept_id=? where eid=?
//		s.save(e);		// e.getClass() --> Emp --> Emp.hbm.xml
//		s.save(e2);		// e2.getClass() --> Emp --> Emp.hbm.xml
//		s.save(d);		// d.getClass() --> Dept --> Dept.hbm.xml
			
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testFind() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		// 获取部门，带出员工
//		Dept dept = s.get(Dept.class, 1);   // Dept.class --> Dept --> Dept.hbm.xml
//		System.out.println(dept);
//		System.out.println(dept.getEmps());
		
		// 获取员工，无法带出部门
//		Emp e = s.get(Emp.class, 1);  // Emp.class --> Emp --> Emp.hbm.xml
//		System.out.println(e);
//		System.out.println(e.getDept());
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
//		Emp e = s.get(Emp.class, 2);
//		
//		Dept d = new Dept();
//		d.setDname("文艺部");
//		
//		e.setDept(d);
//		
//		s.save(d);
//		s.update(e);
		
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		// 删除多的一方，默认不会影响一的一方。
		Emp e = s.get(Emp.class, 2);
		s.delete(e);
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
}
