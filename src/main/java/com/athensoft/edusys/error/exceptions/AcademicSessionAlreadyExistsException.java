package com.athensoft.edusys.error.exceptions;

public class AcademicSessionAlreadyExistsException extends AlreadyExistsException{
	private static final long serialVersionUID = -87921169684927662L;

	public AcademicSessionAlreadyExistsException(String message) {
		super(message);
	}
	
	public AcademicSessionAlreadyExistsException() {
		super("Academic session is not found!");
	}
	
	public AcademicSessionAlreadyExistsException(Integer sessionId) {
		super("Academic session " + sessionId + " is not found!");
	}

}
