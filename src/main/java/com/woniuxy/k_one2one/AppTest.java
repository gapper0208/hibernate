package com.woniuxy.k_one2one;

import org.hibernate.Session;
import org.junit.Test;

// teacherά����ϵ��Ҳ������Teacher.hbm.xml��������3�ű����Ϣ
public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		Husband h = new Husband();
		h.setHname("����");
		
		Wife w = new Wife();
		w.setWname("����");
		
		w.setHusband(h);
		s.save(w);
		
//		Wife w2 = new Wife();
//		w2.setWname("ףӢ̨");
		
//		w.setHusband(h);
//		w2.setHusband(h);
		
//		s.save(w);
//		s.save(w2);
		
		

		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testFind() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
//		Wife w = s.get(Wife.class, 1);  // Wife.class --> Wife --> Wife.hbm.xml
//		System.out.println(w);
//		System.out.println(w.getHusband());
		
		
		Husband h = s.get(Husband.class,2);
		System.out.println(h);
		System.out.println(h.getWife());
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
//		Wife w = s.get(Wife.class, 1);
//		Husband h = new Husband();
//		h.setHname("��Ӧ��");
//		w.setHusband(h);
//		s.update(w);
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
//		Wife w = s.get(Wife.class, 1);
//		s.delete(w);
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
}
