package com.gy.bean;

import java.io.Serializable;

public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8719029937337096579L;

	private Integer id;
	
	private String lastName;
	
	private String classId;
	
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(Integer id, String lastName, String classId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.classId = classId;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", lastName=" + lastName + ", classId=" + classId + "]";
	}
	
	

}
