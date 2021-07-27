package com.athensoft.edusys.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.athensoft.edusys.admin.dao.AcademicGroupRepository;
import com.athensoft.edusys.admin.entity.AcademicGroup;

@Service
public class AcademicGroupService {
	private final AcademicGroupRepository acdGroupRepo;
	
	public AcademicGroupService(AcademicGroupRepository acdGroupRepo) {
		this.acdGroupRepo = acdGroupRepo;
	}
	
	public List<AcademicGroup> getAcademicGroupList(){
		return acdGroupRepo.findAll();
	}

}
