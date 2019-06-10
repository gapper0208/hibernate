hibernate��ʲô
	hibernate�ǳ־ò��ܡ�

hibernate�ܸ�ʲô
	hibernate�ܼ�crud�Ŀ��������crud�Ŀ���Ч�ʡ�
	
hibernateʲôʱ��ʹ�ã�
	�����ǿ��������������Ӧ��ʱ�����Կ���ʹ��hibernate��

==============================================================	

hibernate���ʹ�ã������һ�������𲽵����ӣ�

a. ����������
	hibernate���� 
	����������hibernate3�� �򻹱����ֶ�����javassist����������������hibernate5���Ͳ����ֶ����롣
	
	<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
	<dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-core</artifactId>
	    <version>3.6.10.Final</version>
	</dependency>
	
	mysql����
	
	<dependency>
  		<groupId>mysql</groupId>
  		<artifactId>mysql-connector-java</artifactId>
  		<version>5.1.35</version>
  	</dependency>
  	
  	junit����
  	<dependency>
  		<groupId>junit</groupId>
  		<artifactId>junit</artifactId>
  		<version>4.12</version>
  	</dependency>


b. ����һ��ģ�ͣ�User
	public class User implements Serializable {
		private Integer id;
		private String name;
		private Date birthday;
		private Double money;
		
		// getter and setter ....
	}
	
c. ����hibernate�������ļ�: User.hbm.xml
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

	

d. ����hibernate�������ļ���hibernate.cfg.xml
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE hibernate-configuration PUBLIC
		"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
		"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
	<hibernate-configuration>
		<session-factory>
			<!-- ָ�����ԣ�Ҳ����ָ��hibernateҪ�����ĸ����ݿ����ϵͳ -->
			<property name="hibernate.dialect">org.hibernate.dialect.MySQL5InnoDBDialect</property>
			<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
			<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/test</property>
			<property name="hibernate.connection.username">root</property>
			<property name="hibernate.connection.password">123</property>
			
			<!-- �����������ļ� -->
			<mapping resource="com/woniuxy/a_hello/User.hbm.xml"/>
			
		</session-factory>
	</hibernate-configuration>
	
e. ��ʼ���ԣ�
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

��ʱ�������Ѿ����ܵ�hibernate�ļ��֮���ˣ� ������ϸ��ѧϰ�����hello world���ӣ�

a. orm:  object relational mapping�� �����ϵӳ�䡣

b. ͨ��������orm��ʵ������2�㣺
	1) �� ---> ��� ӳ���ϵ
	         ���е����� ---> ���е��ֶε�ӳ���ϵ
	         ������֮��Ĺ�����ϵ--->�����֮��������ϵ��������������û�����֣��������⣩
	         
	2) ����Ҫ��дsql��䣬����ֱ�Ӳ�������
	
c. orm��һ��˼�룬ʵ�����˼��ļ�����������ֻ��hibernate��һ����ܣ����������ģ�toplink �� mybatis(����Ҳ��)


d. �ӿ���Ч���Ͻ���
	hibernate > mybatis > jdbc

         ��ִ���ٶ��Ͻ���
    jdbc > mybatis > hibernate
    
e. ��ϸ�������ӣ�
	
	