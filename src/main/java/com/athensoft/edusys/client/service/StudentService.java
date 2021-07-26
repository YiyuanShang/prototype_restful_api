package com.athensoft.edusys.client.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.client.dao.StudentProfileRepository;
import com.athensoft.edusys.client.dao.StudentRepository;
import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.client.entity.StudentStatus;
import com.athensoft.edusys.client.entity.StudentType;
import com.athensoft.edusys.error.exceptions.StudentAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.StudentNotFoundException;
import com.athensoft.edusys.utils.validation.GlobalValidationUtils;



@Service
public class StudentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	private final StudentRepository studentRepo;
	private final StudentProfileRepository stuProfileRepo;
	
	
	public StudentService(StudentRepository studentRepo, StudentProfileRepository stuProfileRepo) {
		this.studentRepo = studentRepo;
		this.stuProfileRepo = stuProfileRepo;
	}
	
	public List<Student> getStudentList(){
		return studentRepo.findAll();
	}
	
	public Student getStudentById(int stuId) {
		return studentRepo.findById(stuId)
				.orElseThrow(() -> new StudentNotFoundException(stuId));
	}
	
	public Student getStudentByStuNo(String stuNo) {
		return studentRepo.findByStuNo(stuNo)
				.orElseThrow(() -> new StudentNotFoundException(stuNo));
	}
	
	public List<Student> getStudentListByName(String stuFirstName, String stuLastName) {
		Student student = new Student();
		
		student.setStuFirstName(stuFirstName);
		student.setStuLastName(stuLastName);
		
		LOGGER.debug("searched student:" + student);
		return studentRepo.findAll(Example.of(student));
	}

	public List<Student> getStudentListByFilters(
			Optional<Integer> stuId, 
			String stuNo, 
			String stuFirstName,
			String stuLastName, 
			String email, 
			Optional<Boolean> isMember, 
			Optional<String> regDateStr,
			Optional<Integer> stuType) throws ParseException {
		
		List<String> ignoredProperties = new ArrayList<>();
		Student student = new Student();
		if(stuId.isEmpty()) {
			ignoredProperties.add("stuId");
		}else {
			student.setStuId(stuId.get());
		}
		if(isMember.isEmpty()) {
			ignoredProperties.add("isMember");
		}else {
			student.setIsMember(isMember.get());
		}
		if(stuType.isEmpty()) {
			ignoredProperties.add("stuType");
		}else {
			student.setStuType(StudentType.values()[stuType.get()]);
		}
		if(regDateStr.isEmpty()) {
			ignoredProperties.add("regDate");
		}else {
			Date regDate = new SimpleDateFormat("yyyy-MM-dd").parse(regDateStr.get());
			LOGGER.debug("regDate:" + regDate.toString());
			student.setRegDate(regDate);
		}
		
		student.setStuNo(stuNo);
		student.setStuFirstName(stuFirstName);
		student.setStuLastName(stuLastName);
		student.setEmail(email);
		
		
		LOGGER.debug("searched student:" + student);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
	
		Example<Student> example = Example.of(student, exampleMatcher);
		LOGGER.debug("example student:" + example.toString());
		return studentRepo.findAll(example);
	}

	public List<Student> getStudentListByFiltersStr() throws JSONException, ParseException{
		JSONObject obj = new JSONObject();
		obj.put("stuId", "1");
		obj.put("stuNo", "stu001");
		obj.put("stuFirstName", "Peter");
		obj.put("stuLastName", "Zhang");
		obj.put("email", "peter@gmail.com");
		obj.put("isMember", "true");
		obj.put("regDate", "2020-06-24");
		obj.put("stuType", "3");
		String filterStr = obj.toString();
		JSONObject jobj = new JSONObject(filterStr);
		
		List<String> ignoredProperties = new ArrayList<>();
		String stuIdStr = jobj.getString("stuId").trim();
		String stuNo = jobj.getString("stuNo").trim();
		String stuFirstName = jobj.getString("stuFirstName").trim();
		String stuLastName = jobj.getString("stuLastName").trim();
		String email = jobj.getString("email").trim();
		String isMemberStr = jobj.getString("isMember").trim();
		String regDateStr = jobj.getString("regDate").trim();
		String stuTypeStr = jobj.getString("stuType").trim();
		
		Student student = new Student();
		if (GlobalValidationUtils.isEmptyStr(stuIdStr)) {
			ignoredProperties.add("stuId");
		}else {
			student.setStuId(Integer.valueOf(stuIdStr));
		}
		
		if (GlobalValidationUtils.isEmptyStr(stuNo)) {
			ignoredProperties.add("stuNo");
		}else {
			student.setStuNo(stuNo);
		}
		
		if (GlobalValidationUtils.isEmptyStr(stuFirstName)) {
			ignoredProperties.add("stuFirstName");
		}else {
			student.setStuFirstName(stuFirstName);
		}
		
		if (GlobalValidationUtils.isEmptyStr(stuFirstName)) {
			ignoredProperties.add("stuFirstName");
		}else {
			student.setStuFirstName(stuFirstName);
		}
		
		if (GlobalValidationUtils.isEmptyStr(stuLastName)) {
			ignoredProperties.add("stuLastName");
		}else {
			student.setStuLastName(stuLastName);
		}
		
		if (GlobalValidationUtils.isEmptyStr(email)) {
			ignoredProperties.add("email");
		}else {
			student.setEmail(email);
		}
	
		if (GlobalValidationUtils.isEmptyStr(isMemberStr)) {
			ignoredProperties.add("isMember");
		}else {
			student.setIsMember(Boolean.valueOf(isMemberStr));
		}
		
		if (GlobalValidationUtils.isEmptyStr(regDateStr)) {
			ignoredProperties.add("regDate");
		}else {
			Date regDate = new SimpleDateFormat("yyyy-MM-dd").parse(regDateStr);
			student.setRegDate(regDate);
		}
		
		if (GlobalValidationUtils.isEmptyStr(stuTypeStr)) {
			ignoredProperties.add("stuType");
		}else {
			StudentType stuType = StudentType.values()[Integer.valueOf(stuTypeStr)];
			student.setStuType(stuType);
		}
		
		LOGGER.debug("searched student:" + student);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
		Example<Student> example = Example.of(student, exampleMatcher);
		LOGGER.debug("example student:" + example.toString());
		return studentRepo.findAll(example);
	}

	public ResponseEntity<Student> createStudent(Student student) {
		// check whether student already exists by student number
		if (studentRepo.findByStuNo(student.getStuNo()).isPresent()) {
			throw new StudentAlreadyExistsException(student);
		}
		LOGGER.debug("creating student:" + student);
		return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Student> updateStudent(Student student){
		checkStudentNotFoundException(student);
		LOGGER.debug("updating student:" + student);
		return ResponseEntity.ok(studentRepo.save(student));
	}
	
	public ResponseEntity<Student> deleteStudent(Student student) {
		LOGGER.debug("deleting student:" + student);
		int stuId = student.getStuId();
		return deleteStudentById(stuId);
	}
	
	public ResponseEntity<Student> deleteStudentById(int stuId) {
		LOGGER.debug("deleting student id:" + stuId);
		Student student = studentRepo.findById(stuId).orElseThrow(() -> new StudentNotFoundException(stuId));
		student.setStuStatus(StudentStatus.INACTIVE);
		return ResponseEntity.ok(studentRepo.save(student));
	}

	private void checkStudentNotFoundException(Student student) {
		if (!studentRepo.existsById(student.getStuId())) {
			throw new StudentNotFoundException(student);
		}
	}
	
	private void checkStudentNotFoundException(int stuId) {
		if (!studentRepo.existsById(stuId)) {
			throw new StudentNotFoundException(stuId);
		}
	}
	
	
	
	
	
	
	

}
