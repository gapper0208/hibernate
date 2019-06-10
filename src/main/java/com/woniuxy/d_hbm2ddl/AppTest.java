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
		user.setName("刘备");
		user.setBirthday(new Date());
		user.setMoney(666d);
		
		s.save(user); 
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
		System.out.println("Please Enter to continue:");
		System.in.read();
		System.out.println("关闭工厂");
		
		HibernateUtils.getSessionFactory().close();
		
	}
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		User user = new User();
		user.setId(2);
		// user.getClass() --> User.class.getSimpleName() --> User --> User.hbm.xml --> 生成sql语句。
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
		user.setName("第五国际A座");
		user.setMoney(666d);
		// user.getClass() --> User.class.getSimpleName() --> User --> User.hbm.xml --> 生成sql语句。
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
		// User.class.getSimpleName() --> User --> User.hbm.xml --> 生成sql语句。
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
