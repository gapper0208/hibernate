package com.woniuxy.p_lazy;

import org.hibernate.Session;
import org.junit.Test;

/*
 经典面试题：
 hibernate中，get和load的区别
 1. get是立即加载，立即发送sql语句给数据库服务器；load是延迟加载，只有访问了对象的非OID属性时，才会发送sql语句。
 2. get返回的对象是真实类型；load返回的对象是一个代理对象，所属类型是一个代理类。
 3. get获取不到对象时，返回null；load获取不到对象时，会抛出ObjectNotFoundException
 

追问：
	如何禁用load的延迟加载功能
		禁用之后的效果是： 
			会立即发送sql语句
			也会返回真实对象
			但是在获取不到对象时，仍然会抛出ObjectNotFoundException
	1. 在Dept.hbm.xml中的class元素中，添加lazy="false"
	2. load获取到的代理对象，其实是目标类的子类。 所以禁用load延迟加载的第二种方式就是，给Dept类前面加上final关键字即可！
	
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
