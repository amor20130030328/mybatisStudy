package com.gy.bean;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 批量起别名的情况下
 * 使用@alias起别名
 * @author 范
 *
 */
@Alias("j")
public class Job {
	
	private Integer id;
	
	private String jobTitle;
	
	
	private List<Employee> emps;
 	
	public Job() {
		// TODO Auto-generated constructor stub
	}

	public Job(Integer id, String jobTitle) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
	}
	
	

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + ", emps=" + emps + "]";
	}

}
