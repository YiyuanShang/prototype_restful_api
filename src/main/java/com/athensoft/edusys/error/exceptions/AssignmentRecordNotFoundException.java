package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.academic.entity.AssignmentRecord;

public class AssignmentRecordNotFoundException extends NotFoundException {
	private static final long serialVersionUID = -5166051832976469902L;
	
	public AssignmentRecordNotFoundException() {
		super("Assignment record is not found!");
	}
	
	public AssignmentRecordNotFoundException(Integer assgmtRecordId) {
		super("Assignment record " + assgmtRecordId + " is not found!");
	}
	
	public AssignmentRecordNotFoundException(AssignmentRecord assgmtRecord) {
		super("Assignment record " + assgmtRecord.getAssgmtRecordId() + " is not found!");
	}
	public AssignmentRecordNotFoundException(String message) {
		super(message);
	}

}