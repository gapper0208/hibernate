package com.woniuxy.g_map;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		User user = new User();
		user.setName("郭靖");
		user.setBirthday(new Date());
		user.setMoney(999d);
		
		user.getAddresses().put("老家", "蒙古");
		user.getAddresses().put("岳父家", "桃花岛");
		user.getAddresses().put("自己家", "襄阳");
		
		s.save(user);
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testFind() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		User user = (User) s.get(User.class, 1);
		
		System.out.println(user);
		System.out.println(user.getAddresses());
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		User user = (User) s.get(User.class, 1);
		
		// 添加地址，逻辑上是修改用户
		// user.getAddresses().put("公司","丐帮");
		// 删除地址，逻辑上是修改用户		
		// user.getAddresses().remove("公司");
		
		s.update(user);
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		User user = (User) s.get(User.class, 1);
		
		s.delete(user);
		
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
}
