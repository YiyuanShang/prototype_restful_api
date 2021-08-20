package com.athensoft.edusys.admin.entity;

import java.io.Serializable;

import com.athensoft.edusys.client.entity.Student;

public class GroupStudentEntryId implements Serializable{
	private static final long serialVersionUID = 1L;

	private Student student;
	
	private AcademicGroup group;

	public GroupStudentEntryId() {}
	
	public GroupStudentEntryId(Student student, AcademicGroup group) {
		super();
		this.student = student;
		this.group = group;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AcademicGroup getGroup() {
		return group;
	}

	public void setGroup(AcademicGroup group) {
		this.group = group;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupStudentEntryId other = (GroupStudentEntryId) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupStudentEntryId [student=" + student.getStuId() + ", group=" + group.getGroupId() + "]";
	}
	
	
	
	
	
}
