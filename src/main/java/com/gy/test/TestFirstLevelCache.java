package com.gy.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.gy.bean.Student;
import com.gy.mapper.StudentMapper;

public class TestFirstLevelCache {

	/**
	 *两级缓存
		一级缓存:（本地缓存）sqlsession 级别的缓存。以及缓存是一直开启的
		与数据库同一次会话期间查询到的数据会放到本地缓存中
 		以后如果需要获取相同的数据，直接从缓存中拿，没必要去查询数据库
		两次查询之间清空了缓存
		一级缓存失效的情况（没有使用到当前一级缓存的情况，效果是，还需要再向数据库发出查询）
		1、sqlSession 不同
		2、sqlSession 相同，查询条件不同(当前一级缓存中还没有这个数据)
		3、sqlSession 相同,两次查询之间执行了增删改可能对当前数据有影响
	 * 
	 * 
	 * 
	 * 
	 * sqlSession 的一级缓存实际上就是一个sqlSession级别的map
	 */
	
	
	
	/**
	 * 一级缓存失效的四种情况
	 * 两次查询之间执行了增删改
	 */
	@Test
	public void testFirstLevelCache() throws IOException {
		String resource ="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sessionFactory.openSession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student stu1 = studentMapper.queryById("1");
		
		Student student = new Student(23, "wll", "hhh");
		studentMapper.insertStu(student);
		
		Student stu2 = studentMapper.queryById("1");
		
		
		System.err.println(stu1 == stu2);
		
		session.commit();
	}
	
	/**
	 * sqlsession 相同，查询条件不同
	 * @throws IOException
	 */
	@Test
	public void testFirstLevelCache2() throws IOException {
		String resource ="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sessionFactory.openSession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student stu1 = studentMapper.queryById("1");

		Student stu2 = studentMapper.queryById("3");
		
		System.err.println(stu1 == stu2);
		
		session.commit();
	}
	
	/**
	 * sqlSession不同
	 * @throws IOException
	 */
	@Test
	public void testFirstLevelCache3() throws IOException {
		String resource ="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sessionFactory.openSession();
		SqlSession session2 = sessionFactory.openSession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student stu1 = studentMapper.queryById("1");
		
		StudentMapper studentMapper2 = session2.getMapper(StudentMapper.class);
		Student stu2 = studentMapper2.queryById("1");
		
		
		System.err.println(stu1 == stu2);
		
		session.commit();
	}
	
	
	/**
	 * 两次查询之间清空了缓存
	 * @throws IOException
	 */
	@Test
	public void testFirstLevelCache4() throws IOException {
		String resource ="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sessionFactory.openSession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student stu1 = studentMapper.queryById("1");
		
		session.clearCache();  //清空缓存

		Student stu2 = studentMapper.queryById("1");
		
		
		System.err.println(stu1 == stu2);
		
		session.commit();
	}
	
	
	@Test
	public void testFirstLevelCache5() throws IOException {
		String resource ="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student stu1 = studentMapper.queryById("1");
		Student stu2 = studentMapper.queryById("1");
		System.err.println(stu1 == stu2);
		
		session.commit();
	}
	
	
}
