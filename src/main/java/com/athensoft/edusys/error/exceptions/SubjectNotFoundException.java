package com.athensoft.edusys.error.exceptions;

public class SubjectNotFoundException extends NotFoundException{
	private static final long serialVersionUID = 2010447916124289935L;

	public SubjectNotFoundException(String message) {
		super(message);
	}
	
	public SubjectNotFoundException() {
		super("Subject is not found!");
	}
	
	public SubjectNotFoundException(Integer subjectId) {
		super("Subject " + subjectId + " is not found!");
	}

}
