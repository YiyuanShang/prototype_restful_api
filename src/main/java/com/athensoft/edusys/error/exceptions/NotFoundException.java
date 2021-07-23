package com.athensoft.edusys.error.exceptions;

public abstract class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = -5210972138426469652L;

	public NotFoundException(String message) {
		super(message);
	}
}
