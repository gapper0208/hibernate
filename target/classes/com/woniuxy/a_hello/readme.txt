hibernate是什么
	hibernate是持久层框架。

hibernate能干什么
	hibernate能简化crud的开发，提高crud的开发效率。
	
hibernate什么时候使用？
	当我们开发并发量不大的应用时，可以考虑使用hibernate。

==============================================================	

hibernate如何使用，这就是一个快速起步的例子：

a. 导入依赖。
	hibernate依赖 
	如果导入的是hibernate3， 则还必须手动导入javassist依赖。如果导入的是hibernate5，就不用手动导入。
	
	<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
	<dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-core</artifactId>
	    <version>3.6.10.Final</version>
	</dependency>
	
	mysql依赖
	
	<dependency>
  		<groupId>mysql</groupId>
  		<artifactId>mysql-connector-java</artifactId>
  		<version>5.1.35</version>
  	</dependency>
  	
  	junit依赖
  	<dependency>
  		<groupId>junit</groupId>
  		<artifactId>junit</artifactId>
  		<version>4.12</version>
  	</dependency>


b. 创建一个模型：User
	public class User implements Serializable {
		private Integer id;
		private String name;
		private Date birthday;
		private Double money;
		
		// getter and setter ....
	}
	
c. 创建hibernate子配置文件: User.hbm.xml
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE hibernate-mapping PUBLIC 
	    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
	    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
	<hibernate-mapping package="com.woniuxy.a_hello">
		<class name="User" table="user">
			<id name="id" column="id" type="int">
				<generator class="native" />
			</id>
			<property name="name" column="name" type="string" length="20" />
			<property name="birthday" column="birthday" type="date" />
			<property name="money" column="money" type="double" />
		</class>
	</hibernate-mapping>

	

d. 创建hibernate主配置文件：hibernate.cfg.xml
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE hibernate-configuration PUBLIC
		"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
		"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
	<hibernate-configuration>
		<session-factory>
			<!-- 指定方言，也就是指定hibernate要连接哪个数据库管理系统 -->
			<property name="hibernate.dialect">org.hibernate.dialect.MySQL5InnoDBDialect</property>
			<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
			<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/test</property>
			<property name="hibernate.connection.username">root</property>
			<property name="hibernate.connection.password">123</property>
			
			<!-- 引入子配置文件 -->
			<mapping resource="com/woniuxy/a_hello/User.hbm.xml"/>
			
		</session-factory>
	</hibernate-configuration>
	
e. 开始测试：
		@Test
		public void test() throws Exception {
			
			Configuration cfg = new Configuration();
			cfg.configure("com/woniuxy/a_hello/hibernate.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			
			User user = new User();
			user.setName("hibernate user2");
			s.save(user);
			
			s.getTransaction().commit();
			s.close();
			
		}
		
		
===================================================================================================

此时，我们已经感受到hibernate的简便之处了！ 下面详细来学习下这个hello world例子：

a. orm:  object relational mapping， 对象关系映射。

b. 通俗来讲，orm其实就以下2点：
	1) 类 ---> 表的 映射关系
	         类中的属性 ---> 表中的字段的映射关系
	         类与类之间的关联关系--->表与表之间的外键关系（快速起步例子中没有体现，后续讲解）
	         
	2) 不需要编写sql语句，而是直接操作对象。
	
c. orm是一中思想，实现这个思想的技术，不仅仅只有hibernate这一个框架，还有其他的：toplink 、 mybatis(姑且也算)


d. 从开发效率上讲：
	hibernate > mybatis > jdbc

         从执行速度上讲：
    jdbc > mybatis > hibernate
    
e. 详细讲解例子：
	
	