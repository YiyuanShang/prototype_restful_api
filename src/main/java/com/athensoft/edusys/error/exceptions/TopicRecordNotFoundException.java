package com.athensoft.edusys.error.exceptions;

public class TopicRecordNotFoundException extends NotFoundException{

	public TopicRecordNotFoundException(String message) {
		super(message);
	}
	
	public TopicRecordNotFoundException() {
		super("Topic record is not found!");
	}
	
	public TopicRecordNotFoundException(Integer sessionId) {
		super("Topic record of session " + sessionId + " is not found!");
	}

}
