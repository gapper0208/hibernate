package com.woniuxy.f_list;

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
		user.setName("张三丰");
		user.setBirthday(new Date());
		user.setMoney(999d);
		
		user.getAddresses().add("华山");
		user.getAddresses().add("武当山");
		user.getAddresses().add("终南山");
		
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
		//user.getAddresses().add("拉萨");
		// 删除地址，逻辑上是修改用户		
		user.getAddresses().remove("拉萨");
		
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
