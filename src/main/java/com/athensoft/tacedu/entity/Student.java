package com.athensoft.tacedu.entity;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer stuId;
	
	private String stuNumber;
	
	private String stuFirstName;

	public Student() {}
	public Student(Integer stuId, String stuNumber, String stuFirstName) {
		super();
		this.stuId = stuId;
		this.stuNumber = stuNumber;
		this.stuFirstName = stuFirstName;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	public String getStuFirstName() {
		return stuFirstName;
	}
	public void setStuFirstName(String stuFirstName) {
		this.stuFirstName = stuFirstName;
	}
	
	

}
