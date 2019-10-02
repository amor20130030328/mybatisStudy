package com.gy.mapper;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.Job;

public interface JobMapper {
	
	Job queryById(@Param("id") Integer id);
	
	/**
	 * 嵌套查询
	 * @param id
	 * @return
	 */
	Job queryByIdNesting(@Param("id") Integer id);

}
