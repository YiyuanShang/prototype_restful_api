package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.client.entity.Student;

public class StudentAlreadyExistsException extends AlreadyExistsException {
	private static final long serialVersionUID = -694504633335055824L;

	public StudentAlreadyExistsException() {
		super("Student already exists!");
	}
	
	public StudentAlreadyExistsException(Integer stuId) {
		super("Student " + stuId + " already exists!");
	}
	
	public StudentAlreadyExistsException(Student student) {
		super("Student " + student.getStuNo() + " already exists!");
	}
	
	public StudentAlreadyExistsException(String message) {
		super(message);
	}
}
