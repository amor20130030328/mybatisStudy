package com.gy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.Student;

/**
 * 测试动态SQL
 * @author 范
 *
 */
public interface StudentMapper {
	
	
	public Student queryById(@Param("id") String id);

	public List<Student> queryByConditionIf(Student s);
	
	public List<Student> queryByConditionTrim(Student s);
	
	public List<Student> queryByConditionChoose(Student s);
	
	public List<Student> queryByIds(@Param("ids") List<String> ids);
	
	public List<Student> getEmployeeByInnerTest(Object o);
	
	public void insertStu(Student student);
	
	public void updateTestSet(Student student);

	public void batchInsert(List<Student> list);

	public void batchInsertMutilQuery(List<Student> list);

	public void batchInsertWithOracle(List<Student> list);

	public void batchInsertWithOracleTwo(List<Student> list);
	
	/**
	 * 模糊查询测试bind标签
	 * @param lastName
	 * @return
	 */
	public List<Student> queryByLastName(@Param("lastName") String lastName);

}
