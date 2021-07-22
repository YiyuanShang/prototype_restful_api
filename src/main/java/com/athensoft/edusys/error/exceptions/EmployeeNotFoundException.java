package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.hr.entity.Employee;

public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3231332530981116656L;

	public EmployeeNotFoundException() {
		super("Employee is not found!");
	}
	
	public EmployeeNotFoundException(int empId) {
		super("Employee " + empId + " is not found!");
	}
	
	public EmployeeNotFoundException(Employee employee) {
		super("Employee " + employee.getEmpCode() + " is not found!");
	}
	public EmployeeNotFoundException(String message) {
		super(message);
	}

}