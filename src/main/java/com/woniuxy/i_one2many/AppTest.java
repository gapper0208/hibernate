package com.woniuxy.i_one2many;

import org.hibernate.Session;
import org.junit.Test;

// dept一方在维护关系，emp没有维护关系
// 因为在Dept.hbm.xml中描述出了两张表的表结构，所以算作dept维护关系！
// 所谓的维护关系，就是对外键列的值进行维护。
public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		Dept d = new Dept();
		d.setDname("软件研发部");
		
		
		Emp e = new Emp();
		e.setEname("比尔盖茨");
		
		Emp e2 = new Emp();
		e2.setEname("乔布斯");
		
		
		// #################################################################################################
		
		// 让部门记住员工
//		d.getEmps().add(e);
//		d.getEmps().add(e2);
		// 此时，必须手动添加员工，如果值添加部门而不添加员工，则在增加部门之后，部门还要维护关系：给员工补上部门id，可是员工压根没有入库，无法补部门id
//			Hibernate: insert into Emp (ename, sal, hiredate) values (?, ?, ?)
//			Hibernate: insert into Emp (ename, sal, hiredate) values (?, ?, ?)
//			Hibernate: insert into Dept (dname) values (?)
//			Hibernate: update Emp set dept_id=? where eid=?
//			Hibernate: update Emp set dept_id=? where eid=?
//		s.save(e);		// e.getClass() --> Emp --> Emp.hbm.xml
//		s.save(e2);		// e2.getClass() --> Emp --> Emp.hbm.xml
//		s.save(d);		// d.getClass() --> Dept --> Dept.hbm.xml  
		
		// #################################################################################################
		
		// 让员工记住部门
//		e.setDept(d);
//		e2.setDept(d);
		
		// 此时发现sql语句如下：
//		Hibernate: insert into Emp (ename, sal, hiredate) values (?, ?, ?)
//		Hibernate: insert into Emp (ename, sal, hiredate) values (?, ?, ?)
//		Hibernate: insert into Dept (dname) values (?)
//		这样的sql语句，说明了，部门和员工都能入库，但是它们之间没有关系！！ 也就是说2个员工没有部门，dept_id为null。
//		为什么会这样呢？？ 因为现在维护关系的一方是：dept在维护关系。 因为在Dept.hbm.xml中描述出了两张表的表结构，所以算作dept维护关系！
//		想让两个表之间的数据有外键关系，必须满足2个条件:
//			1. s.save()操作哪个对象，hibernate就会读取哪个对象所属的类，所对应的*.hbm.xml， 该hbm.xml必须描述出2张表的信息。
//			2. s.save()操作的对象，还必须记住对方。
		
//		s.save(e);		// e.getClass() --> Emp --> Emp.hbm.xml
//		s.save(e2);		// e2.getClass() --> Emp --> Emp.hbm.xml
//		s.save(d);		// d.getClass() --> Dept --> Dept.hbm.xml
			
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testFind() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		// 获取部门，带出员工
//		Dept dept = s.get(Dept.class, 1);   // Dept.class --> Dept --> Dept.hbm.xml
//		System.out.println(dept);
//		System.out.println(dept.getEmps());
		
		// 获取员工，无法带出部门
		Emp e = s.get(Emp.class, 1);  // Emp.class --> Emp --> Emp.hbm.xml
		System.out.println(e);
		System.out.println(e.getDept());
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		Dept dept = s.get(Dept.class, 1);
		// 为部门追加员工
//		Emp e = new Emp();
//		e.setEname("多隆");
//		dept.getEmps().add(e);
//		
//		s.save(e);
//		s.update(dept);
		
		// 从部门中移出员工，注意员工还在，只不过部门id为null了
//		Emp e = s.get(Emp.class, 3);
//		dept.getEmps().remove(e);
//		s.update(dept);
		
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		Dept dept = s.get(Dept.class, 1);
		
		s.delete(dept);
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
}
