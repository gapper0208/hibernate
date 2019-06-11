package com.woniuxy.j_many2many;

import org.hibernate.Session;
import org.junit.Test;

// teacher维护关系，也即是在Teacher.hbm.xml中描述出3张表的信息
public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		Teacher t = new Teacher();
		t.setTname("洪七公");
		
		Student s1 = new Student();
		s1.setSname("郭靖");
		Student s2 = new Student();
		s2.setSname("黄蓉");
		
		// #################################################################################
		
//		t.getStudents().add(s1);
//		t.getStudents().add(s2);
		
//		Hibernate: insert into Teacher (tname) values (?)
//		Hibernate: insert into Student (sname) values (?)
//		Hibernate: insert into Student (sname) values (?)
//		Hibernate: insert into t_s (teacher_id, student_id) values (?, ?)  Teacher维护关系时，teacher_id在前面
//		Hibernate: insert into t_s (teacher_id, student_id) values (?, ?)  Teacher维护关系时，teacher_id在前面
		
//		s.save(t); // t.getClass() --> Teacher --> Teacher.hbm.xml
		
		// #################################################################################
		
//		s1.getTeachers().add(t);
//		s2.getTeachers().add(t);
//		
//		s.save(s1); // s1.getClass() --> Student --> Student.hbm.xml
//		s.save(s2); // s2.getClass() --> Student --> Student.hbm.xml
//		s.save(t);	// t.getClass() --> Teacher --> Teacher.hbm.xml
		
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
		
//		Teacher t = s.get(Teacher.class, 1);  // Teacher.class --> Teacher --> Teacher.hbm.xml
//		Student s3 = new Student();
//		s3.setSname("穆念慈");
//		t.getStudents().add(s3);
//		s.update(t);
		
		// #####################################################################
		
		
//		Teacher t = s.get(Teacher.class, 1);  
//		Student s3 = s.get(Student.class, 3);
//		t.getStudents().remove(s3);
//		s.update(t);
		
		
		
		
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
