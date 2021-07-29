package com.athensoft.edusys.academic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<List<AcademicSession>> getDataList(){
		return ResponseEntity.ok(acdSessionService.getAcademicSessionList());
	}
	
	

}
