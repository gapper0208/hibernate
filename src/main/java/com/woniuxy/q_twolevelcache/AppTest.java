package com.woniuxy.q_twolevelcache;

import org.hibernate.Session;
import org.junit.Test;

/*
 Hibernate�еĶ�������
 1. Hibernate�еĶ���������SessionFactory����Ļ��棬Ҳ���Ƕ���������SessionFactoryͬ��������Ҳ����Hibernate�еĶ���������Կ�Ự
 2. Hibernate�еĶ�������Ĭ���ǹر��ŵģ�����ͨ���������򿪶������棨�Աȣ�Hibernate�е�һ������Ĭ���ǿ��ŵģ���ض��ز��ˣ�
 3. ��ο���Hibernate�еĶ������棺
 	a. ����һ������:hibernate-ehcache
 	b. ��hibernate.cfg.xml�����ļ��У�������������
 	
 4. ���ۡ����������� һ������Ͷ������������
 	a. һ��������Session����Ļ��棬���ܿ�Ự
 	   ����������SessionFactory����Ļ��棬���Կ�Ự��
 	b. һ�������������ϵͳ���ܰ������� һ������ֻ��Ϊ�˹���־û�����..........
 	   ���������������ϵͳ���ܰ����ܴ�Ϊʲô�أ� ��Ϊ���������������ںܳ�������������Ӧ�ù�������
 	   ���Ƕ������沢�����õ�Խ���Խ�ã� Ϊʲô�أ�
 	    	����ھ������޸ģ����ٱ���ѯ�Ķ�����ԣ���Ӧ��ʹ�ö������档
 	   		�����ݿ��е����ݱ��޸�ʱ����Ҫ����ظ��¶������棬�����ʹ����˸���Ŀ�����
 	   		��Ծ�������ѯ�����ٱ��޸ĵĶ�����ԣ��Ϳ���ʹ�ö������棡��
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
