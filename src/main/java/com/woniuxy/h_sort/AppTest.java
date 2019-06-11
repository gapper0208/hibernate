package com.woniuxy.h_sort;

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
		user.setName("���˷�");
		user.setBirthday(new Date());
		user.setMoney(999d);
		
		user.getAddresses().add("bb����");
		user.getAddresses().add("zz����");
		user.getAddresses().add("aa�Ϻ�");
		user.getAddresses().add("hh����");
		user.getAddresses().add("cc����");
		
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
		System.out.println(user.getAddresses().getClass());
		
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
		
		// ��ӵ�ַ���߼������޸��û�
		// user.getAddresses().add("����");
		// ɾ����ַ���߼������޸��û�		
		user.getAddresses().remove("����");
		
		s.update(user);
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	public void test() throws Exception {
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
