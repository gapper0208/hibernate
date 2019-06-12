package com.woniuxy.k_one2one;

import org.hibernate.Session;
import org.junit.Test;

// teacher维护关系，也即是在Teacher.hbm.xml中描述出3张表的信息
public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		Husband h = new Husband();
		h.setHname("郭靖");
		
		Wife w = new Wife();
		w.setWname("黄蓉");
		
		w.setHusband(h);
		s.save(w);
		
//		Wife w2 = new Wife();
//		w2.setWname("祝英台");
		
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
//		h.setHname("吴应熊");
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
