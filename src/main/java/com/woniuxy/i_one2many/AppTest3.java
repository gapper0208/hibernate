package com.woniuxy.i_one2many;

import org.hibernate.Session;
import org.junit.Test;

// dept��emp��ά������
public class AppTest3 {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		Dept d = new Dept();
		d.setDname("������");
		
		
		Emp e = new Emp();
		e.setEname("����");
		
		Emp e2 = new Emp();
		e2.setEname("����");
		
		
		// #################################################################################################
		
		// �ò��ż�סԱ��
		d.getEmps().add(e);
		d.getEmps().add(e2);
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Dept (dname) values (?)
//		Hibernate: update Emp set dept_id=? where eid=?
//		Hibernate: update Emp set dept_id=? where eid=?
//		s.save(e);		// e.getClass() --> Emp --> Emp.hbm.xml
//		s.save(e2);		// e2.getClass() --> Emp --> Emp.hbm.xml
		s.save(d);		// d.getClass() --> Dept --> Dept.hbm.xml  
		
		// #################################################################################################
		
		// ��Ա����ס����
//		e.setDept(d);
//		e2.setDept(d);
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Dept (dname) values (?)
//		Hibernate: update Emp set ename=?, sal=?, hiredate=?, dept_id=? where eid=?
//		Hibernate: update Emp set ename=?, sal=?, hiredate=?, dept_id=? where eid=?
//		s.save(e);		// e.getClass() --> Emp --> Emp.hbm.xml
//		s.save(e2);		// e2.getClass() --> Emp --> Emp.hbm.xml
//		s.save(d);		// d.getClass() --> Dept --> Dept.hbm.xml
		
		
		// #################################################################################################
		
		
		// �ò��ź�Ա�������ס�Է��� �����ж����sql��䣡�� 
//		d.getEmps().add(e);
//		d.getEmps().add(e2);
//		e.setDept(d);
//		e2.setDept(d);
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Emp (ename, sal, hiredate, dept_id) values (?, ?, ?, ?)
//		Hibernate: insert into Dept (dname) values (?)
//		Hibernate: update Emp set ename=?, sal=?, hiredate=?, dept_id=? where eid=?
//		Hibernate: update Emp set ename=?, sal=?, hiredate=?, dept_id=? where eid=?
//		Hibernate: update Emp set dept_id=? where eid=?
//		Hibernate: update Emp set dept_id=? where eid=?
//		s.save(e);		
//		s.save(e2);		
//		s.save(d);
		
			
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testFind() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		// ��ȡ���ţ�����Ա��
//		Dept dept = s.get(Dept.class, 3);   // Dept.class --> Dept --> Dept.hbm.xml
//		System.out.println(dept);
//		System.out.println(dept.getEmps());
		
		// ��ȡԱ�����޷���������
//		Emp e = s.get(Emp.class, 1);  // Emp.class --> Emp --> Emp.hbm.xml
//		System.out.println(e);
//		System.out.println(e.getDept());
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		// ��
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		// ɾ�����һ����Ĭ�ϲ���Ӱ��һ��һ����
//		Emp e = s.get(Emp.class, 2);
//		s.delete(e);
		
		Dept d = s.get(Dept.class, 5);
		s.delete(d);
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
}
