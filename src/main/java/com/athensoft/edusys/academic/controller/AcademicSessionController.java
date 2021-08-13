package com.athensoft.edusys.academic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.academic.entity.TopicRecord;
import com.athensoft.edusys.academic.entity.TopicRecordEntry;
import com.athensoft.edusys.academic.service.AcademicSessionService;
import com.athensoft.edusys.academic.service.TopicRecordService;

@RestController
@RequestMapping("/edusys/academic")
public class AcademicSessionController {
	private final AcademicSessionService acdSessionService;
	
	private final TopicRecordService topicRecordService;
	
	public AcademicSessionController(AcademicSessionService acdSessionService, TopicRecordService topicRecordService) {
		this.acdSessionService = acdSessionService;
		this.topicRecordService = topicRecordService;
	}
	
	@GetMapping("/acdSessions")
	public ResponseEntity<List<AcademicSession>> getDataListAcademicSession(){
		return ResponseEntity.ok(acdSessionService.getAcademicSessionList());
	}
	
	@GetMapping("/acdSessions/{sessionId}")
	public ResponseEntity<AcademicSession> getDataAcademicSession(@PathVariable Integer sessionId){
		return ResponseEntity.ok(acdSessionService.getAcademicSessionById(sessionId));
	}
	
	@GetMapping("/acdSessions/{sessionId}/topicRecord")
	public ResponseEntity<TopicRecord> getDataTopicRecord(@PathVariable Integer sessionId){
		return ResponseEntity.ok(topicRecordService.getTopicRecordBySessionId(sessionId));
	}
	
	@PostMapping("/acdSessions")
	public ResponseEntity<AcademicSession> createAcademicSession(@RequestBody AcademicSession session){
		return acdSessionService.createAcademicSession(session);
	}
	
	@PostMapping("/acdSessions/{sessionId}/topicRecord")
	public ResponseEntity<TopicRecord> addTopicRecordToAcademicSession(@PathVariable Integer sessionId, @RequestBody List<TopicRecordEntry> topicRecordEntries){
		return topicRecordService.createTopicRecord(sessionId, topicRecordEntries);
	}
	
	

}
