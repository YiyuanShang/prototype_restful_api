package com.athensoft.edusys.error.exceptions;

public class TopicRecordAlreadyExistsException extends AlreadyExistsException{
	private static final long serialVersionUID = -8559501344201848665L;

	public TopicRecordAlreadyExistsException(String message) {
		super(message);
	}

	public TopicRecordAlreadyExistsException() {
		super("Topic record already exists!");
	}
	
	public TopicRecordAlreadyExistsException(Integer sessionId) {
		super("Topic record of session " + sessionId + " already exists!");
	}
}
