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
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hr_employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id", nullable = false)
	protected Integer empId = -1;

	@Column(name = "emp_code", unique = true, nullable = false)
	protected String empCode;

	@Column(name = "emp_firstname", nullable = false)
	protected String empFirstName;

	@Column(name = "emp_lastname", nullable = false)
	protected String empLastName;

	protected String email;

	@Enumerated(EnumType.ORDINAL)
	protected EmploymentType empType;

	@Column(name = "hiredate")
	@Temporal(TemporalType.DATE)
	protected Date hireDate;

	@Column(name = "expirydate")
	@Temporal(TemporalType.DATE)
	protected Date expiryDate;

	@Enumerated(EnumType.ORDINAL)
	protected RoleType roleType;

	private String phoneNumber;

	public Employee() {
	}

	public Employee(Integer empId, String empCode, String empFirstName, String empLastName, String email,
			EmploymentType empType, Date hireDate, Date expiryDate, String phoneNumber) {
		super();
		this.empId = empId;
		this.empCode = empCode;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.email = email;
		this.empType = empType;
		this.hireDate = hireDate;
		this.expiryDate = expiryDate;
		this.phoneNumber = phoneNumber;
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

	public EmploymentType getEmpType() {
		return empType;
	}

	public void setEmpType(EmploymentType empType) {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empCode=" + empCode + ", empFirstName=" + empFirstName + ", empLastName="
				+ empLastName + ", email=" + email + ", empType=" + empType + ", hireDate=" + hireDate + ", expiryDate="
				+ expiryDate + ", phoneNumber=" + phoneNumber + "]";
	}

}
