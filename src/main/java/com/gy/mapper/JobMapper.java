package com.gy.mapper;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.Job;

public interface JobMapper {
	
	Job queryById(@Param("id") Integer id);

}
