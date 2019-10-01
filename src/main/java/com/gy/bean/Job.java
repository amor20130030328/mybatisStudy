package com.gy.bean;

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
	
	public Job() {
		// TODO Auto-generated constructor stub
	}

	public Job(Integer id, String jobTitle) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
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
		return "Job [id=" + id + ", jobTitle=" + jobTitle + "]";
	}

}
