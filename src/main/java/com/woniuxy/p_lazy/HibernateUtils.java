package com.woniuxy.p_lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf = null;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("com/woniuxy/p_lazy/hibernate.cfg.xml");
		sf = cfg.buildSessionFactory(); 
	}
	
	public static Session openSession() {
		return sf.openSession();
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
