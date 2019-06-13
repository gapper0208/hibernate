package com.woniuxy.q_twolevelcache;

import org.hibernate.Session;
import org.junit.Test;

/*
 Hibernate中的二级缓存
 1. Hibernate中的二级缓存是SessionFactory级别的缓存，也就是二级缓存与SessionFactory同生共死，也就是Hibernate中的二级缓存可以跨会话
 2. Hibernate中的二级缓存默认是关闭着的，可以通过配置来打开二级缓存（对比，Hibernate中的一级缓存默认是开着的，想关都关不了）
 3. 如何开启Hibernate中的二级缓存：
 	a. 导入一个依赖:hibernate-ehcache
 	b. 在hibernate.cfg.xml配置文件中，加入以下配置
 	
 4. 讨论。经典面试题 一级缓存和二级缓存的区别
 	a. 一级缓存是Session级别的缓存，不能跨会话
 	   二级缓存是SessionFactory级别的缓存，可以跨会话。
 	b. 一级缓存对于提升系统性能帮助不大， 一级缓存只是为了管理持久化对象..........
 	   二级缓存对于提升系统性能帮助很大，为什么呢？ 因为二级缓存生命周期很长！往往与整个应用共存亡！
 	   但是二级缓存并不是用的越多就越好！ 为什么呢？
 	    	针对于经常被修改，很少被查询的对象而言，不应该使用二级缓存。
 	   		当数据库中的数据被修改时，还要额外地更新二级缓存，这样就带来了更大的开销！
 	   		针对经常被查询，很少被修改的对象而言，就可以使用二级缓存！！
*/

public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		User user = s.get(User.class, 3);
		User user2 = s.get(User.class, 3);
		User user3 = s.get(User.class, 3);
		
		System.out.println(user);
		System.out.println(user2);
		System.out.println(user3);
		
		user3.setName("^_-");
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
		System.out.println("==========================================================");
		
		
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
}
