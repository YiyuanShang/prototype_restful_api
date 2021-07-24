package com.athensoft.edusys.error.exceptions;

public abstract class AlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 8855512031163284025L;
	
	public AlreadyExistsException(String message) {
		super(message);
	}

}
