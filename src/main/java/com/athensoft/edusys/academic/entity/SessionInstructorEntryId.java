package com.athensoft.edusys.academic.entity;

import java.io.Serializable;

import com.athensoft.edusys.hr.entity.Instructor;

public class SessionInstructorEntryId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Instructor instructor;
	
	private AcademicSession session;

	public SessionInstructorEntryId() {}
	
	public SessionInstructorEntryId(Instructor instructor, AcademicSession session) {
		super();
		this.instructor = instructor;
		this.session = session;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public AcademicSession getSession() {
		return session;
	}

	public void setSession(AcademicSession session) {
		this.session = session;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
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
		SessionInstructorEntryId other = (SessionInstructorEntryId) obj;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SessionInstructorEntryId [instructor=" + instructor.getEmpId() + ", session=" + session.getSessionId() + "]";
	}
	
	

}
