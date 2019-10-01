package com.gy.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gy.bean.Employee;
import com.gy.mapper.EmployeeMapper;

/**
 * 接口式编程
 * @author 范
 *
 */
public class TestCon_Interfer {
	
	
	private SqlSessionFactory sessionFactory = null;
	
	private  SqlSession session = null;
	
	@Before
	public void init() throws IOException {
		String classPath = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(classPath);
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sessionFactory.openSession();
	}
	
	
	@After
	public void release() {
		session.close();
	}
	
	@Test
	public void test() {
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee employee = employeeMapper.queryById(2);
		System.err.println(employee);
	}

}
