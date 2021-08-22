package com.athensoft.edusys.academic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.academic.dao.TopicRecordEntryRepository;
import com.athensoft.edusys.academic.dao.TopicRecordRepository;
import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.academic.entity.TopicRecord;
import com.athensoft.edusys.academic.entity.TopicRecordEntry;
import com.athensoft.edusys.academic.entity.TopicRecordStatus;
import com.athensoft.edusys.error.exceptions.TopicAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.TopicRecordNotFoundException;

@Service
public class TopicRecordService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TopicRecordService.class);
	private final TopicRecordRepository topicRecordRepo;
	private final TopicRecordEntryRepository topicRecordEntryRepo;
	
	public TopicRecordService(TopicRecordRepository topicRecordRepo, TopicRecordEntryRepository topicRecordEntryRepo) {
		this.topicRecordRepo = topicRecordRepo;
		this.topicRecordEntryRepo = topicRecordEntryRepo;
	}
	
	public TopicRecord getTopicRecordBySessionId(Integer sessionId) {
		return topicRecordRepo.findByDeliveredSession_sessionId(sessionId).orElseThrow(() -> new TopicRecordNotFoundException(sessionId));
	}
	
	public TopicRecord createTopicRecord(AcademicSession session){
		LOGGER.debug("entering createTopicRecord session:" + session);
		checkTopicAlreadyExistsException(session.getSessionId());
		
		TopicRecord topicRecord = new TopicRecord();
		topicRecord.setDeliveredSession(session);
		topicRecord.setNumReceivedNotice(0);
		topicRecord.setTopicRecordStatus(TopicRecordStatus.CREATED);
		
		LOGGER.debug("creating topic record:" + topicRecord);
		topicRecord = topicRecordRepo.save(topicRecord);
		LOGGER.debug("created topic record:" + topicRecord);
		
		return topicRecord;
	}
	
//	public ResponseEntity<TopicRecord> updateTopicRecord(AcademicSession session, List<TopicRecordEntry> topicRecordEntries){
//		LOGGER.debug("entering createTopicRecord session:" + session + " \t topicRecordEntries:" + topicRecordEntries);
//		checkTopicAlreadyExistsException(session.getSessionId());
//		
//		TopicRecord topicRecord = new TopicRecord();
////		topicRecord.setTopicRecordEntries(topicRecordEntries);
//		
//		topicRecord.setDeliveredSession(deliveredSession);
//		
//		LOGGER.debug("creating topic record:" + topicRecord);
//		topicRecord = topicRecordRepo.save(topicRecord);
//		LOGGER.debug("created topic record:" + topicRecord);
//		
//		Integer topicRecordId = topicRecord.getTopicRecordId();
//		topicRecordEntries.forEach(topicRecordEntry -> topicRecordEntry.setTopicRecordId(topicRecordId));
//		LOGGER.debug("creating topic record entries:" + topicRecordEntries);
//		topicRecordEntryRepo.saveAll(topicRecordEntries);
//		
//		LOGGER.debug("created topic record entries");
//		deliveredSession.setTopicRecord(topicRecord);
//		LOGGER.debug("updating deliveredSession:" + deliveredSession);
//		sessionService.updateAcademicSession(deliveredSession);
//		
//		return new ResponseEntity<>(topicRecord, HttpStatus.CREATED);
//	}
	
	private void checkTopicRecordNotFoundException(Integer sessionId) {
		if (!topicRecordRepo.existsByDeliveredSession_sessionId(sessionId)) {
			throw new TopicRecordNotFoundException(sessionId);
		}
	}
	
	private void checkTopicAlreadyExistsException(Integer sessionId) {
		if (topicRecordRepo.existsByDeliveredSession_sessionId(sessionId)) {
			throw new TopicAlreadyExistsException(sessionId);
		}
	}

}
