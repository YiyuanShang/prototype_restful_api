package com.athensoft.edusys.error.exceptions;

public class DeliveryRecordAlreadyExistsException extends AlreadyExistsException{

	public DeliveryRecordAlreadyExistsException(String message) {
		super(message);
	}
	
	public DeliveryRecordAlreadyExistsException(Integer sessionId) {
		super("Delivery record of session " + sessionId + " already exists!");
	}

}
