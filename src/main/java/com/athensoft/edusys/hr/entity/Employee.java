package com.athensoft.edusys.hr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "hr_employee")
@Inheritance
@DiscriminatorColumn(name = "role_type")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	protected Integer empId = -1;
	
	@Column(name = "emp_code", unique = true, nullable = false)
	protected String empCode;
	
	@Column(name = "emp_firstname", nullable = false)
	protected String empFirstName;
	
	@Column(name = "emp_lastname", nullable = false)
	protected String empLastName;
	
	@Column(name = "email")
	protected String email;
	
	@Enumerated(EnumType.ORDINAL)
	protected EmployeeType empType;
	
	@Column(name = "hiredate")
	@Temporal(TemporalType.DATE)
	protected Date hireDate;
	
	@Column(name = "expirydate")
	@Temporal(TemporalType.DATE)
	protected Date expiryDate;
//	
//	@Enumerated(EnumType.ORDINAL)
//	protected RoleType roleType;

	public Employee() {}
	
	public Employee(Integer empId, String empCode, String empFirstName, String empLastName, String email,
			EmployeeType empType, Date hireDate, Date expiryDate) {
		super();
		this.empId = empId;
		this.empCode = empCode;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.email = email;
		this.empType = empType;
		this.hireDate = hireDate;
		this.expiryDate = expiryDate;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmployeeType getEmpType() {
		return empType;
	}

	public void setEmpType(EmployeeType empType) {
		this.empType = empType;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empCode=" + empCode + ", empFirstName=" + empFirstName + ", empLastName="
				+ empLastName + ", email=" + email + ", empType=" + empType + ", hireDate=" + hireDate + ", expiryDate="
				+ expiryDate + "]";
	}

//	public RoleType getRoleType() {
//		return roleType;
//	}
//
//	public void setRoleType(RoleType roleType) {
//		this.roleType = roleType;
//	}

	
	
	
}
