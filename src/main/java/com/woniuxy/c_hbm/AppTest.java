package com.woniuxy.c_hbm;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
//		User user = new User();
//		user.setName("����");
//		user.setBirthday(new Date());
//		user.setMoney(666d);
//		
//
//		User user2 = new User();
//		user2.setName("����");
//		user2.setBirthday(new Date());
//		user2.setMoney(666d);
//		
//		User user3 = new User();
//		user3.setName("����");
//		user3.setBirthday(new Date());
//		user3.setMoney(666d);
//		
//		User user4 = new User();
//		user4.setName("���»�");
//		user4.setBirthday(new Date());
//		user4.setMoney(666d);
//		
//		User user5 = new User();
//		user5.setName("���");
//		user5.setBirthday(new Date());
//		user5.setMoney(666d);
//		
//		s.save(user);
//		s.save(user2); 
//		s.save(user3); 
//		s.save(user4); 
//		s.save(user5); 
		
		
		Car c = new Car();
		c.setBrand("BMW");
		
		s.save(c);
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		User user = new User();
		user.setId(2);
		// user.getClass() --> User.class.getSimpleName() --> User --> User.hbm.xml --> ����sql��䡣
		s.delete(user);
		// =======================================================
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		User user = new User();
		user.setId(14);
		user.setName("�������A��");
		user.setMoney(666d);
		// user.getClass() --> User.class.getSimpleName() --> User --> User.hbm.xml --> ����sql��䡣
		s.update(user);
		// =======================================================
		s.getTransaction().commit();
		s.close();
	}
	
	@Test
	public void testFindone() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		// User.class.getSimpleName() --> User --> User.hbm.xml --> ����sql��䡣
		User user = (User) s.get(User.class, 10);
		System.out.println(user);
		// =======================================================
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testFindAll() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		String hql = "FROM User";
		Query q = s.createQuery(hql);
		List<User> list = q.list();
		for (User user : list) {
			System.out.println(user);
		}
		// =======================================================
		s.getTransaction().commit();
		s.close();
	}
}
