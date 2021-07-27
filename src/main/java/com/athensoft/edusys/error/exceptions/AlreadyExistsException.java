package com.athensoft.edusys.error.exceptions;

public abstract class AlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = -1908180958940951800L;

	public AlreadyExistsException(String message) {
		super(message);
	}

}
