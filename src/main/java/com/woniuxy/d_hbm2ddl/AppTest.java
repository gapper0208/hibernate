package com.woniuxy.d_hbm2ddl;

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
		User user = new User();
		user.setName("����");
		user.setBirthday(new Date());
		user.setMoney(666d);
		
		s.save(user); 
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
		System.out.println("Please Enter to continue:");
		System.in.read();
		System.out.println("�رչ���");
		
		HibernateUtils.getSessionFactory().close();
		
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
