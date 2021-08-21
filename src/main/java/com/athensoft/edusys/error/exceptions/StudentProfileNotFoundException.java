package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.client.entity.StudentProfile;

public class StudentProfileNotFoundException extends NotFoundException {
	private static final long serialVersionUID = -3231332530981116656L;

	public StudentProfileNotFoundException() {
		super("Student profle is not found!");
	}
	
	public StudentProfileNotFoundException(Integer stuId) {
		super("Student profile " + stuId + " is not found!");
	}
	
	public StudentProfileNotFoundException(String message) {
		super(message);
	}

}