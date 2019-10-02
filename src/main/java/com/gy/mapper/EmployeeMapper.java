package com.gy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.gy.bean.Employee;


/**
 * 接口参数
 *   单个参数:mybatis不会做特殊处理
 * 	  #{参数名} ：取出参数值
 * 
 * 
 *   多个参数: mybatis会被封装成一个map
	 key : param1,param2 , ......paramN
	 value : 传入的参数值
	 #{} 就是从map 中获取指定的key的值
	
         命名参数: 明确指定封装参数时map的key ： @param("id")
	多个参数会被封装成一个map
		key : 使用@Param 注解指定的值
		value : 参数
	POJO
	如果多个参数正好是我们业务逻辑的数据模型，我们就可以直接传入pojo
		#{属性名} ，取出传入的pojo的属性值
	Map
	如果多个参数不是业务模型中的数据，没有对应的pojo,不经常用，为了方便，我们也可以传入map
		#{key} 取出 map中对应的值
	TO
	如果多个参数不是业务模型中的数据，但是经常要使用，推荐来编写一个TO (Transfer Object) 数据传输对象
	Page{
		int index,
		int size;
	}


集合
如果是Collection （List,Set） 类型或者是数组
也会特殊处理，也是把传入的list或者数组封装在map中
key : collection ，如果是List 还可以使用这个key (list) , 数组(array)
	#{list[0]}

 *
 */

public interface EmployeeMapper {
	
	//单参数实例
	public Employee queryById( Integer id);
	
	//多个参数
	public Employee queryByIdAndName(@Param("id")Integer id ,@Param("lastName")String name);
	
	public void addEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public void deleteEmp(@Param("id") Integer id);
	
	public List<Employee> querAll();
	
	public List<Employee> querAllWithDis(String id);
	
	public List<Employee> queryByJobId(@Param("jobId") String jobId);
	
	public Map<String, Object> queryByIdReturnMap(@Param("id") String id);

	@MapKey("lastName")
	public Map<String, Employee> queryAllToMap();


}
