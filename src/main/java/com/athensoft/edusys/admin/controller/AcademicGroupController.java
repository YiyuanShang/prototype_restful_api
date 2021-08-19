package com.athensoft.edusys.admin.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import com.athensoft.edusys.admin.entity.AdminEntry;
import com.athensoft.edusys.admin.service.AcademicGroupService;
import com.athensoft.edusys.admin.service.AdminEntryService;
import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.product.entity.Course;

@RestController
@RequestMapping("/edusys/admin")
public class AcademicGroupController {
	private final AcademicGroupService acdGroupService;
	private final AdminEntryService adminEntryService;
	
	public AcademicGroupController(AcademicGroupService acdGroupService, AdminEntryService adminEntryService) {
		this.acdGroupService = acdGroupService;
		this.adminEntryService = adminEntryService;
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
			@RequestParam(name = "groupDesc", required = false) String groupDesc,
			@RequestParam(name = "price", required = false) Float price) throws ParseException{
		return ResponseEntity.ok(acdGroupService.getAcademicGroupListByFilters(groupId, groupNo, groupStatus, startDate, endDate, sessionNum, groupType, groupName, groupDesc, price));
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
	
	@PutMapping("/groups/{groupId}/students")
	public ResponseEntity<AcademicGroup> addStudentListToAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @RequestBody List<Student> studentList){
		return ResponseEntity.ok(acdGroupService.addStudentListToAcademicGroup(groupId, studentList));
	}
	
	@PutMapping("/groups/{groupId}/students/student/{stuId}")
	public ResponseEntity<AcademicGroup> addStudentToAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @PathVariable(name = "stuId") Integer stuId){
		return ResponseEntity.ok(acdGroupService.addStudentToAcademicGroup(groupId, stuId));
	}
	
	@PutMapping("/groups/{groupId}/instructors/instructor/{empId}")
	public ResponseEntity<AcademicGroup> addInstructorToAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @PathVariable(name = "empId") Integer empId){
		return ResponseEntity.ok(acdGroupService.addInstructorToAcademicGroup(groupId, empId));
	}

	@PutMapping("/groups/{groupId}/courses")
	public ResponseEntity<AcademicGroup> addCourseListToAcademicGroup(
			@PathVariable(name = "groupId") Integer groupId, 
			@RequestBody List<Map<String, Object>> courseEntryList){
		return ResponseEntity.ok(acdGroupService.addCourseListToAcademicGroup(groupId, courseEntryList));
	}
	
	@PutMapping("/groups/{groupId}/courses/course/{courseId}")
	public ResponseEntity<AcademicGroup> addCourseToAcademicGroup(
			@PathVariable(name = "groupId") Integer groupId, 
			@PathVariable(name = "courseId") Integer courseId, 
			@RequestParam(name = "isPrimary") Boolean isPrimary){
		return ResponseEntity.ok(acdGroupService.addCourseToAcademicGroup(groupId, courseId, isPrimary));
	}

	@PutMapping("/groups/{groupId}/admins/adminEntries")
	public ResponseEntity<AcademicGroup> addAdminToAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @RequestBody AdminEntry adminEntry){
		return ResponseEntity.ok(adminEntryService.addAdminToAcademicGroup(groupId, adminEntry));
	}
	
	@DeleteMapping("/groups/{groupId}/students/student/{stuId}")
	public ResponseEntity<AcademicGroup> removeStudentFromAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @PathVariable(name = "stuId") Integer stuId){
		return ResponseEntity.ok(acdGroupService.removeStudentFromAcademicGroup(groupId, stuId));
	}
	
	@DeleteMapping("/groups/{groupId}/instructors/instructor/{empId}")
	public ResponseEntity<AcademicGroup> removeInstructorToAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @PathVariable(name = "empId") Integer empId){
		return ResponseEntity.ok(acdGroupService.removeInstructorToAcademicGroup(groupId, empId));
	}
	
	@DeleteMapping("/groups/{groupId}/courses")
	public ResponseEntity<AcademicGroup> removeCourseListFromAcademicGroup(
			@PathVariable(name = "groupId") Integer groupId, 
			@RequestBody List<Course> courseList){
		return ResponseEntity.ok(acdGroupService.removeCourseListFromAcademicGroup(groupId, courseList));
	}
	
	@DeleteMapping("/groups/{groupId}/courses/course/{courseId}")
	public ResponseEntity<AcademicGroup> removeCourseFromAcademicGroup(
			@PathVariable(name = "groupId") Integer groupId, 
			@PathVariable(name = "courseId") Integer courseId){
		return ResponseEntity.ok(acdGroupService.removeCourseFromAcademicGroup(groupId, courseId));
	}
	
	@DeleteMapping("/groups/{groupId}/admins/admin/{empId}")
	public ResponseEntity<AcademicGroup> removeAdminToAcademicGroup(@PathVariable(name = "groupId") Integer groupId, @PathVariable(name = "empId") Integer empId){
		return ResponseEntity.ok(adminEntryService.removeAdminToAcademicGroup(groupId, empId));
	}

}
