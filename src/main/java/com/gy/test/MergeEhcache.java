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

public class MergeEhcache {
	
	@Test
	public void test() throws IOException {
		
		String classPath = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(classPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		SqlSession session2 = sessionFactory.openSession();
		
		
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		EmployeeMapper mapper2 = session2.getMapper(EmployeeMapper.class);
		
		
		Employee emp1 = mapper.queryById(1);
		session.close();
		Employee emp2 = mapper2.queryById(1);
		
		session2.close();
		
	}

}
