package com.athensoft.edusys.academic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.academic.entity.SessionInstructorEntry;
import com.athensoft.edusys.academic.entity.SessionInstructorEntryId;

public interface SessionInstructorEntryRepository extends JpaRepository<SessionInstructorEntry, SessionInstructorEntryId>{
	List<SessionInstructorEntry> findAllBySession_sessionId(Integer sessionId);
	
	List<SessionInstructorEntry> findAllByInstructor_empId(Integer empId);
}
