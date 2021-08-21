package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.client.entity.StudentProfile;

public class StudentProfileAlreadyExistsException extends AlreadyExistsException {
	private static final long serialVersionUID = -694504633335055824L;

	public StudentProfileAlreadyExistsException() {
		super("Student profile already exists!");
	}
	
	public StudentProfileAlreadyExistsException(Integer stuId) {
		super("Student profile of stduent " + stuId + " already exists!");
	}
	
	
	public StudentProfileAlreadyExistsException(String message) {
		super(message);
	}
}
