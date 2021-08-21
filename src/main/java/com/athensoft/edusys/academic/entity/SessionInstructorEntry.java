package com.athensoft.edusys.academic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.athensoft.edusys.hr.entity.Instructor;

@Entity
@Table(name = "acd_rel_session_instructor")
@IdClass(SessionInstructorEntryId.class)
public class SessionInstructorEntry {
	@Id
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Instructor instructor;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "session_id")
	private AcademicSession session;

	public SessionInstructorEntry() {}
	
	public SessionInstructorEntry(Instructor instructor, AcademicSession session) {
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
	public String toString() {
		return "SessionInstructorEntry [instructor=" + instructor + ", session=" + session + "]";
	}
	
	

}
