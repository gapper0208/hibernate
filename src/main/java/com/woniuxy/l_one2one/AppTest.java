package com.woniuxy.l_one2one;

import org.hibernate.Session;
import org.junit.Test;

public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		Husband h = new Husband();
		h.setHname("πÿ”");
		
		Wife w = new Wife();
		w.setWname("πÿ∑Ú»À");
		w.setHusband(h);
		
		s.save(w);
		

		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testFind() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		Wife w = s.get(Wife.class, 1);
		
		System.out.println(w);
		System.out.println(w.getHusband());
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// =======================================================
		
		Wife w = s.get(Wife.class, 1);
		
		s.delete(w);
		
		// =======================================================
		s.getTransaction().commit();
		s.close();
		
	}
}
