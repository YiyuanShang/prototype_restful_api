package com.athensoft.edusys.error.exceptions;

public class DeliveryRecordNotFoundException extends NotFoundException{

	public DeliveryRecordNotFoundException(String message) {
		super(message);
	}
	
	public DeliveryRecordNotFoundException(Integer sessionId) {
		super("Delivery record of session " + sessionId + " is not found!");
	}

}
