package com.woniuxy.r_hql;

import org.hibernate.Session;
import org.junit.Test;

public class AppTest {
	
	
	@Test
	public void testSave() throws Exception {
		
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
}
