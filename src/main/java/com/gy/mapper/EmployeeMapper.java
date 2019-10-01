package com.gy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gy.bean.Employee;

public interface EmployeeMapper {
	
	
	public Employee queryById(@Param("id") Integer id);
	

}
