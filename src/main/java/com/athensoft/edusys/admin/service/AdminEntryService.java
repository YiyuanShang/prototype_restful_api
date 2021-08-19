package com.athensoft.edusys.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.admin.dao.AdminEntryRepository;
import com.athensoft.edusys.admin.entity.AcademicGroup;
import com.athensoft.edusys.admin.entity.AdminEntry;
import com.athensoft.edusys.admin.entity.AdminEntryId;
import com.athensoft.edusys.admin.entity.AdminStatus;
import com.athensoft.edusys.hr.entity.Admin;
import com.athensoft.edusys.hr.service.EmployeeService;

@Service
public class AdminEntryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminEntryService.class);
	private final AdminEntryRepository adminEntryRepo;
	
	private final EmployeeService employeeService;
	private final AcademicGroupService acdGroupService;
	
	public AdminEntryService(AdminEntryRepository adminEntryRepo, EmployeeService employeeService, AcademicGroupService acdGroupService) {
		this.adminEntryRepo = adminEntryRepo;
		this.employeeService = employeeService;
		this.acdGroupService = acdGroupService;
	}
	public List<AdminEntry> getAdminEntryList(){
		return adminEntryRepo.findAll();
	}
	public List<AdminEntry> getAdminEntryListByGroup(Integer groupId){
		return adminEntryRepo.findAllByGroup_groupId(groupId);
	}
	public List<AdminEntry> getAdminEntryListByFilter(
			Optional<Integer> groupId, 
			Optional<Integer> empId, 
			String comment,
			Optional<Integer> adminStatus) {
		
		List<String> ignoredProperties = new ArrayList<>();
		AdminEntry adminEntry = new AdminEntry();
		if(groupId.isEmpty()) {
			ignoredProperties.add("groupId");
		}else {
			AcademicGroup group = acdGroupService.getAcademicGroupById(groupId.get());
			adminEntry.setGroup(group);
		}
		
		if(empId.isEmpty()) {
			ignoredProperties.add("empId");
		}else {
			Admin admin = (Admin) employeeService.getEmployeeById(empId.get());
			adminEntry.setAdmin(admin);
		}
		
		if(adminStatus.isEmpty()) {
			ignoredProperties.add("adminStatus");
		}else {
			adminEntry.setAdminStatus(AdminStatus.values()[adminStatus.get()]);
		}
		
		adminEntry.setComment(comment);
		
		LOGGER.debug("searched adminEntry:" + adminEntry);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}

		Example<AdminEntry> example = Example.of(adminEntry, exampleMatcher);
		LOGGER.debug("example adminEntry:" + example.toString());
		return adminEntryRepo.findAll(example);
		
	}
	public AcademicGroup addAdminToAcademicGroup(Integer groupId, AdminEntry adminEntry) {
		LOGGER.debug("creating adminEntry:" + adminEntry.getAdminStatus());
		adminEntryRepo.createAdminEntry(adminEntry.getAdmin().getEmpId(), adminEntry.getComment(), adminEntry.getAdminStatus().ordinal(), groupId);
		
		return acdGroupService.getAcademicGroupById(groupId);
	}
	
	public AcademicGroup removeAdminToAcademicGroup(Integer groupId, Integer empId) {
		adminEntryRepo.deleteAdminEntry(empId, groupId);
		return acdGroupService.getAcademicGroupById(groupId);
	}

}
