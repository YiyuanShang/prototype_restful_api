package com.athensoft.edusys.client.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client_student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stuId;
	
	@Column(name = "stu_no", unique = true)
	private String stuNo;
	
	@Column(name = "stu_firstname", nullable = false)
	private String stuFirstName;
	
	@Column(name = "stu_lastname", nullable = false)
	private String stuLastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "ismember", columnDefinition = "boolean default false")
	private boolean isMember;
	
	@Column(name = "regdate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date regDate;
	
	@Enumerated(EnumType.ORDINAL)
	private StudentType stuType;

	public Student() {}
	
	public Student(int stuId, String stuNo, String stuFirstName, String stuLastName, String email, boolean isMember,
			Date regDate, StudentType stuType) {
		super();
		this.stuId = stuId;
		this.stuNo = stuNo;
		this.stuFirstName = stuFirstName;
		this.stuLastName = stuLastName;
		this.email = email;
		this.isMember = isMember;
		this.regDate = regDate;
		this.stuType = stuType;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuFirstName() {
		return stuFirstName;
	}

	public void setStuFirstName(String stuFirstName) {
		this.stuFirstName = stuFirstName;
	}

	public String getStuLastName() {
		return stuLastName;
	}

	public void setStuLastName(String stuLastName) {
		this.stuLastName = stuLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public StudentType getStuType() {
		return stuType;
	}

	public void setStuType(StudentType stuType) {
		this.stuType = stuType;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuNo=" + stuNo + ", stuFirstName=" + stuFirstName + ", stuLastName="
				+ stuLastName + ", email=" + email + ", isMember=" + isMember + ", regDate=" + regDate + ", stuType="
				+ stuType + "]";
	}
	
	
}
