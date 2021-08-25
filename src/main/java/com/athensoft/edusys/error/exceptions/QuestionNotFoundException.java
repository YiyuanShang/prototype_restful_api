package com.athensoft.edusys.error.exceptions;

public class QuestionNotFoundException extends NotFoundException{

	public QuestionNotFoundException(String message) {
		super(message);
	}

	public QuestionNotFoundException(Integer questionId) {
		super("Question " + questionId + " is not found!");
	}
}
