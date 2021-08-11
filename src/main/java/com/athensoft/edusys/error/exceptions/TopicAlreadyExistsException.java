package com.athensoft.edusys.error.exceptions;

public class TopicAlreadyExistsException extends AlreadyExistsException{
	private static final long serialVersionUID = -2871721254785741949L;

	public TopicAlreadyExistsException(String message) {
		super(message);
	}
	
	public TopicAlreadyExistsException() {
		super("Topic already exists!");
	}

	public TopicAlreadyExistsException(Integer topicId) {
		super("Topic " + topicId + " already exists!");
	}
}
