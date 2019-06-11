package com.woniuxy.i_one2many;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		Dept d = new Dept();
		d.setDname("软件研发部");
		
		
		Emp e = new Emp();
		e.setEname("比尔盖茨");
		
		Emp e2 = new Emp();
		e2.setEname("乔布斯");
		
		d.getEmps().add(e);
		d.getEmps().add(e2);
		
		s.save(e);
		s.save(e2);
		s.save(d);
	
		
		
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testFind() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	public void test() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
}
