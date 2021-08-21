package com.athensoft.edusys.academic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.academic.dao.AcademicSessionRepository;
import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.academic.entity.TopicRecord;
import com.athensoft.edusys.error.exceptions.AcademicSessionAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.AcademicSessionNotFoundException;

@Service
public class AcademicSessionService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AcademicSessionService.class);
	private final AcademicSessionRepository acdSessionRepo;
	
	private final TopicRecordService topicRecordService;
	private final AssignmentRecordService assgmtRecordService;
	
	public AcademicSessionService(AcademicSessionRepository acdSessionRepo, TopicRecordService topicRecordService, AssignmentRecordService assgmtRecordService) {
		this.acdSessionRepo = acdSessionRepo;
		this.topicRecordService = topicRecordService;
		this.assgmtRecordService = assgmtRecordService;
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
		AcademicSession createdSession = acdSessionRepo.save(session);
		
		// create topic record
//		createdSession.setTopicRecord(topicRecordService.createTopicRecord(createdSession));
		
		// create assignment record
		createdSession.setAssignmentRecord(assgmtRecordService.createAssignmentRecord(createdSession));
		
		return new ResponseEntity<>(createdSession, HttpStatus.CREATED);
	}
	
	public ResponseEntity<AcademicSession> updateAcademicSession(AcademicSession session){
		checkAcademicSessionNotFoundException(session.getSessionId());
		return ResponseEntity.ok(acdSessionRepo.save(session));
	}
	
	private void checkAcademicSessionAlreadyExistsException(Integer sessionId) {
		if (acdSessionRepo.existsById(sessionId)) {
			throw new AcademicSessionAlreadyExistsException(sessionId);
		}
	}
	
	private void checkAcademicSessionNotFoundException(Integer sessionId) {
		if (!acdSessionRepo.existsById(sessionId)) {
			throw new AcademicSessionNotFoundException(sessionId);
		}
	}
	
	

}
