package com.athensoft.edusys.client.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.client.entity.StudentProfile;
import com.athensoft.edusys.client.service.StudentProfileService;
import com.athensoft.edusys.client.service.StudentService;

@RestController
@RequestMapping("/edusys/client")
public class StudentProfileController {
	private final StudentProfileService studentProfileService;
	
	public StudentProfileController(StudentProfileService studentProfileService) {
		this.studentProfileService = studentProfileService;
	}
	
	@GetMapping("/studentprofiles")
	public ResponseEntity<List<StudentProfile>> getDataList(){
		return ResponseEntity.ok(studentProfileService.getStudentProfileList());
	}
	
	@GetMapping("/studentprofiles/{stuId}")
	public ResponseEntity<StudentProfile> getDataById(@PathVariable int stuId){
		return ResponseEntity.ok(studentProfileService.getStudentProfileById(stuId));
	}
	
	@GetMapping("/studentprofiles/filters")
	public ResponseEntity<List<StudentProfile>> getDataByFilters(
			@RequestParam(name = "stuId") Optional<Integer> stuId, 
			@RequestParam(name = "parentName1", required = false) String parentName1, 
			@RequestParam(name = "parentName2", required = false) String parentName2, 
			@RequestParam(name = "email1", required = false) String email1) throws ParseException{
		return ResponseEntity.ok(studentProfileService.getStudentProfileListByFilters(stuId, parentName1, parentName2, email1));
	}
	
	@GetMapping("/studentprofiles/filtersStr")
	public ResponseEntity<List<StudentProfile>> getDataByFiltersStr() throws JSONException, ParseException{
		return ResponseEntity.ok(studentProfileService.getStudentProfileListByFiltersStr());
	}

}
