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
		// ����һ��Configuration���ʵ������ʵ�������ڼ���hibernate�������ļ���
		Configuration cfg = new Configuration();
		// ʹ��cfg����ȥ����hibernate�������ļ�����Ϊ�������ļ���Ҳ�����������ļ��������������ļ�����Щ��Ϣ��cfgҲ�������ˣ���֪���ˡ�����
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// ����cfg���󣬴�����һ��SessionFactory����SessionFactoryר����������Session��
		SessionFactory sf = cfg.buildSessionFactory();
		// ʹ��sf���󣬴���һ��Session���������Session���󣬲�ͬ��Servlet�е�Session
		// Servlet�е�Session��ʾ���ӿͻ������������һ����վ��ʼ�����ͻ���������ر��˸���վ������ҳ��Ϊֹ��
		// hibernate�е�Session��ʾ���ӿͻ������ӵ�mysql��������ʼ�����ͻ��˹ر��˸����ݿ�����Ϊֹ��
		Session s = sf.openSession();
		// ��������
		s.beginTransaction();
		
		// ���CRUD����
		User user = new User();
		user.setName("hibernate user2");
		s.save(user);
		
		// �ύ����
		s.getTransaction().commit();
		// �رջỰ���ײ���ʵ�ǹر�Connection��
		s.close();
		
	}
	
	
	@Test
	public void testDelete() throws Exception {
		// ����һ��Configuration���ʵ������ʵ�������ڼ���hibernate�������ļ���
		Configuration cfg = new Configuration();
		// ʹ��cfg����ȥ����hibernate�������ļ�����Ϊ�������ļ���Ҳ�����������ļ��������������ļ�����Щ��Ϣ��cfgҲ�������ˣ���֪���ˡ�����
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// ����cfg���󣬴�����һ��SessionFactory����SessionFactoryר����������Session��
		SessionFactory sf = cfg.buildSessionFactory(); 
		// ʹ��sf���󣬴���һ��Session���������Session���󣬲�ͬ��Servlet�е�Session
		// Servlet�е�Session��ʾ���ӿͻ������������һ����վ��ʼ�����ͻ���������ر��˸���վ������ҳ��Ϊֹ��
		// hibernate�е�Session��ʾ���ӿͻ������ӵ�mysql��������ʼ�����ͻ��˹ر��˸����ݿ�����Ϊֹ��
		Session s = sf.openSession();
		// ��������
		s.beginTransaction();
		
		User user = new User();
		user.setId(1);
		s.delete(user);
		
		// �ύ����
		s.getTransaction().commit();
		// �رջỰ���ײ���ʵ�ǹر�Connection��
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		// ����һ��Configuration���ʵ������ʵ�������ڼ���hibernate�������ļ���
		Configuration cfg = new Configuration();
		// ʹ��cfg����ȥ����hibernate�������ļ�����Ϊ�������ļ���Ҳ�����������ļ��������������ļ�����Щ��Ϣ��cfgҲ�������ˣ���֪���ˡ�����
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// ����cfg���󣬴�����һ��SessionFactory����SessionFactoryר����������Session��
		SessionFactory sf = cfg.buildSessionFactory();
		// ʹ��sf���󣬴���һ��Session���������Session���󣬲�ͬ��Servlet�е�Session
		// Servlet�е�Session��ʾ���ӿͻ������������һ����վ��ʼ�����ͻ���������ر��˸���վ������ҳ��Ϊֹ��
		// hibernate�е�Session��ʾ���ӿͻ������ӵ�mysql��������ʼ�����ͻ��˹ر��˸����ݿ�����Ϊֹ��
		Session s = sf.openSession();
		// ��������
		s.beginTransaction();
		
		User user = new User();
		user.setId(10);
		user.setName("������ʣ");
		user.setBirthday(new Date());
		user.setMoney(500d);
		
		s.update(user);
		
		// �ύ����
		s.getTransaction().commit();
		// �رջỰ���ײ���ʵ�ǹر�Connection��
		s.close();
		
	}
	
	
	@Test
	public void testFindOne() throws Exception {
		// ����һ��Configuration���ʵ������ʵ�������ڼ���hibernate�������ļ���
		Configuration cfg = new Configuration();
		// ʹ��cfg����ȥ����hibernate�������ļ�����Ϊ�������ļ���Ҳ�����������ļ��������������ļ�����Щ��Ϣ��cfgҲ�������ˣ���֪���ˡ�����
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// ����cfg���󣬴�����һ��SessionFactory����SessionFactoryר����������Session��
		SessionFactory sf = cfg.buildSessionFactory();
		// ʹ��sf���󣬴���һ��Session���������Session���󣬲�ͬ��Servlet�е�Session
		// Servlet�е�Session��ʾ���ӿͻ������������һ����վ��ʼ�����ͻ���������ر��˸���վ������ҳ��Ϊֹ��
		// hibernate�е�Session��ʾ���ӿͻ������ӵ�mysql��������ʼ�����ͻ��˹ر��˸����ݿ�����Ϊֹ��
		Session s = sf.openSession();
		// ��������
		s.beginTransaction();
		
		User user = (User) s.get(User.class, 111);
		System.out.println(user);
		
		// �ύ����
		s.getTransaction().commit();
		// �رջỰ���ײ���ʵ�ǹر�Connection��
		s.close();
		
	}
	
	
	@Test
	public void testFindAll() throws Exception {
		// ����һ��Configuration���ʵ������ʵ�������ڼ���hibernate�������ļ���
		Configuration cfg = new Configuration();
		// ʹ��cfg����ȥ����hibernate�������ļ�����Ϊ�������ļ���Ҳ�����������ļ��������������ļ�����Щ��Ϣ��cfgҲ�������ˣ���֪���ˡ�����
		cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
		// ����cfg���󣬴�����һ��SessionFactory����SessionFactoryר����������Session��
		SessionFactory sf = cfg.buildSessionFactory();
		// ʹ��sf���󣬴���һ��Session���������Session���󣬲�ͬ��Servlet�е�Session
		// Servlet�е�Session��ʾ���ӿͻ������������һ����վ��ʼ�����ͻ���������ر��˸���վ������ҳ��Ϊֹ��
		// hibernate�е�Session��ʾ���ӿͻ������ӵ�mysql��������ʼ�����ͻ��˹ر��˸����ݿ�����Ϊֹ��
		Session s = sf.openSession();
		// ��������
		s.beginTransaction();
		
		String hql = "FROM User";
		Query q = s.createQuery(hql);
		List<User> list = q.list();
		for (User user : list) {
			System.out.println(user);
		}
		
		// �ύ����
		s.getTransaction().commit();
		// �رջỰ���ײ���ʵ�ǹر�Connection��
		s.close();
		
	}
}
