package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.admin.entity.AcademicGroup;
import com.athensoft.edusys.hr.entity.Employee;

public class AcademicGroupNotFoundException extends NotFoundException {
	private static final long serialVersionUID = -5166051832976469902L;
	
	public AcademicGroupNotFoundException() {
		super("Academic group is not found!");
	}
	
	public AcademicGroupNotFoundException(Integer groupId) {
		super("Academic group " + groupId + " is not found!");
	}
	
	public AcademicGroupNotFoundException(AcademicGroup group) {
		super("Academic group " + group.getGroupId() + " is not found!");
	}
	public AcademicGroupNotFoundException(String message) {
		super(message);
	}

}