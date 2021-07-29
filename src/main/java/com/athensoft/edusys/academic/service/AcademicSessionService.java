package com.athensoft.edusys.academic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.athensoft.edusys.academic.dao.AcademicSessionRepository;
import com.athensoft.edusys.academic.entity.AcademicSession;

@Service
public class AcademicSessionService {
	private final AcademicSessionRepository acdSessionRepo;
	
	public AcademicSessionService(AcademicSessionRepository acdSessionRepo) {
		this.acdSessionRepo = acdSessionRepo;
	}
	
	public List<AcademicSession> getAcademicSessionList(){
		return acdSessionRepo.findAll();
	}
	
	

}
