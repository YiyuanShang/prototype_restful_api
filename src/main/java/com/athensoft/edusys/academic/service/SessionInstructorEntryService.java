package com.athensoft.edusys.academic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.athensoft.edusys.academic.dao.SessionInstructorEntryRepository;
import com.athensoft.edusys.academic.entity.SessionInstructorEntry;

@Service
public class SessionInstructorEntryService {
	private final SessionInstructorEntryRepository sessionInstructorEntryRepo;
	
	public SessionInstructorEntryService(SessionInstructorEntryRepository sessionInstructorEntryRepo) {
		this.sessionInstructorEntryRepo = sessionInstructorEntryRepo;
	}
	
	public List<SessionInstructorEntry> getSessionInstructorEntryListBySessionId(Integer sessionId){
		return sessionInstructorEntryRepo.findAllBySession_sessionId(sessionId);
	}
	
	public List<SessionInstructorEntry> getSessionInstructorEntryListByEmpId(Integer empId){
		return sessionInstructorEntryRepo.findAllByInstructor_empId(empId);
	}

}
