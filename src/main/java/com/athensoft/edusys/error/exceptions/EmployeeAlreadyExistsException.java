package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.hr.entity.Employee;

public class EmployeeAlreadyExistsException extends AlreadyExistsException {
	private static final long serialVersionUID = -694504633335055824L;

	public EmployeeAlreadyExistsException() {
		super("Employee already exists!");
	}
	
	public EmployeeAlreadyExistsException(Integer empId) {
		super("Employee " + empId + " already exists!");
	}
	
	public EmployeeAlreadyExistsException(Employee employee) {
		super("Employee " + employee.getEmpId() + " already exists!");
	}
	
	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}
}
