package com.woniuxy.m_sqltime;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

/*
 sql���ִ��ʱ����
 save������������sql��䣬�����͸���������
 update�����������ύʱ��������sql��䲢����
 get������������sql��䣬�����͸���������
 delete�����������ύʱ��������sql��䲢����
 
 һ�����
 OID�� ������ӳ������ԣ����ǳ�֮ΪObject id�����ΪOID
 
 �����ǣ�
 1. ��û��OID������OID���ͻ�����ִ��sql��䡣
 2. ����OID������OID���ͻ��������ύʱ����ִ��sql��䡣
 
 ���������⣺
 hibernate�еģ�flush��refresh��clear������ʲô����
 
 ����ֻ�ܽ���flush������
 �����Ѿ�֪����sql����ִ��ʱ���ˡ�Session��flush���������ۺ�����������ǻ�����hibernate�������ɲ�����sql��䡣
*/

public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		User user = new User();
		user.setName("ŷ������");
		user.setBirthday(new Date());
		user.setMoney(666d);
		System.out.println("saveǰ:" + user.getId());
		s.save(user); 
		System.out.println("save��:" + user.getId());
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
		System.out.println("deleteǰ:" + user.getId());
		s.delete(user);
		// s.flush();
		System.out.println("delete��:" + user.getId());
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
		user.setName("�������C��");
		user.setMoney(666d);
		System.out.println("updateǰ:" + user.getId());
		s.update(user);
		System.out.println("update��:" + user.getId());
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
		System.out.println("findǰ:" + user);
		user = (User) s.get(User.class, 1);
		System.out.println("find��:" + user.getId());
		System.out.println("---");
		// =======================================================
		s.getTransaction().commit();
		s.close();
	}
}
