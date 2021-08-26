package com.athensoft.edusys.error.exceptions;

public class DeliveryRecordEntryAlreadyExistsException extends AlreadyExistsException{

	public DeliveryRecordEntryAlreadyExistsException(String message) {
		super(message);
	}
	
	public DeliveryRecordEntryAlreadyExistsException(Integer entryId) {
		super("Delivery record entry " + entryId + " already exists!");
	}

}
