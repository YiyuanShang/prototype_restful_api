package com.athensoft.edusys.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.admin.entity.AcademicGroup;
import com.athensoft.edusys.admin.service.AcademicGroupService;

@RestController
@RequestMapping("/edusys/admin")
public class AcademicGroupController {
	private final AcademicGroupService acdGroupService;
	
	public AcademicGroupController(AcademicGroupService acdGroupService) {
		this.acdGroupService = acdGroupService;
	}
	
	@GetMapping("/groups")
	public List<AcademicGroup> getDataList(){
		return acdGroupService.getAcademicGroupList();
	}
	
	@GetMapping("/groups/{groupId}")
	public AcademicGroup getDataById(@PathVariable Integer groupId) {
		return acdGroupService.getAcademicGroupById(groupId);
	}
	


}
