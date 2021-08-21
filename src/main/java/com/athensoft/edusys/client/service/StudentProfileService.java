package com.athensoft.edusys.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.client.dao.StudentProfileRepository;
import com.athensoft.edusys.client.entity.StudentProfile;
import com.athensoft.edusys.error.exceptions.StudentAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.StudentProfileAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.StudentProfileNotFoundException;
import com.athensoft.edusys.utils.validation.GlobalValidationUtils;

@Service
public class StudentProfileService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentProfileService.class);
	private final StudentProfileRepository stuProfileRepo;
	
	private final StudentService stuService;
	
	public StudentProfileService(StudentProfileRepository stuProfileRepo, StudentService stuService) {
		this.stuProfileRepo = stuProfileRepo;
		this.stuService = stuService;
	}
	
	public List<StudentProfile> getStudentProfileList(){
		return stuProfileRepo.findAll();
	}

	public StudentProfile getStudentProfileByStuId(Integer stuId) {
		return stuProfileRepo.findByStudent_stuId(stuId)
				.orElseThrow(() -> new StudentProfileNotFoundException(stuId));
	}

	public List<StudentProfile> getStudentProfileListByFilters(
			Optional<Integer> stuId, 
			String stuPhoneNumber,
			String parentName1, 
			String email1,
			String parentPhoneNumber1,
			String parentName2) {
		
		List<String> ignoredProperties = new ArrayList<>();
		StudentProfile studentProfile = new StudentProfile();
		if(stuId.isEmpty()) {
			ignoredProperties.add("stuId");
		}else {
			studentProfile.setStuId(stuId.get());
		}
		studentProfile.setStuPhoneNumber(stuPhoneNumber);
		studentProfile.setParentName1(parentName1);
		studentProfile.setEmail1(email1);
		studentProfile.setParentPhoneNumber1(parentPhoneNumber1);
		studentProfile.setParentName2(parentName2);
		
		
		LOGGER.debug("searched student profile:" + studentProfile);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
	
		Example<StudentProfile> example = Example.of(studentProfile, exampleMatcher);
		LOGGER.debug("example student profile:" + example.toString());
		return stuProfileRepo.findAll(example);
		
	}

	public List<StudentProfile> getStudentProfileListByFiltersStr() {
		JSONObject obj = new JSONObject();
		obj.put("stuId", "1");
		obj.put("stuPhoneNumber", "514-123-4567");
		obj.put("parentName1", "parent101");
		obj.put("email1", "parent101@gmail.com");
		obj.put("parentPhoneNumber1", "514-321-7654");
		obj.put("parentName2", "parent201");
		
		
		String filterStr = obj.toString();
		JSONObject jobj = new JSONObject(filterStr);
		
		List<String> ignoredProperties = new ArrayList<>();
		String stuIdStr = jobj.getString("stuId").trim();
		String stuPhoneNumber = jobj.getString("stuPhoneNumber").trim();
		String parentName1 = jobj.getString("parentName1").trim();
		String email1 = jobj.getString("email1").trim();
		String parentPhoneNumber1 = jobj.getString("parentPhoneNumber1").trim();
		String parentName2 = jobj.getString("parentName2").trim();
		
		
		StudentProfile studentProfile = new StudentProfile();
		if (GlobalValidationUtils.isEmptyStr(stuIdStr)) {
			ignoredProperties.add("stuId");
		}else {
			studentProfile.setStuId(Integer.valueOf(stuIdStr));
		}
		
		if (GlobalValidationUtils.isEmptyStr(stuPhoneNumber)) {
			ignoredProperties.add("stuPhoneNumber");
		}else {
			studentProfile.setStuPhoneNumber(stuPhoneNumber);
		}
		
		if (GlobalValidationUtils.isEmptyStr(parentName1)) {
			ignoredProperties.add("parentName1");
		}else {
			studentProfile.setParentName1(parentName1);
		}
		
		if (GlobalValidationUtils.isEmptyStr(email1)) {
			ignoredProperties.add("email1");
		}else {
			studentProfile.setEmail1(email1);
		}
		
		if (GlobalValidationUtils.isEmptyStr(parentPhoneNumber1)) {
			ignoredProperties.add("parentPhoneNumber1");
		}else {
			studentProfile.setParentPhoneNumber1(parentPhoneNumber1);
		}
		
		if (GlobalValidationUtils.isEmptyStr(parentName2)) {
			ignoredProperties.add("parentName2");
		}else {
			studentProfile.setParentName2(parentName2);
		}
		
		LOGGER.debug("searched student profile:" + studentProfile);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
	
		Example<StudentProfile> example = Example.of(studentProfile, exampleMatcher);
		LOGGER.debug("example student profile:" + example.toString());
		return stuProfileRepo.findAll(example);
	}
	
	public ResponseEntity<StudentProfile> createStudentProfile(StudentProfile studentProfile){
		checkStudentAlreadyExistsException(studentProfile.getStudent().getStuId());
		
		LOGGER.debug("creating student profile:" + studentProfile);
		return new ResponseEntity<>(stuProfileRepo.save(studentProfile), HttpStatus.CREATED);
	}
	
	public ResponseEntity<StudentProfile> updateStudentProfile(StudentProfile studentProfile){
		checkStudentProfileNotFoundExcpetion(studentProfile.getStudent().getStuId());
		
		return new ResponseEntity<>(stuProfileRepo.save(studentProfile), HttpStatus.OK);
	}

	public ResponseEntity<String> deleteStudentProfile(StudentProfile studentProfile){
		checkStudentProfileNotFoundExcpetion(studentProfile.getStudent().getStuId());
		
		stuProfileRepo.delete(studentProfile);
		return ResponseEntity.ok("Delete student profile " + studentProfile + " successfully!");
	}
	
	public ResponseEntity<String> deleteStudentProfileById(Integer stuId){
		checkStudentProfileNotFoundExcpetion(stuId);
		
		StudentProfile studentProfile = getStudentProfileByStuId(stuId);
		stuProfileRepo.delete(studentProfile);
		return ResponseEntity.ok("Delete student profile " + stuId + " successfully!");
	}
	
	private void checkStudentProfileNotFoundExcpetion(Integer stuId) {
		if (! stuProfileRepo.existsById(stuId)) {
			throw new StudentProfileNotFoundException(stuId);
		}
	}
	
	
	private void checkStudentAlreadyExistsException(Integer stuId) {
		if (stuProfileRepo.existsById(stuId)) {
			throw new StudentProfileAlreadyExistsException(stuId);
		}
	}
	
	
}
