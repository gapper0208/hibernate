package com.woniuxy.r_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

/*
 1. hql是: hibernate query language
 2. hql与sql十分相似，并不完全相同。
 3. hql操作的是对象和对象的属性，sql操作的是表和表中的列
 4. 对于查询而言，在某些情况下hql可以省略SELECT；sql不能省略
 5. 书写规范：sql和hql建议关键字大写，不大写也可以！
 
 6. hql的价值在于，hibernate能把hql翻译成特定数据库的sql！
*/

public class AppTest {
	
	
	private String name() {
		
		String[] xing = "赵 钱 孙 李 周 武 郑 王 诸葛 上官 欧阳 东方 刘 高 马 第五 令狐 吕 董 貂 关".split(" ");
		String[] ming = "和平 建国 建军 国庆 雅琴 桂兰 桂花 雪梅 秀琴 鹏 超 伟 斌 八戒 翠花 狗剩 狗蛋 子涵 子墨 若涵 诗意 思雨 羽 蝉".split(" ");
		
		int a = (int) (Math.random() * xing.length);
		int b = (int) (Math.random() * ming.length);
		
		return xing[a] + ming[b];
	}
	
	private Double sal() {
		return Math.random() * 8001 + 2000;
	}
	
//	@Test
//	public void testSave() throws Exception {
//		Session s = HibernateUtils.openSession();
//		s.beginTransaction();
//		// ===============================================
//		
//		Dept d = new Dept();
//		d.setDname("开发部");
//		
//		for (int i = 0; i <= 10; i++) {
//			Emp e = new Emp();
//			e.setEname(name());
//			e.setSal(sal());
//			e.setHiredate(new Date());
//			d.getEmps().add(e);
//		}
//		
//		Dept d2 = new Dept();
//		d2.setDname("鼓励师部");
//		
//		for (int i = 0; i <= 10; i++) {
//			Emp e = new Emp();
//			e.setEname(name());
//			e.setSal(sal());
//			e.setHiredate(new Date());
//			d2.getEmps().add(e);
//		}
//		
//		s.save(d);
//		s.save(d2);
//		
//		
//		
//		// ===============================================
//		s.getTransaction().commit();
//		s.close();
//		
//	}
	
	
	@Test
	public void testHql() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		// ===============================================
		
		
		// 1. 查询所有Emp
//		String hql = "FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// 2. 选择（对行进行筛选）
//		String hql = "FROM Emp WHERE eid BETWEEN 2 and 5";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		
//		String hql = "FROM Emp WHERE eid = 5 OR eid > 16";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		
//		String hql = "FROM Emp WHERE eid >= 10 and sal <= 5000";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
//		String hql = "FROM Emp WHERE NOT eid >= 10";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		
		// 3.投影（对列进行筛选）
//		String hql = "SELECT ename FROM Emp";
//		Query q = s.createQuery(hql);
//		List<String> list = q.list();
//		for (String ename : list) {
//			System.out.println(ename);
//		}
		
//		String hql = "SELECT eid FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Integer> list = q.list();
//		for (Integer eid : list) {
//			System.out.println(eid);
//		}
		
		
//		String hql = "SELECT eid,ename FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Object[]> list = q.list();
//		for (Object[] arr : list) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		
//		String hql = "SELECT new Emp(eid,ename) FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
//		String hql = "SELECT new Emp(eid,ename,sal) FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		
		// 4. 模糊查询
		// 查询名字是3个字的员工
//		String hql = "FROM Emp WHERE ename LIKE '___'";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// 查询姓孙的员工
//		String hql = "FROM Emp WHERE ename LIKE '孙%'";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// 5. 排序
//		String hql = "FROM Emp ORDER BY sal DESC";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// 6. 消除重复记录
		// 查询员工都姓啥
//		String hql = "SELECT DISTINCT SUBSTRING(ename,1,1) FROM  Emp";
//		Query q = s.createQuery(hql);
//		List<String> list = q.list();
//		for (String str : list) {
//			System.out.println(str);
//		}
		
		// 7. 分页
//		String hql = "FROM Emp";
//		Query q = s.createQuery(hql);
//		q.setFirstResult(3);
//		q.setMaxResults(3);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// 8. 聚合函数
//		String hql = "SELECT MAX(sal), MIN(sal), AVG(sal), COUNT(sal), SUM(sal) FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Object[]> list = q.list();
//		for (Object[] arr: list) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		// 9. 分组
		// 查询每个部门各多少个员工
//		String hql = "SELECT dept.did, COUNT(*) FROM Emp GROUP BY dept.did";
//		Query q = s.createQuery(hql);
//		List<Object[]> list = q.list();
//		for (Object[] arr: list) {
//			System.out.println(Arrays.toString(arr));
//		}
//		// ===============================================
//		s.getTransaction().commit();
//		s.close();
		
