package com.gy.bean;

public class Department {
	
	private Integer id;
	
	private String deptName;
	
	private String location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Integer id, String deptName, String location) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", location=" + location + "]";
	}
	
	


}
