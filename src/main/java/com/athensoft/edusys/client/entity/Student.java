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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client_student")
@Getter @Setter @NoArgsConstructor @ToString
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
	
	@Column(name = "ismember")
	private boolean isMember;
	
	@Column(name = "regdate", nullable = false)
	private Date regDate;
	
	@Enumerated(EnumType.ORDINAL)
	private StudentType stuType;
}
