package com.gy.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.gy.bean.Employee;
import com.gy.mapper.EmployeeMapper;

public class TestConnection {
	
	@Test
	public void test() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
	    EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
	    Employee employee = mapper.queryById(1);
	    System.err.println(employee);
	  
	    session.close();
		
	}
	
	
	@Test
	public void test2() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//和数据库的一次会话
		SqlSession session = sessionFactory.openSession();
		
		Object employee = session.selectOne("com.gy.mapper.EmployeeMapper.queryById", 2);
		System.err.println("employee : " + employee);
		
		//用完要关掉
		session.close();
	}

}
