package com.athensoft.edusys.hr.entity;

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
@Table(name = "hr_employee")
@Getter @Setter @NoArgsConstructor @ToString
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Column(unique = true)
	private String empCode;
	
	private String empFirstName;
	private String empLastName;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private EmployeeType empType;
	
	private Date hireDate;
	private Date expiryDate;
	
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
}
