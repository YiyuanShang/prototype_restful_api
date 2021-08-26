package com.athensoft.edusys.academic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.academic.entity.AssignmentRecord;
import com.athensoft.edusys.academic.entity.SessionInstructorEntry;
import com.athensoft.edusys.academic.entity.TopicRecord;
import com.athensoft.edusys.academic.entity.TopicRecordEntry;
import com.athensoft.edusys.academic.service.AcademicSessionService;
import com.athensoft.edusys.academic.service.AssignmentRecordService;
import com.athensoft.edusys.academic.service.SessionInstructorEntryService;
import com.athensoft.edusys.academic.service.TopicRecordService;
import com.athensoft.edusys.admin.entity.DeliveryRecord;
import com.athensoft.edusys.admin.service.DeliveryRecordService;

@RestController
@RequestMapping("/edusys/academic")
public class AcademicSessionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AcademicSessionController.class);
	private final AcademicSessionService acdSessionService;

	private final TopicRecordService topicRecordService;
	private final AssignmentRecordService assignmentRecordService;
	private final DeliveryRecordService deliveryRecordService;
	private final SessionInstructorEntryService sessionInstructorEntryService;

	public AcademicSessionController(AcademicSessionService acdSessionService, 
			TopicRecordService topicRecordService, 
			AssignmentRecordService assignmentRecordService,
			DeliveryRecordService deliveryRecordService,
			SessionInstructorEntryService sessionInstructorEntryService) {
		this.acdSessionService = acdSessionService;
		this.topicRecordService = topicRecordService;
		this.assignmentRecordService = assignmentRecordService;
		this.deliveryRecordService = deliveryRecordService;
		this.sessionInstructorEntryService = sessionInstructorEntryService;
	}

	@GetMapping("/acdSessions")
	public ResponseEntity<List<AcademicSession>> getDataListAcademicSession() {
		return ResponseEntity.ok(acdSessionService.getAcademicSessionList());
	}

	@GetMapping("/acdSessions/{sessionId}")
	public ResponseEntity<AcademicSession> getDataAcademicSession(@PathVariable Integer sessionId) {
		return ResponseEntity.ok(acdSessionService.getAcademicSessionById(sessionId));
	}
	
	@GetMapping("/acdSessions/{sessionId}/deliveryRecord")
	public ResponseEntity<DeliveryRecord> getDataDeliveryRecord(@PathVariable Integer sessionId){
		return ResponseEntity.ok(deliveryRecordService.getDeliveryRecordBySessionId(sessionId));
	}

	@GetMapping("/acdSessions/{sessionId}/topicRecord")
	public ResponseEntity<TopicRecord> getDataTopicRecord(@PathVariable Integer sessionId) {
		return ResponseEntity.ok(topicRecordService.getTopicRecordBySessionId(sessionId));
	}
	
	@GetMapping("/acdSessions/{sessionId}/assignmentRecord")
	public ResponseEntity<AssignmentRecord> getDataAssignmentRecord(@PathVariable Integer sessionId) {
		return ResponseEntity.ok(assignmentRecordService.getAssignmentRecordBySessionId(sessionId));
	}
	
	@GetMapping("/acdSessions/{sessionId}/instructors")
	public ResponseEntity<List<SessionInstructorEntry>> getDataListSessionInstructorEntry(@PathVariable Integer sessionId){
		return ResponseEntity.ok(sessionInstructorEntryService.getSessionInstructorEntryListBySessionId(sessionId));
	}

	@PostMapping(value = "/acdSessions", consumes = "application/json")
	public ResponseEntity<AcademicSession> createAcademicSession(@RequestBody AcademicSession session) {
		LOGGER.debug("entering createAcademicSession session:" + session);
		return acdSessionService.createAcademicSession(session);
	}
	
	@PostMapping("/acdSessions/{sessionId}/deliveryRecord")
	public ResponseEntity<DeliveryRecord> addDeliveryRecordToAcademicSession(@PathVariable Integer sessionId, @RequestBody List<Integer> empIdList){
		LOGGER.debug("entering addDeliveryRecordToAcademicSession sessionId:" + sessionId + "\t empIdList:" + empIdList);
		return ResponseEntity.ok(acdSessionService.addDeliveryRecordToAcademicSession(sessionId, empIdList));
	}

//	@PutMapping("/acdSessions/{sessionId}/topicRecord")
//	public ResponseEntity<TopicRecord> updateTopicRecordInAcademicSession(@PathVariable Integer sessionId,
//			@RequestBody List<TopicRecordEntry> topicRecordEntries) {
//		LOGGER.debug("entering addTopicRecordToAcademicSession");
//		return topicRecordService.updateTopicRecord(sessionId, topicRecordEntries);
//	}
	
//	@@PutMapping("/acdSessions/{sessionId}/assgmtRecord")
//	public ResponseEntity<AssignmentRecord> addAssignmentRecordToAcademicSession(@PathVariable Integer sessionId,
//			@RequestBody AssignmentRecord assignmentRecord){
//		LOGGER.debug("entering addAssignmentRecordToAcademicSession");
//		return assignmentRecordService.createAssignmentRecord(sessionId, assignmentRecord);
//	}
}
