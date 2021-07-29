package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.admin.entity.AcademicGroup;
import com.athensoft.edusys.client.entity.Student;

public class AcademicGroupAlreadyExistsException extends AlreadyExistsException {
	private static final long serialVersionUID = -694504633335055824L;

	public AcademicGroupAlreadyExistsException() {
		super("Academic group already exists!");
	}
	
	public AcademicGroupAlreadyExistsException(Integer groupId) {
		super("Academic group " + groupId + " already exists!");
	}
	
	public AcademicGroupAlreadyExistsException(AcademicGroup group) {
		super("Academic group " + group.getGroupId() + " already exists!");
	}
	
	public AcademicGroupAlreadyExistsException(String message) {
		super(message);
	}
}
