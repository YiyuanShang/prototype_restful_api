package com.athensoft.edusys.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.client.dao.StudentProfileRepository;
import com.athensoft.edusys.client.entity.StudentProfile;
import com.athensoft.edusys.error.exceptions.StudentProfileNotFoundException;
import com.athensoft.edusys.utils.validation.GlobalValidationUtils;

@Service
public class StudentProfileService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentProfileService.class);
	private final StudentProfileRepository stuProfileRepo;
	
	public StudentProfileService(StudentProfileRepository stuProfileRepo) {
		this.stuProfileRepo = stuProfileRepo;
	}
	
	public List<StudentProfile> getStudentProfileList(){
		return stuProfileRepo.findAll();
	}

	public StudentProfile getStudentProfileById(int stuId) {
		return stuProfileRepo.findById(stuId)
				.orElseThrow(() -> new StudentProfileNotFoundException(stuId));
	}

	public List<StudentProfile> getStudentProfileListByFilters(
			Optional<Integer> stuId, 
			String parentName1, 
			String parentName2,
			String email1) {
		
		List<String> ignoredProperties = new ArrayList<>();
		StudentProfile studentProfile = new StudentProfile();
		if(stuId.isEmpty()) {
			ignoredProperties.add("stuId");
		}else {
			studentProfile.setStuId(stuId.get());
		}
		studentProfile.setParentName1(parentName1);
		studentProfile.setParentName2(parentName2);
		studentProfile.setEmail1(email1);
		
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
		obj.put("parentName1", "parent101");
		obj.put("parentName2", "parent201");
		obj.put("email1", "parent101@gmail.com");
		
		String filterStr = obj.toString();
		JSONObject jobj = new JSONObject(filterStr);
		
		List<String> ignoredProperties = new ArrayList<>();
		String stuIdStr = jobj.getString("stuId").trim();
		String parentName1 = jobj.getString("parentName1").trim();
		String parentName2 = jobj.getString("parentName2").trim();
		String email1 = jobj.getString("email1").trim();
		
		StudentProfile studentProfile = new StudentProfile();
		if (GlobalValidationUtils.isEmptyStr(stuIdStr)) {
			ignoredProperties.add("stuId");
		}else {
			studentProfile.setStuId(Integer.valueOf(stuIdStr));
		}
		
		if (GlobalValidationUtils.isEmptyStr(parentName1)) {
			ignoredProperties.add("parentName1");
		}else {
			studentProfile.setParentName1(parentName1);
		}
		
		if (GlobalValidationUtils.isEmptyStr(parentName2)) {
			ignoredProperties.add("parentName2");
		}else {
			studentProfile.setParentName2(parentName2);
		}
		
		if (GlobalValidationUtils.isEmptyStr(email1)) {
			ignoredProperties.add("email1");
		}else {
			studentProfile.setEmail1(email1);
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

}
