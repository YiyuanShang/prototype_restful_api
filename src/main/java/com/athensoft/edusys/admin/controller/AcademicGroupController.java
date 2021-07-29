package com.athensoft.edusys.admin.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<AcademicGroup>> getDataList(){
		return ResponseEntity.ok(acdGroupService.getAcademicGroupList());
	}
	
	@GetMapping("/groups/{groupId}")
	public ResponseEntity<AcademicGroup> getDataById(@PathVariable Integer groupId) {
		return ResponseEntity.ok(acdGroupService.getAcademicGroupById(groupId));
	}
	
	@GetMapping("/groups/filters")
	public ResponseEntity<List<AcademicGroup>> getDataByFilters(
			@RequestParam(name = "groupId") Optional<Integer> groupId, 
			@RequestParam(name = "groupNo", required = false) String groupNo,
			@RequestParam(name = "groupStatus") Optional<Integer> groupStatus,
			@RequestParam(name = "startDate") Optional<String> startDate,
			@RequestParam(name = "endDate") Optional<String> endDate,
			@RequestParam(name = "sessionNum") Optional<Integer> sessionNum, 
			@RequestParam(name = "groupType") Optional<Integer> groupType,
			@RequestParam(name = "groupName", required = false) String groupName,
			@RequestParam(name = "groupDesc", required = false) String groupDesc) throws ParseException{
		return ResponseEntity.ok(acdGroupService.getAcademicGroupListByFilters(groupId, groupNo, groupStatus, startDate, endDate, sessionNum, groupType, groupName, groupDesc));
	}
	
	@GetMapping("/groups/filtersStr")
	public ResponseEntity<List<AcademicGroup>> getDataByFiltersStr() throws ParseException{
		return ResponseEntity.ok(acdGroupService.getAcademicGroupListByFiltersStr());
	}
	
	@PostMapping("/groups")
	public ResponseEntity<AcademicGroup> createAcademicGroup(@RequestBody AcademicGroup group){
		return acdGroupService.createAcademicGroup(group);
	}
	
	@PutMapping("/groups")
	public ResponseEntity<AcademicGroup> updateAcademicGroup(@RequestBody AcademicGroup group){
		return acdGroupService.updateAcademicGroup(group);
	}
	
	@DeleteMapping("/groups/{groupId}")
	public ResponseEntity<AcademicGroup> deleteAcademicGroupById(@PathVariable Integer groupId){
		return acdGroupService.deleteAcademicGroupById(groupId);
	}
	
	@DeleteMapping("/groups")
	public ResponseEntity<AcademicGroup> deleteAcademicGroup(@RequestBody AcademicGroup group){
		return acdGroupService.deleteAcademicGroup(group);
	}
	
	@PutMapping("/groups/{groupId}/students/{stuId}")
	public ResponseEntity<AcademicGroup> addStudentToAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @PathVariable(name = "stuId") Integer stuId){
		return ResponseEntity.ok(acdGroupService.addStudentToAcademicGroup(groupId, stuId));
	}
	
	@DeleteMapping("/groups/{groupId}/students/{stuId}")
	public ResponseEntity<AcademicGroup> removeStudentFromAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @PathVariable(name = "stuId") Integer stuId){
		return ResponseEntity.ok(acdGroupService.removeStudentFromAcademicGroup(groupId, stuId));
	}
	
	@PutMapping("/groups/{groupId}/employees/{empId}")
	public ResponseEntity<AcademicGroup> addInstructorToAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @PathVariable(name = "empId") Integer empId){
		return ResponseEntity.ok(acdGroupService.addInstructorToAcademicGroup(groupId, empId));
	}
	
	@DeleteMapping("/groups/{groupId}/employees/{empId}")
	public ResponseEntity<AcademicGroup> removeInstructorToAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @PathVariable(name = "empId") Integer empId){
		return ResponseEntity.ok(acdGroupService.removeInstructorToAcademicGroup(groupId, empId));
	}


}
