package com.woniuxy.o_onelevelcache;

import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.junit.Test;

/*
 缓存的作用：
 让数据更接近于使用者。

hibernate的一级缓存：
1. hibernate的一级缓存，是Session级别的缓存。意思是，一级缓存不能跨会话。
2. s.get(User.class, 1)，会现在一级缓存中找
		如果找不见，则给mysql服务器发送sql语句，mysql服务器把查询到的结果返回给hibernate，hibernate就把结果存入一级缓存中
		如果找见了，就直接返回，不会给mysql服务器发送sql语句。
3. 一级缓存意义何在？
	一级缓存对于提升系统性能，帮助不大！！为什么帮助不大呢? 因为一级缓存与session同生共死！ 而session的生命周期太短，往往是一次CRUD就结束！
	就算一级缓存存了一些对象，这些在一级缓存中的对象也会随着session的关闭而销毁！
	
	一级缓存的价值在于：是让session管理持久化对象的！ 也就是说，只要把对象存入了session的一级缓存中，也就是"对象被session管理了"
	session管理的对象之后（把对象放在一级缓存中之后），能咋？？ 是这样的：
			session一旦管理一个对象，就会把该对象，一式两份地缓存起来，一份就是缓存（可读可写），另一份是“快照”， 快照就是一个只读的缓存。
			之后，对持久化对象的修改，并不会立即修改数据库，而是先修改缓存中的对象，快照是绝对不会被修改的。 这样，当事务提交的时候，
			session就会拿着对象的“缓存”和“快照”进行比较，如果相同，则不生成sql语句。如果不一致，则生成sql语句。
	
4. 如何清空一级缓存：
	session的方法： close()  clear() evict(Object obj)
*/

public class AppTest {
	
	// 证明一级缓存的存在，以及一级缓存不能跨会话
	@Test
	public void testOneLevelCache() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		User user = s.get(User.class, 3);
		User user2 = s.get(User.class, 3);
		User user3 = s.get(User.class, 3);
		
		System.out.println(user);
		System.out.println(user2);
		System.out.println(user3);
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
		
		System.out.println("===========================================================");
		
		
		Session s2 = HibernateUtils.openSession();
		s2.beginTransaction();
		// =======================================================
		
		User user4 = s2.get(User.class, 3);
		User user5 = s2.get(User.class, 3);
		User user6 = s2.get(User.class, 3);
		
		System.out.println(user4);
		System.out.println(user5);
		System.out.println(user6);
		
		// =======================================================
		s2.getTransaction().commit();
		s2.close();
	}
	
	
	// 测试如何清空一级缓存
	@Test
	public void testOneLevelCache2() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		User user = s.get(User.class, 3);
		User user2 = s.get(User.class, 3);
		
		User user3 = s.get(User.class, 4);
		User user4 = s.get(User.class, 4);

		System.out.println("===========================================");
		s.evict(user2);
		User user5 = s.get(User.class, 3);
		System.out.println("###");
		User user6 = s.get(User.class, 4);
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	// 一级缓存中的数据，和实际数据库中的数据，如果不一致，怎么办？
	@Test
	public void testOneLevelCache3() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		System.out.println("第一次查询：");
		User user = s.get(User.class, 3);
		System.out.println(user);
		
		TimeUnit.SECONDS.sleep(10);
		
		System.out.println("第二次查询::");
		
		// 为了保证第二次能去数据库查询：
		// 1. 清空一级缓存，间接地逼迫hibernate去查询数据库
		// s.clear();
		// User user2 = s.get(User.class, 3);
		// System.out.println(user2);
		// 2.强制hibernate绕过一级缓存，直接去数据库查询（refresh不会从一级缓存中取数据，但是会向一级缓存中放数据，也就是更新一级缓存！）
		s.refresh(user);
		System.out.println(user);
		
		System.out.println("========================================");
		User user2 = s.get(User.class, 3);
		System.out.println(user2);
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
}
