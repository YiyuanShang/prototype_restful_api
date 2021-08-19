package com.athensoft.edusys.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.admin.entity.AdminEntry;
import com.athensoft.edusys.admin.service.AdminEntryService;

@RestController
@RequestMapping("/edusys/admin")
public class AdminEntryController {
	private final AdminEntryService adminEntryService;
	
	public AdminEntryController(AdminEntryService adminEntryService) {
		this.adminEntryService = adminEntryService;
	}
	
	@GetMapping("/adminEntries")
	public ResponseEntity<List<AdminEntry>> getDataListAdminEntry(){
		return ResponseEntity.ok(adminEntryService.getAdminEntryList());
	}
	
	@GetMapping("/adminEntries/filters")
	public ResponseEntity<List<AdminEntry>> getDataListAdminEntryByFilters(
			@RequestParam(name = "groupId") Optional<Integer> groupId, 
			@RequestParam(name = "empId") Optional<Integer> empId, 
			@RequestParam(name = "comment", required = false) String comment,
			@RequestParam(name = "adminStatus") Optional<Integer> adminStatus){
		return ResponseEntity.ok(adminEntryService.getAdminEntryListByFilter(groupId, empId, comment, adminStatus));
	}

}
