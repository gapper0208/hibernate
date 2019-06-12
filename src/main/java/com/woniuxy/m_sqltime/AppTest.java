package com.woniuxy.m_sqltime;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

/*
 sql语句执行时机：
 save：是立即生成sql语句，并发送给服务器。
 update：是在事务提交时，才生成sql语句并发送
 get：是立即生成sql语句，并发送给服务器。
 delete：是在事务提交时，才生成sql语句并发送
 
 一个概念：
 OID， 与主键映射的属性，我们称之为Object id，简称为OID
 
 规律是：
 1. 从没有OID，到有OID，就会立即执行sql语句。
 2. 从有OID，到有OID，就会在事务提交时，才执行sql语句。
 
 经典面试题：
 hibernate中的：flush、refresh、clear方法有什么区别。
 
 现在只能讲解flush方法：
 我们已经知道了sql语句的执行时间了。Session的flush方法，无论何种情况，总是会引起hibernate立即生成并发送sql语句。
*/

public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		User user = new User();
		user.setName("欧阳东东");
		user.setBirthday(new Date());
		user.setMoney(666d);
		System.out.println("save前:" + user.getId());
		s.save(user); 
		System.out.println("save后:" + user.getId());
		System.out.println("---");
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
		user.setId(1);
		System.out.println("delete前:" + user.getId());
		s.delete(user);
		// s.flush();
		System.out.println("delete后:" + user.getId());
		System.out.println("---");
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
		user.setId(1);
		user.setName("第五国际C座");
		user.setMoney(666d);
		System.out.println("update前:" + user.getId());
		s.update(user);
		System.out.println("update后:" + user.getId());
		System.out.println("---");
		// =======================================================
		s.getTransaction().commit();
		s.close();
	}
	
	@Test
	public void testFindone() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		User user = null;
		System.out.println("find前:" + user);
		user = (User) s.get(User.class, 1);
		System.out.println("find后:" + user.getId());
		System.out.println("---");
		// =======================================================
		s.getTransaction().commit();
		s.close();
	}
}
