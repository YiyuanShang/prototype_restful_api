package com.athensoft.edusys.academic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.academic.dao.AcademicSessionRepository;
import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.error.exceptions.AcademicSessionAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.AcademicSessionNotFoundException;

@Service
public class AcademicSessionService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AcademicSessionService.class);
	private final AcademicSessionRepository acdSessionRepo;
	
	public AcademicSessionService(AcademicSessionRepository acdSessionRepo) {
		this.acdSessionRepo = acdSessionRepo;
	}
	
	public List<AcademicSession> getAcademicSessionList(){
		return acdSessionRepo.findAll();
	}
	
	public AcademicSession getAcademicSessionById(Integer sessionId) {
		return acdSessionRepo.findById(sessionId).orElseThrow(() -> new AcademicSessionNotFoundException(sessionId));
	}
	
	public ResponseEntity<AcademicSession> createAcademicSession(AcademicSession session){
		checkAcademicSessionAlreadyExistsException(session.getSessionId());
		LOGGER.debug("creating session:" + session);
		return new ResponseEntity<>(acdSessionRepo.save(session), HttpStatus.CREATED);
	}
	
	private void checkAcademicSessionAlreadyExistsException(Integer sesisonId) {
		if (acdSessionRepo.existsById(sesisonId)) {
			throw new AcademicSessionAlreadyExistsException(sesisonId);
		}
	}
	

}
