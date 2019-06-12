package com.woniuxy.n_object3status;

import org.hibernate.Session;
import org.junit.Test;

/*
*/

public class AppTest {
	@Test
	public void test() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		User user = new User();
		user.setName("111");
		// 被session管理，也有对应的记录，处于持久化状态
		s.save(user);
		
		user.setName("222");
		user.setName("333");
		user.setName("444");
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
	}
	
	
	@Test
	public void test2() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================

		User user = s.get(User.class, 4);
		user.setName("qqq");
		user.setName("xxx");
		user.setName("yyy");
		user.setName("abc");
		
		
		// =======================================================
		s.getTransaction().commit();
		
		s.close();
		
		
	}
}
