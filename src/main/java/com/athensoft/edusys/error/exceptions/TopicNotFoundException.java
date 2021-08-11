package com.athensoft.edusys.error.exceptions;

public class TopicNotFoundException extends NotFoundException{

	public TopicNotFoundException(String message) {
		super(message);
	}
	
	public TopicNotFoundException() {
		super("Topic is not found!");
	}
	
	public TopicNotFoundException(Integer topicId) {
		super("Topic " + topicId + " is not found!");
	}

}
