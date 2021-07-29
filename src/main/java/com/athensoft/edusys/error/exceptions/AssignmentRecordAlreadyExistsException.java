package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.academic.entity.AssignmentRecord;

public class AssignmentRecordAlreadyExistsException extends AlreadyExistsException {
	private static final long serialVersionUID = -694504633335055824L;

	public AssignmentRecordAlreadyExistsException() {
		super("Assignment record already exists!");
	}
	
	public AssignmentRecordAlreadyExistsException(Integer assgmtRecordId) {
		super("Assignment record " + assgmtRecordId + " already exists!");
	}
	
	public AssignmentRecordAlreadyExistsException(AssignmentRecord assgmtRecord) {
		super("Assignment record " + assgmtRecord.getAssgmtRecordId() + " already exists!");
	}
	
	public AssignmentRecordAlreadyExistsException(String message) {
		super(message);
	}
}
