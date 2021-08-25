package com.athensoft.edusys.error.exceptions;

public class QuestionAlreadyExistsException extends AlreadyExistsException{

	public QuestionAlreadyExistsException(String message) {
		super(message);
	}
	
	public QuestionAlreadyExistsException(Integer questionId) {
		super("Question " + questionId + " already exists!");
	}

}
