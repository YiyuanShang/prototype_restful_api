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
import com.athensoft.edusys.academic.service.AcademicSessionService;

@RestController
@RequestMapping("/edusys/academic")
public class AcademicSessionController {
	private final AcademicSessionService acdSessionService;
	
	public AcademicSessionController(AcademicSessionService acdSessionService) {
		this.acdSessionService = acdSessionService;
	}
	
	@GetMapping("/acdSessions")
	public ResponseEntity<List<AcademicSession>> getDataListAcademicSession(){
		return ResponseEntity.ok(acdSessionService.getAcademicSessionList());
	}
	
	@GetMapping("/acdSessions/{sessionId}")
	public ResponseEntity<AcademicSession> getDataAcademicSession(@PathVariable Integer sessionId){
		return ResponseEntity.ok(acdSessionService.getAcademicSessionById(sessionId));
	}
	
	@PostMapping("/acdSessions")
	public ResponseEntity<AcademicSession> createAcademicSession(@RequestBody AcademicSession session){
		return acdSessionService.createAcademicSession(session);
	}

}
