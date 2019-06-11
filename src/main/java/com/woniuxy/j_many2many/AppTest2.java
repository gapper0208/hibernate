package com.woniuxy.j_many2many;

import org.hibernate.Session;
import org.junit.Test;

// teacher��student˫����ά����ϵ��
public class AppTest2 {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		Teacher t = new Teacher();
		t.setTname("���߹�");
		
		Student s1 = new Student();
		s1.setSname("����");
		Student s2 = new Student();
		s2.setSname("����");
		
		t.getStudents().add(s1);
		t.getStudents().add(s2);
		
		s1.getTeachers().add(t);
		s2.getTeachers().add(t);
		
		s.save(t);  // t.getClass() --> Teacher --> Teacher.hbm.xml
		
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testFind() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
//		Teacher t = s.get(Teacher.class, 1);  // Teacher.class --> Teacher --> Teacher.hbm.xml
//		System.out.println(t);
//		System.out.println(t.getStudents());
		
		// #####################################################################
		
//		Student s1 = s.get(Student.class, 2); // Student.class --> Student--> Student.hbm.xml
//		System.out.println(s1);				
//		System.out.println(s1.getTeachers());
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		// ��
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		Teacher t = s.get(Teacher.class, 1);  // Teacher.class --> Teacher --> Teacher.hbm.xml
		s.delete(t);
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
}
