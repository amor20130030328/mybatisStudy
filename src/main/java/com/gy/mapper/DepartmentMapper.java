package com.gy.mapper;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.Department;

public interface DepartmentMapper {
	
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	Department queryById(@Param("id")Integer id);

}
