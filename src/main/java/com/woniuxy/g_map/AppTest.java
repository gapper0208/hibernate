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
		user.setName("����");
		user.setBirthday(new Date());
		user.setMoney(999d);
		
		user.getAddresses().put("�ϼ�", "�ɹ�");
		user.getAddresses().put("������", "�һ���");
		user.getAddresses().put("�Լ���", "����");
		
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
		
		// ���ӵ�ַ���߼������޸��û�
		// user.getAddresses().put("��˾","ؤ��");
		// ɾ����ַ���߼������޸��û�		
		// user.getAddresses().remove("��˾");
		
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