		// 查询出人数超过11人的部门
//		String hql = "SELECT dept.did, COUNT(*) FROM Emp "
//				+ " GROUP BY dept.did HAVING count(*) > 11";
//		Query q = s.createQuery(hql);
//		List<Object[]> list = q.list();
//		for (Object[] arr: list) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		
		// 10. 子查询
		// 查询月薪比“诸葛超”月薪还高的员工
//		String hql = "FROM Emp WHERE sal > ( SELECT sal FROM Emp WHERE ename = '诸葛超')";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		
		// 11. 连接查询： 内连接，左外连接、右外连接、 迫切内连接、迫切左外连接（没有迫切右外连接）
//		String hql = "FROM Emp e JOIN e.dept";
//		Query q = s.createQuery(hql);
//		List<Object[]> list = q.list();
//		for (Object[] arr: list) {
//			System.out.println("==================================");
//			System.out.println(Arrays.toString(arr));
//		}
		
		
//		String hql = "FROM Emp e LEFT JOIN e.dept";
//		Query q = s.createQuery(hql);
//		List<Object[]> list = q.list();
//		for (Object[] arr: list) {
//			System.out.println("==================================");
//			System.out.println(Arrays.toString(arr));
//		}
		
		// 迫切内连接，保证句子还是内连接的句子，意思是只发一次sql语句。
		// 与内连接是，迫切内连接查询出的结果是Emp对象， 内连接查询出的结果是数组。
//		String hql = "FROM Emp e JOIN FETCH e.dept";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//			System.out.println(emp.getDept());
//		}
		
		// 左外连接获取的结果是数组， 迫切左外连接获取的结果是对象。
		// hql不受延迟加载的影响。
//		String hql = "FROM Emp e LEFT JOIN FETCH e.dept";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//			System.out.println(emp.getDept());
//		}
		
		// 没有迫切右外连接。
		
		// 12. 在hql中使用占位符
//		String hql = "FROM Emp WHERE ename = ?0";
//		Query q = s.createQuery(hql);
//		q.setParameter(0, "刘建国");
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//			System.out.println(emp.getDept());
//		}
		
//		String hql = "FROM Emp WHERE ename = :zz";
//		Query q = s.createQuery(hql);
//		q.setParameter("zz", "刘建国");
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//			System.out.println(emp.getDept());
//		}
		
		
		// 13. hql中，一个要注意的点
		// 在hql中，查询一的一方时，不会自动查询出多的一方。
//		String hql = "FROM Dept";
//		Query q = s.createQuery(hql);
//		List<Dept> list = q.list();
//		for (Dept dept : list) {
//			System.out.println("===============================");
//			System.out.println(dept);
//		}
		
		
		//对比上面： 在hql中，查询多的一方时，会自动查询出一的一方。
//		String hql = "FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp e : list) {
//			System.out.println("===============================");
//			System.out.println(e);
//		}
		
		
		// 14. hql N+1问题
		// 在hql中获取1的1放时，不会自动获取多的一方
		// 知道通过1的一方，导航出多的一方时，才引起查询多方一方的sql语句的发送。
		// 这样，如果有10个部门，则一共会发11条语句！ 这样降低了读写速度！
		// 为了解决这个问题，我们需要这样做： fectch="subslect" 或者 "batch-size"
//		String hql = "FROM Dept";
//		Query q = s.createQuery(hql);
//		List<Dept> list = q.list();
//		for (Dept dept : list) {
//			System.out.println("===============================");
//			System.out.println(dept);
//			System.out.println(dept.getEmps());
//		}
		
		// 15. hql会不会从一级缓存中去数据？ 不会！！
//		Dept dept = s.get(Dept.class, 1);
//		System.out.println("=======================================");
//		String hql = "FROM Dept WHERE did = 1";
//		Query q = s.createQuery(hql);		
//		Dept d = (Dept) q.uniqueResult();
//		System.out.println(d);
		
		// 16. hql查询会不会向一级缓存中缓存数据! 会!
//		String hql = "FROM Dept WHERE did = 1";
//		Query q = s.createQuery(hql);		
//		Dept d = (Dept) q.uniqueResult();
//		System.out.println("=======================================");
//		Dept dept = s.get(Dept.class, 1);
//		System.out.println(d == dept);
		
		// 17. hql名字叫做hibernate查询语句，但不意味着它只能做查询，hql还能做修改、删除，没有增加！！！
//		String hql = "UPDATE Emp SET ename = ?0 WHERE eid = ?1";
//		Query q = s.createQuery(hql);
//		q.setParameter(0, "吕布");
//		q.setParameter(1, 15);
//		q.executeUpdate();
		
//		String hql = "DELETE FROM Emp WHERE eid = :eid";
//		Query q = s.createQuery(hql);
//		q.setParameter("eid", 24);
//		q.executeUpdate();
		
		// 18. 我们已经知道，一级缓存是可以被清空的： session.clear() close() evict()
		// 在hql中，执行了update和delete之后，一级缓存数据还在！！！（对比mybatis） 
		// 但是update会直接操作数据库，一级缓存数据没变！！
		
		String hql = "FROM Dept WHERE did = 1";
		Query q = s.createQuery(hql);		
		Dept d = (Dept) q.uniqueResult();
		System.out.println(d);
		
		hql = "UPDATE Dept SET dname = ?0 WHERE did = ?1";
		q = s.createQuery(hql);
		q.setParameter(0, "哈哈啊");
		q.setParameter(1, 1);
		q.executeUpdate();
		
		System.out.println("=======================================");
		Dept dept = s.get(Dept.class, 1);
		System.out.println(dept);
		
		
		// ===============================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	
}
