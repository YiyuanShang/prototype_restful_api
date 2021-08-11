package com.athensoft.edusys.error.exceptions;

public class AcademicSessionNotFoundException extends NotFoundException{
	private static final long serialVersionUID = -466991501292760793L;
	
	public AcademicSessionNotFoundException() {
		super("Academic Session is not found!");
	}
	
	public AcademicSessionNotFoundException(Integer sessionId) {
		super("Academic Session " + sessionId + " is not found!");
	}

	public AcademicSessionNotFoundException(String message) {
		super(message);
	}

}
