package com.gy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.gy.bean.Department;
import com.gy.bean.Employee;
import com.gy.bean.Job;
import com.gy.constant.GenderEnum;
import com.gy.mapper.DepartmentMapper;
import com.gy.mapper.EmployeeMapper;
import com.gy.mapper.JobMapper;

public class TestCrud {
	
	
	@Test
	public void testInsert() throws IOException {
		
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession(true);
		
		
		Employee employee = new Employee(null,"黑熊精",GenderEnum.MAN.getKey(),"348876xbl@162.com");
		
		
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		employeeMapper.addEmp(employee);
		System.out.println(employee);
		session.commit();
		
		session.close();
	}
	
	
	@Test
	public void testUpdate() throws IOException {
		
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession(true);
		
		
		Employee employee = new Employee();
		employee.setEmail("34887654@162.com");
		employee.setGender(GenderEnum.WEMEN.getKey());
		employee.setLastName("行者");
		employee.setId(4);		
		
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		employeeMapper.updateEmp(employee);
		
		
		session.close();
	}
	
	
	@Test
	public void testDelete() throws IOException {
		
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		
		
			
		
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		employeeMapper.deleteEmp(4);
		
		session.commit();
		session.close();
	}
	
	
	
	/**
	 * 源码分析
	 * MapperProxy.invoke
	 * 		MapperMethod.execute
	 * 			MapperMethod.convertArgsToSqlCommandParam(args)
	 * 				ParamNameResolver.getNamedParams
	 * @throws IOException
	 */
	@Test
	public void testParameter() throws IOException {
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();

		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		
		Employee employee = employeeMapper.queryByIdAndName(1, "Tom");
		System.err.println("返回值:" + employee);
		session.commit();
		session.close();
	}
	
	
	/**
	  测试#{} 的一些相关规则
	  oracle 无法区分出null值的类型
	  
	  #{ } : 更丰富的用法
	    规定参数的一些规则
	  javaType,jdbcType,mode(存储过程) ，numericScale
	  resultMap,typeHandler ,jdbcTypeName ,expression (未来准备支持的功能)
	
	  jdbcType 通常需要在特定的条件下被设置
		在我们数据为null的时候，有些数据库可以不能识别mybatis对null的默认处理，比如Oracle (报错)
		jdbcType  Other : 无效的类型，因为mybatis 对所有的null都映射的是原生Jdbc的OTHER类型，Oracle不能正确处理
		由于全局配置中，jdbcTypeForNull = OTHER ; Oracle 不支持；两种办法
		1、#{email , jdbcType=OTHER}
		2、jdbcTypeForNull = NULL
		<setting name="jdbcTypeForNull" value="NULL" /> 
	 */
	@Test
	public void testParamRule() throws IOException {
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();

		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		Department department = new Department();
		department.setDeptName("财务部");
		department.setLocation(null);
		department.setId(3);
		departmentMapper.addDept(department);
		session.commit();
		session.close();
	}

	
	/**
	 * 测试返回值
	 * @throws IOException
	 */
	@Test
	public void testRetureResultList() throws IOException {
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();

		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		List<Employee> list = employeeMapper.querAll();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		
		session.commit();
		session.close();
	}
	
	
	/**
	 * 测试返回值
	 * @throws IOException
	 */
	@Test
	public void testRetureResultMap() throws IOException {
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();

		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Map<String, Object> map = employeeMapper.queryByIdReturnMap("1");
		System.err.println(map);
		session.commit();
		session.close();
	}

	/**
	 * 测试返回值
	 * @throws IOException
	 */
	@Test
	public void testRetureResultMapMap() throws IOException {
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();

		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		
		Map<String, Employee> map = employeeMapper.queryAllToMap();
		
		System.err.println(map);
		
		session.commit();
		session.close();
	}
	
	
	/**
	 * 测试返回值
	 * @throws IOException
	 */
	@Test
	public void testRetureSettingResultMap() throws IOException {
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();

		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		
		List<Employee> list = employeeMapper.querAll();
		for (Employee employee : list) {
			System.err.println(employee.getLastName());
		}
		session.commit();
		session.close();
	}
	
	/**
	 * 测试鉴别器
	 * @throws IOException
	 */
	@Test
	public void testRetureSettingResultMapDis() throws IOException {
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();

		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		
		List<Employee> list = employeeMapper.querAllWithDis("2");
		System.out.println(list);
		session.commit();
		session.close();
	}
	
	@Test
	public void testResultMapCollection() throws IOException {
		
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();

		JobMapper jobMapper = session.getMapper(JobMapper.class);
		
		Job job = jobMapper.queryById(1);
		System.err.println(job);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testResultMapCollectionNesting() throws IOException {
		
		String configPath = "mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();

		JobMapper jobMapper = session.getMapper(JobMapper.class);
		
		Job job = jobMapper.queryByIdNesting(1);
		System.err.println(job.getJobTitle());
		
		session.commit();
		session.close();
	}


}
