package com.woniuxy.p_lazy;

import org.hibernate.Session;
import org.junit.Test;

/*
 ���������⣺
 hibernate�У�get��load������
 1. get���������أ���������sql�������ݿ��������load���ӳټ��أ�ֻ�з����˶���ķ�OID����ʱ���Żᷢ��sql��䡣
 2. get���صĶ�������ʵ���ͣ�load���صĶ�����һ�������������������һ�������ࡣ
 3. get��ȡ��������ʱ������null��load��ȡ��������ʱ�����׳�ObjectNotFoundException
 

׷�ʣ�
	��ν���load���ӳټ��ع���
		����֮���Ч���ǣ� 
			����������sql���
			Ҳ�᷵����ʵ����
			�����ڻ�ȡ��������ʱ����Ȼ���׳�ObjectNotFoundException
	1. ��Dept.hbm.xml�е�classԪ���У����lazy="false"
	2. load��ȡ���Ĵ��������ʵ��Ŀ��������ࡣ ���Խ���load�ӳټ��صĵڶ��ַ�ʽ���ǣ���Dept��ǰ�����final�ؼ��ּ��ɣ�
	
*/



public class AppTest {
	
	
	@Test
	public void testLoad() throws Exception {
		
		
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		Dept d = s.load(Dept.class, 1);
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
}
