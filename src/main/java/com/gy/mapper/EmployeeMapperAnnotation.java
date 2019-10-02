package com.gy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gy.bean.Employee;

/**
 * 基于注解的接口
 * @author 范
 *
 */
public interface EmployeeMapperAnnotation {
	
	@Select(value = { "select * from employee where id = #{id}" })
	public Employee queryById(@Param("id") Integer id);
	

}
