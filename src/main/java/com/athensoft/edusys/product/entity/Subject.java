package com.athensoft.edusys.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prod_subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subjectId = -1;
	
	@Column(unique = true)
	private String subjectCode;
	
	private String subjectName;
	
	private String subjectDesc;

	public Subject() {}
	public Subject(Integer subjectId, String subjectCode, String subjectName, String subjectDesc) {
		super();
		this.subjectId = subjectId;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.subjectDesc = subjectDesc;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectDesc() {
		return subjectDesc;
	}
	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName
				+ ", subjectDesc=" + subjectDesc + "]";
	}
	
	
	
}
