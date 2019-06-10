package com.woniuxy.a_hello;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class AppTest {
	@Test
	public void testSave() throws Exception {
		// 创建一个Configuration类的实例，该实例是用于加载hibernate主配置文件的
		Configuration cfg = new Configuration();
		// 使用cfg对象，去加载hibernate主配置文件，因为主配置文件中也包括子配置文件，所以子配置文件的那些信息，cfg也都加载了（“知道了”）！
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// 根据cfg对象，创建出一个SessionFactory对象，SessionFactory专门用来生产Session。
		SessionFactory sf = cfg.buildSessionFactory();
		// 使用sf对象，创建一个Session对象，这里的Session对象，不同于Servlet中的Session
		// Servlet中的Session表示：从客户端浏览器访问一个网站开始，到客户端浏览器关闭了该网站的所有页面为止。
		// hibernate中的Session表示：从客户端连接到mysql服务器开始，到客户端关闭了该数据库连接为止。
		Session s = sf.openSession();
		// 开启事务
		s.beginTransaction();
		
		// 完成CRUD操作
		User user = new User();
		user.setName("hibernate user2");
		s.save(user);
		
		// 提交事务
		s.getTransaction().commit();
		// 关闭会话（底层其实是关闭Connection）
		s.close();
		
	}
	
	
	@Test
	public void testDelete() throws Exception {
		// 创建一个Configuration类的实例，该实例是用于加载hibernate主配置文件的
		Configuration cfg = new Configuration();
		// 使用cfg对象，去加载hibernate主配置文件，因为主配置文件中也包括子配置文件，所以子配置文件的那些信息，cfg也都加载了（“知道了”）！
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// 根据cfg对象，创建出一个SessionFactory对象，SessionFactory专门用来生产Session。
		SessionFactory sf = cfg.buildSessionFactory(); 
		// 使用sf对象，创建一个Session对象，这里的Session对象，不同于Servlet中的Session
		// Servlet中的Session表示：从客户端浏览器访问一个网站开始，到客户端浏览器关闭了该网站的所有页面为止。
		// hibernate中的Session表示：从客户端连接到mysql服务器开始，到客户端关闭了该数据库连接为止。
		Session s = sf.openSession();
		// 开启事务
		s.beginTransaction();
		
		User user = new User();
		user.setId(1);
		s.delete(user);
		
		// 提交事务
		s.getTransaction().commit();
		// 关闭会话（底层其实是关闭Connection）
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		// 创建一个Configuration类的实例，该实例是用于加载hibernate主配置文件的
		Configuration cfg = new Configuration();
		// 使用cfg对象，去加载hibernate主配置文件，因为主配置文件中也包括子配置文件，所以子配置文件的那些信息，cfg也都加载了（“知道了”）！
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// 根据cfg对象，创建出一个SessionFactory对象，SessionFactory专门用来生产Session。
		SessionFactory sf = cfg.buildSessionFactory();
		// 使用sf对象，创建一个Session对象，这里的Session对象，不同于Servlet中的Session
		// Servlet中的Session表示：从客户端浏览器访问一个网站开始，到客户端浏览器关闭了该网站的所有页面为止。
		// hibernate中的Session表示：从客户端连接到mysql服务器开始，到客户端关闭了该数据库连接为止。
		Session s = sf.openSession();
		// 开启事务
		s.beginTransaction();
		
		User user = new User();
		user.setId(10);
		user.setName("东方狗剩");
		user.setBirthday(new Date());
		user.setMoney(500d);
		
		s.update(user);
		
		// 提交事务
		s.getTransaction().commit();
		// 关闭会话（底层其实是关闭Connection）
		s.close();
		
	}
	
	
	@Test
	public void testFindOne() throws Exception {
		// 创建一个Configuration类的实例，该实例是用于加载hibernate主配置文件的
		Configuration cfg = new Configuration();
		// 使用cfg对象，去加载hibernate主配置文件，因为主配置文件中也包括子配置文件，所以子配置文件的那些信息，cfg也都加载了（“知道了”）！
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// 根据cfg对象，创建出一个SessionFactory对象，SessionFactory专门用来生产Session。
		SessionFactory sf = cfg.buildSessionFactory();
		// 使用sf对象，创建一个Session对象，这里的Session对象，不同于Servlet中的Session
		// Servlet中的Session表示：从客户端浏览器访问一个网站开始，到客户端浏览器关闭了该网站的所有页面为止。
		// hibernate中的Session表示：从客户端连接到mysql服务器开始，到客户端关闭了该数据库连接为止。
		Session s = sf.openSession();
		// 开启事务
		s.beginTransaction();
		
		User user = (User) s.get(User.class, 111);
		System.out.println(user);
		
		// 提交事务
		s.getTransaction().commit();
		// 关闭会话（底层其实是关闭Connection）
		s.close();
		
	}
	
	
	@Test
	public void testFindAll() throws Exception {
		// 创建一个Configuration类的实例，该实例是用于加载hibernate主配置文件的
		Configuration cfg = new Configuration();
		// 使用cfg对象，去加载hibernate主配置文件，因为主配置文件中也包括子配置文件，所以子配置文件的那些信息，cfg也都加载了（“知道了”）！
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// 根据cfg对象，创建出一个SessionFactory对象，SessionFactory专门用来生产Session。
		SessionFactory sf = cfg.buildSessionFactory();
		// 使用sf对象，创建一个Session对象，这里的Session对象，不同于Servlet中的Session
		// Servlet中的Session表示：从客户端浏览器访问一个网站开始，到客户端浏览器关闭了该网站的所有页面为止。
		// hibernate中的Session表示：从客户端连接到mysql服务器开始，到客户端关闭了该数据库连接为止。
		Session s = sf.openSession();
		// 开启事务
		s.beginTransaction();
		
		String hql = "FROM User";
		Query q = s.createQuery(hql);
		List<User> list = q.list();
		for (User user : list) {
			System.out.println(user);
		}
		
		// 提交事务
		s.getTransaction().commit();
		// 关闭会话（底层其实是关闭Connection）
		s.close();
		
	}
}
