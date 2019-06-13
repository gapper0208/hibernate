package com.woniuxy.r_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

/*
 1. hql��: hibernate query language
 2. hql��sqlʮ�����ƣ�������ȫ��ͬ��
 3. hql�������Ƕ���Ͷ�������ԣ�sql�������Ǳ�ͱ��е���
 4. ���ڲ�ѯ���ԣ���ĳЩ�����hql����ʡ��SELECT��sql����ʡ��
 5. ��д�淶��sql��hql����ؼ��ִ�д������дҲ���ԣ�
 
 6. hql�ļ�ֵ���ڣ�hibernate�ܰ�hql������ض����ݿ��sql��
*/

public class AppTest {
	
	
	private String name() {
		
		String[] xing = "�� Ǯ �� �� �� �� ֣ �� ��� �Ϲ� ŷ�� ���� �� �� �� ���� ��� �� �� �� ��".split(" ");
		String[] ming = "��ƽ ���� ���� ���� ���� ���� �� ѩ÷ ���� �� �� ΰ �� �˽� �仨 ��ʣ ���� �Ӻ� ��ī ���� ʫ�� ˼�� �� ��".split(" ");
		
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
//		d.setDname("������");
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
//		d2.setDname("����ʦ��");
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
		
		
		// 1. ��ѯ����Emp
//		String hql = "FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// 2. ѡ�񣨶��н���ɸѡ��
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
		
		
		// 3.ͶӰ�����н���ɸѡ��
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
		
		
		// 4. ģ����ѯ
		// ��ѯ������3���ֵ�Ա��
//		String hql = "FROM Emp WHERE ename LIKE '___'";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// ��ѯ�����Ա��
//		String hql = "FROM Emp WHERE ename LIKE '��%'";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// 5. ����
//		String hql = "FROM Emp ORDER BY sal DESC";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// 6. �����ظ���¼
		// ��ѯԱ������ɶ
//		String hql = "SELECT DISTINCT SUBSTRING(ename,1,1) FROM  Emp";
//		Query q = s.createQuery(hql);
//		List<String> list = q.list();
//		for (String str : list) {
//			System.out.println(str);
//		}
		
		// 7. ��ҳ
//		String hql = "FROM Emp";
//		Query q = s.createQuery(hql);
//		q.setFirstResult(3);
//		q.setMaxResults(3);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		// 8. �ۺϺ���
//		String hql = "SELECT MAX(sal), MIN(sal), AVG(sal), COUNT(sal), SUM(sal) FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Object[]> list = q.list();
//		for (Object[] arr: list) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		// 9. ����
		// ��ѯÿ�����Ÿ����ٸ�Ա��
//		String hql = "SELECT dept.did, COUNT(*) FROM Emp GROUP BY dept.did";
//		Query q = s.createQuery(hql);
//		List<Object[]> list = q.list();
//		for (Object[] arr: list) {
//			System.out.println(Arrays.toString(arr));
//		}
//		// ===============================================
//		s.getTransaction().commit();
//		s.close();
		
		// ��ѯ����������11�˵Ĳ���
//		String hql = "SELECT dept.did, COUNT(*) FROM Emp "
//				+ " GROUP BY dept.did HAVING count(*) > 11";
//		Query q = s.createQuery(hql);
//		List<Object[]> list = q.list();
//		for (Object[] arr: list) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		
		// 10. �Ӳ�ѯ
		// ��ѯ��н�ȡ���𳬡���н���ߵ�Ա��
//		String hql = "FROM Emp WHERE sal > ( SELECT sal FROM Emp WHERE ename = '���')";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		
		
		// 11. ���Ӳ�ѯ�� �����ӣ��������ӡ��������ӡ� ���������ӡ������������ӣ�û�������������ӣ�
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
		
		// ���������ӣ���֤���ӻ��������ӵľ��ӣ���˼��ֻ��һ��sql��䡣
		// ���������ǣ����������Ӳ�ѯ���Ľ����Emp���� �����Ӳ�ѯ���Ľ�������顣
//		String hql = "FROM Emp e JOIN FETCH e.dept";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//			System.out.println(emp.getDept());
//		}
		
		// �������ӻ�ȡ�Ľ�������飬 �����������ӻ�ȡ�Ľ���Ƕ���
		// hql�����ӳټ��ص�Ӱ�졣
//		String hql = "FROM Emp e LEFT JOIN FETCH e.dept";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//			System.out.println(emp.getDept());
//		}
		
		// û�������������ӡ�
		
		// 12. ��hql��ʹ��ռλ��
//		String hql = "FROM Emp WHERE ename = ?0";
//		Query q = s.createQuery(hql);
//		q.setParameter(0, "������");
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//			System.out.println(emp.getDept());
//		}
		
//		String hql = "FROM Emp WHERE ename = :zz";
//		Query q = s.createQuery(hql);
//		q.setParameter("zz", "������");
//		List<Emp> list = q.list();
//		for (Emp emp : list) {
//			System.out.println(emp);
//			System.out.println(emp.getDept());
//		}
		
		
		// 13. hql�У�һ��Ҫע��ĵ�
		// ��hql�У���ѯһ��һ��ʱ�������Զ���ѯ�����һ����
//		String hql = "FROM Dept";
//		Query q = s.createQuery(hql);
//		List<Dept> list = q.list();
//		for (Dept dept : list) {
//			System.out.println("===============================");
//			System.out.println(dept);
//		}
		
		
		//�Ա����棺 ��hql�У���ѯ���һ��ʱ�����Զ���ѯ��һ��һ����
//		String hql = "FROM Emp";
//		Query q = s.createQuery(hql);
//		List<Emp> list = q.list();
//		for (Emp e : list) {
//			System.out.println("===============================");
//			System.out.println(e);
//		}
		
		
		// 14. hql N+1����
		// ��hql�л�ȡ1��1��ʱ�������Զ���ȡ���һ��
		// ֪��ͨ��1��һ�������������һ��ʱ���������ѯ�෽һ����sql���ķ��͡�
		// �����������10�����ţ���һ���ᷢ11����䣡 ���������˶�д�ٶȣ�
		// Ϊ�˽��������⣬������Ҫ�������� fectch="subslect" ���� "batch-size"
//		String hql = "FROM Dept";
//		Query q = s.createQuery(hql);
//		List<Dept> list = q.list();
//		for (Dept dept : list) {
//			System.out.println("===============================");
//			System.out.println(dept);
//			System.out.println(dept.getEmps());
//		}
		
		// 15. hql�᲻���һ��������ȥ���ݣ� ���ᣡ��
//		Dept dept = s.get(Dept.class, 1);
//		System.out.println("=======================================");
//		String hql = "FROM Dept WHERE did = 1";
//		Query q = s.createQuery(hql);		
//		Dept d = (Dept) q.uniqueResult();
//		System.out.println(d);
		
		// 16. hql��ѯ�᲻����һ�������л�������! ��!
//		String hql = "FROM Dept WHERE did = 1";
//		Query q = s.createQuery(hql);		
//		Dept d = (Dept) q.uniqueResult();
//		System.out.println("=======================================");
//		Dept dept = s.get(Dept.class, 1);
//		System.out.println(d == dept);
		
		// 17. hql���ֽ���hibernate��ѯ��䣬������ζ����ֻ������ѯ��hql�������޸ġ�ɾ����û�����ӣ�����
//		String hql = "UPDATE Emp SET ename = ?0 WHERE eid = ?1";
//		Query q = s.createQuery(hql);
//		q.setParameter(0, "����");
//		q.setParameter(1, 15);
//		q.executeUpdate();
		
//		String hql = "DELETE FROM Emp WHERE eid = :eid";
//		Query q = s.createQuery(hql);
//		q.setParameter("eid", 24);
//		q.executeUpdate();
		
		// 18. �����Ѿ�֪����һ�������ǿ��Ա���յģ� session.clear() close() evict()
		// ��hql�У�ִ����update��delete֮��һ���������ݻ��ڣ��������Ա�mybatis�� 
		// ����update��ֱ�Ӳ������ݿ⣬һ����������û�䣡��
		
		String hql = "FROM Dept WHERE did = 1";
		Query q = s.createQuery(hql);		
		Dept d = (Dept) q.uniqueResult();
		System.out.println(d);
		
		hql = "UPDATE Dept SET dname = ?0 WHERE did = ?1";
		q = s.createQuery(hql);
		q.setParameter(0, "������");
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
