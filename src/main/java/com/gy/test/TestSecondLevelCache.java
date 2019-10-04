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

/**
 * 测试二级缓存
 * @author 范
 *
 */
public class TestSecondLevelCache {

	
	@Test
	public void testSecondLevelCache() throws IOException {
		
		String resource ="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sessionFactory.openSession();
		SqlSession session2 = sessionFactory.openSession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		StudentMapper studentMapper2 = session2.getMapper(StudentMapper.class);
		Student stu1 = studentMapper.queryById("1");
		session.close();
		
		Student student = new Student(112, "李剑花", "jjj");
		studentMapper2.insertStu(student);
		
		Student stu2 = studentMapper2.queryById("1");
		
		session2.close();
		
		System.err.println(stu1 == stu2);

		
	}
	
	
}
