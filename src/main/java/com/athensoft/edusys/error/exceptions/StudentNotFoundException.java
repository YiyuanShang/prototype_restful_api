package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.client.entity.Student;

public class StudentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3231332530981116656L;

	public StudentNotFoundException() {
		super("Student is not found!");
	}
	
	public StudentNotFoundException(int stuId) {
		super("Student " + stuId + " is not found!");
	}
	
	public StudentNotFoundException(Student student) {
		super("Student " + student.getStuNo() + " is not found!");
	}
	public StudentNotFoundException(String message) {
		super(message);
	}

}