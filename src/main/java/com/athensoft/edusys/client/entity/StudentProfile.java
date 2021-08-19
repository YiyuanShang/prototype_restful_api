package com.athensoft.edusys.client.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "client_student_profile")
public class StudentProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stuId = -1;

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@PrimaryKeyJoinColumn(name = "stu_id", referencedColumnName = "stu_id")
	private Student student;

	@Column(name = "stu_no")
	private String stuNo;

	@Column(name = "parentname_1")
	private String parentName1;

	@Column(name = "parentname_2")
	private String parentName2;

	@Column(name = "email_1")
	private String email1;

	public StudentProfile() {
	}

	public StudentProfile(Student student, String parentName1, String parentName2, String email1) {
		super();
		this.stuId = student.getStuId();
		this.stuNo = student.getStuNo();
		this.student = student;
		this.parentName1 = parentName1;
		this.parentName2 = parentName2;
		this.email1 = email1;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getParentName1() {
		return parentName1;
	}

	public void setParentName1(String parentName1) {
		this.parentName1 = parentName1;
	}

	public String getParentName2() {
		return parentName2;
	}

	public void setParentName2(String parentName2) {
		this.parentName2 = parentName2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	@Override
	public String toString() {
		return "StudentProfile [stuId=" + stuId + ", student=" + student + ", stuNo=" + stuNo + ", parentName1="
				+ parentName1 + ", parentName2=" + parentName2 + ", email1=" + email1 + "]";
	}

	

}
