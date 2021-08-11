package com.athensoft.edusys.error.exceptions;

public class SubjectAlreadyExistsException extends AlreadyExistsException{
	private static final long serialVersionUID = 1052043359928092788L;

	public SubjectAlreadyExistsException(String message) {
		super(message);
	}
	public SubjectAlreadyExistsException() {
		super("Subject already exists!");
	}
	public SubjectAlreadyExistsException(Integer subjectId) {
		super("Subject " + subjectId + " already exists!");
	}

	
}
