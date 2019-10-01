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

import com.gy.bean.Department;
import com.gy.bean.Employee;
import com.gy.bean.Job;
import com.gy.mapper.DepartmentMapper;
import com.gy.mapper.EmployeeMapper;
import com.gy.mapper.JobMapper;

/**
 * 接口式编程
 * 	SqlSession 和 connection 一样是非线程安全的
 *   每次使用都应该去获取新的对象
 *   Mapper 没有实现类，但是mybatis会为这个接口创建一个
 *   代理对象(将接口和Mapper绑定以后)
 *   session.getMapper(Employee.clss);
 *   
 *   
 *   
 *   配置文件：
 *   		全局配置文件
 *   			：数据源，事务管理器
 *   		SQL映射文件
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
	
	@Test
	public void test2() {
		DepartmentMapper DepartmentMapper = session.getMapper(DepartmentMapper.class);
		Department department = DepartmentMapper.queryById(2);
		System.err.println(department);
	}
	
	@Test
	public void test3() {
		JobMapper jobMapper = session.getMapper(JobMapper.class);
		Job job = jobMapper.queryById(2);
		System.err.println(job);
	}

}
