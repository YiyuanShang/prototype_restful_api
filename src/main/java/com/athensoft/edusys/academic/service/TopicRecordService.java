package com.athensoft.edusys.academic.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.academic.dao.TopicRecordRepository;
import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.academic.entity.TopicRecord;
import com.athensoft.edusys.error.exceptions.TopicAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.TopicRecordNotFoundException;

@Service
public class TopicRecordService {
	private final TopicRecordRepository topicRecordRepo;
	
	private final AcademicSessionService sessionService;
	
	public TopicRecordService(TopicRecordRepository topicRecordRepo, AcademicSessionService sessionService) {
		this.topicRecordRepo = topicRecordRepo;
		this.sessionService = sessionService;
	}
	
	public TopicRecord getTopicRecordBySessionId(Integer sessionId) {
		return topicRecordRepo.findByDeliveredSession_sessionId(sessionId).orElseThrow(() -> new TopicRecordNotFoundException(sessionId));
	}
	
	public ResponseEntity<TopicRecord> createTopicRecord(Integer sessionId, TopicRecord topicRecord){
		checkTopicAlreadyExistsException(topicRecord.getTopicRecordId());
		TopicRecord createdTopicRecord = topicRecordRepo.save(topicRecord);
		AcademicSession session = sessionService.getAcademicSessionById(sessionId);
		session.setTopicRecord(createdTopicRecord);
		
		sessionService.updateAcademicSession(session);
		return new ResponseEntity<>(createdTopicRecord, HttpStatus.CREATED);
	}
	
	private void checkTopicRecordNotFoundException(Integer sessionId) {
		if (!topicRecordRepo.existsByDeliveredSession_sessionId(sessionId)) {
			throw new TopicRecordNotFoundException(sessionId);
		}
	}
	
	private void checkTopicAlreadyExistsException(Integer topicRecordId) {
		if (topicRecordRepo.existsById(topicRecordId)) {
			throw new TopicAlreadyExistsException();
		}
	}

}
