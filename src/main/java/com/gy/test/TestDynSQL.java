package com.gy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.gy.bean.Student;
import com.gy.mapper.StudentMapper;

import oracle.net.aso.s;

public class TestDynSQL {
	
	
	@Test
	public void testDymSQL() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student s = new Student();
		s.setClassId("AAA");
		s.setId(13);
		s.setLastName("李秀映");
		studentMapper.insertStu(s);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDymSQL2() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student s = new Student();
		s.setClassId("AAA");
		s.setId(null);
		s.setLastName("范炳杰");
		List<Student> list = studentMapper.queryByConditionIf(s);
		System.err.println(list);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDymSQLTrim() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student s = new Student();
		s.setClassId("AAA");
		s.setId(null);
		s.setLastName("范炳杰");
		List<Student> list = studentMapper.queryByConditionTrim(s);
		System.err.println(list);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDymSQLChoose() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student s = new Student();
		s.setClassId("AAA");
		s.setId(1);
		s.setLastName("李时");
		List<Student> list = studentMapper.queryByConditionChoose(s);
		System.err.println(list);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	@Test
	public void testDymSQLSet() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student s = new Student();
		s.setClassId("aaa");
		s.setId(13);
		s.setLastName("kathy");
		studentMapper.updateTestSet(s);
		
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	@Test
	public void testDymSQLforEach() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		List<String> ids = Arrays.asList("1","12","13");
		List<Student> list = studentMapper.queryByIds(ids);
		for (Student student : list) {
			System.err.println(student);
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDymSQLforEachBatchInsert() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		
		List<Student> list = new ArrayList<>();
		Student s = new Student(null, "俞嘉玲", "bbb");
		Student s1 = new Student(null, "向虹", "ccc");
		Student s2 = new Student(null, "戴子喻", "ddd");
		Student s3 = new Student(null, "林燕萍", "eee");
		list = Arrays.asList(s,s1,s2,s3);
		
		studentMapper.batchInsert(list);
		
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	@Test
	public void testBatchInsertMutilQuery() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		
		List<Student> list = new ArrayList<>();
		Student s = new Student(null, "嘉欣", "bbb");
		Student s1 = new Student(null, "陈妙凡", "ccc");
		Student s2 = new Student(null, "爱爱", "ddd");
		Student s3 = new Student(null, "怜怜", "eee");
		list = Arrays.asList(s,s1,s2,s3);
		
		studentMapper.batchInsertMutilQuery(list);
		
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	@Test
	public void test() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		
		List<Student> list = new ArrayList<>();
		Student s = new Student(null, "嘉欣", "bbb");
		Student s1 = new Student(null, "陈妙凡", "ccc");
		Student s2 = new Student(null, "爱爱", "ddd");
		Student s3 = new Student(null, "怜怜", "eee");
		list = Arrays.asList(s,s1,s2,s3);
		
		studentMapper.batchInsertMutilQuery(list);
		
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testBatchInsertWithOracle() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> list = new ArrayList<>();
		Student s = new Student(null, "嘉欣^", "bbb");
		Student s1 = new Student(null, "陈妙凡^", "ccc");
		Student s2 = new Student(null, "爱爱^", "ddd");
		Student s3 = new Student(null, "怜怜^", "eee");
		list = Arrays.asList(s,s1,s2,s3);
		studentMapper.batchInsertWithOracleTwo(list);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	
	@Test
	public void testBatchInsertWithOracleTwo() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		
		List<Student> list = new ArrayList<>();
		Student s = new Student(null, "赵风菲", "bbb");
		Student s1 = new Student(null, "黄敏娜", "ccc");
		Student s2 = new Student(null, "陈妍情", "ddd");
		Student s3 = new Student(null, "小雪", "eee");
		list = Arrays.asList(s,s1,s2,s3);
		studentMapper.batchInsertWithOracleTwo(list);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	
	@Test
	public void testgetEmployeeByInnerTest() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		Student stu = new Student();
		stu.setLastName("赵风菲");
		
		List<Student> list = studentMapper.getEmployeeByInnerTest(stu);
		for (Student student : list) {
			System.err.println(student);
		}
		
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	
	@Test
	public void testgetEmployeeByTestInner() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		List<Student> list = studentMapper.queryByLastName("赵");
		for (Student student : list) {
			System.err.println(student);
		}
		
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	
}
