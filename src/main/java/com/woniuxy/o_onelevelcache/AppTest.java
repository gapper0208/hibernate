package com.woniuxy.o_onelevelcache;

import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.junit.Test;

/*
 ��������ã�
 �����ݸ��ӽ���ʹ���ߡ�

hibernate��һ�����棺
1. hibernate��һ�����棬��Session����Ļ��档��˼�ǣ�һ�����治�ܿ�Ự��
2. s.get(User.class, 1)��������һ����������
		����Ҳ��������mysql����������sql��䣬mysql�������Ѳ�ѯ���Ľ�����ظ�hibernate��hibernate�Ͱѽ������һ��������
		����Ҽ��ˣ���ֱ�ӷ��أ������mysql����������sql��䡣
3. һ������������ڣ�
	һ�������������ϵͳ���ܣ��������󣡣�Ϊʲô����������? ��Ϊһ��������sessionͬ�������� ��session����������̫�̣�������һ��CRUD�ͽ�����
	����һ���������һЩ������Щ��һ�������еĶ���Ҳ������session�Ĺرն����٣�
	
	һ������ļ�ֵ���ڣ�����session����־û�����ģ� Ҳ����˵��ֻҪ�Ѷ��������session��һ�������У�Ҳ����"����session������"
	session����Ķ���֮�󣨰Ѷ������һ��������֮�󣩣���զ���� �������ģ�
			sessionһ������һ�����󣬾ͻ�Ѹö���һʽ���ݵػ���������һ�ݾ��ǻ��棨�ɶ���д������һ���ǡ����ա��� ���վ���һ��ֻ���Ļ��档
			֮�󣬶Գ־û�������޸ģ������������޸����ݿ⣬�������޸Ļ����еĶ��󣬿����Ǿ��Բ��ᱻ�޸ĵġ� �������������ύ��ʱ��
			session�ͻ����Ŷ���ġ����桱�͡����ա����бȽϣ������ͬ��������sql��䡣�����һ�£�������sql��䡣
	
4. ������һ�����棺
	session�ķ����� close()  clear() evict(Object obj)
*/

public class AppTest {
	
	// ֤��һ������Ĵ��ڣ��Լ�һ�����治�ܿ�Ự
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
	
	
	// ����������һ������
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
	
	// һ�������е����ݣ���ʵ�����ݿ��е����ݣ������һ�£���ô�죿
	@Test
	public void testOneLevelCache3() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		System.out.println("��һ�β�ѯ��");
		User user = s.get(User.class, 3);
		System.out.println(user);
		
		TimeUnit.SECONDS.sleep(10);
		
		System.out.println("�ڶ��β�ѯ::");
		
		// Ϊ�˱�֤�ڶ�����ȥ���ݿ��ѯ��
		// 1. ���һ�����棬��ӵر���hibernateȥ��ѯ���ݿ�
		// s.clear();
		// User user2 = s.get(User.class, 3);
		// System.out.println(user2);
		// 2.ǿ��hibernate�ƹ�һ�����棬ֱ��ȥ���ݿ��ѯ��refresh�����һ��������ȡ���ݣ����ǻ���һ�������з����ݣ�Ҳ���Ǹ���һ�����棡��
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
