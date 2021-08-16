package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.academic.entity.AssignmentRecord;

public class AssignmentRecordAlreadyExistsException extends AlreadyExistsException {
	private static final long serialVersionUID = -694504633335055824L;

	public AssignmentRecordAlreadyExistsException() {
		super("Assignment record already exists!");
	}
	
	public AssignmentRecordAlreadyExistsException(Integer sessionId) {
		super("Assignment record of session " + sessionId + " already exists!");
	}
	
	public AssignmentRecordAlreadyExistsException(String message) {
		super(message);
	}
}
