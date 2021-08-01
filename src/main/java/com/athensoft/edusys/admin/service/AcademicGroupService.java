package com.athensoft.edusys.admin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.athensoft.edusys.admin.dao.AcademicGroupRepository;
import com.athensoft.edusys.admin.entity.AcademicGroup;
import com.athensoft.edusys.admin.entity.GroupStatus;
import com.athensoft.edusys.admin.entity.GroupType;
import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.client.service.StudentService;
import com.athensoft.edusys.error.exceptions.AcademicGroupAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.AcademicGroupNotFoundException;
import com.athensoft.edusys.hr.entity.Employee;
import com.athensoft.edusys.hr.entity.Instructor;
import com.athensoft.edusys.hr.service.EmployeeService;
import com.athensoft.edusys.utils.validation.GlobalValidationUtils;

@Service
public class AcademicGroupService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AcademicGroupService.class);
	private final AcademicGroupRepository acdGroupRepo;
	
	private final StudentService stuService;
	private final EmployeeService empService;
	
	public AcademicGroupService(AcademicGroupRepository acdGroupRepo, StudentService stuService, EmployeeService empService) {
		this.acdGroupRepo = acdGroupRepo;
		this.stuService = stuService;
		this.empService = empService;
	}
	
	public List<AcademicGroup> getAcademicGroupList(){
		return acdGroupRepo.findAll();
	}
	
	public AcademicGroup getAcademicGroupById(Integer groupId) {
		return acdGroupRepo.findById(groupId).orElseThrow(() -> new AcademicGroupNotFoundException(groupId));
	}
	
	public List<AcademicGroup> getAcademicGroupListByFilters(
			Optional<Integer> groupId, 
			String groupNo, 
			Optional<Integer> groupStatus, 
			Optional<String> startDateStr, 
			Optional<String> endDateStr, 
			Optional<Integer> sessionNum, 
			Optional<Integer> groupType, 
			String groupName, 
			String groupDesc,
			Float price
			) throws ParseException{
		List<String> ignoredProperties = new ArrayList<>();
		AcademicGroup group = new AcademicGroup();
		if(groupId.isEmpty()) {
			ignoredProperties.add("groupId");
		}else {
			group.setGroupId(groupId.get());
		}
		
		if(groupStatus.isEmpty()) {
			ignoredProperties.add("groupStatus");
		}else {
			group.setGroupStatus(GroupStatus.values()[groupStatus.get()]);
		}
		
		if(startDateStr.isEmpty()) {
			ignoredProperties.add("startDate");
		}else {
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr.get());
			group.setStartDate(startDate);
		}
		
		if(endDateStr.isEmpty()) {
			ignoredProperties.add("endDate");
		}else {
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr.get());
			group.setEndDate(endDate);
		}
		
		if(sessionNum.isEmpty()) {
			ignoredProperties.add("sessionNum");
		}else {
			group.setSessionNum(sessionNum.get());
		}
		
		if(groupType.isEmpty()) {
			ignoredProperties.add("groupType");
		}else {
			group.setGroupType(GroupType.values()[groupType.get()]);
		}
		
		group.setGroupNo(groupNo);
		group.setGroupName(groupName);
		group.setGroupDesc(groupDesc);
		group.setPrice(price);
		
		LOGGER.debug("searched group:" + group);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
	
		Example<AcademicGroup> example = Example.of(group, exampleMatcher);
		LOGGER.debug("example group:" + example.toString());
		return acdGroupRepo.findAll(example);
		
	}

	public List<AcademicGroup> getAcademicGroupListByFiltersStr() throws ParseException {
		JSONObject obj = new JSONObject();
		obj.put("groupId", "1");
		obj.put("groupNo", "");
		obj.put("groupStatus", "");
		obj.put("startDate", "");
		obj.put("endDate", "");
		obj.put("sessionNum", "");
		obj.put("groupType", "2");
		obj.put("groupName", "");
		obj.put("groupDesc", "");
		obj.put("price", "");
		
		String filterStr = obj.toString();
		JSONObject jobj = new JSONObject(filterStr);
		
		List<String> ignoredProperties = new ArrayList<>();
		String groupIdStr = jobj.getString("groupId").trim();
		String groupNo = jobj.getString("groupNo").trim();
		
		String groupStatusStr = jobj.getString("groupStatus").trim();
		String startDateStr = jobj.getString("startDate").trim();
		String endDateStr = jobj.getString("endDate").trim();
		String sessionNum = jobj.getString("sessionNum").trim();
		String groupTypeStr = jobj.getString("groupType").trim();
		String groupName = jobj.getString("groupName").trim(); 
		String groupDesc = jobj.getString("groupDesc").trim();
		String price = jobj.getString("price").trim();
		
		AcademicGroup group = new AcademicGroup();
		
		if (GlobalValidationUtils.isEmptyStr(groupIdStr)) {
			ignoredProperties.add("groupId");
		}else {
			group.setGroupId(Integer.valueOf(groupIdStr));
		}
		
		if (GlobalValidationUtils.isEmptyStr(groupNo)) {
			ignoredProperties.add("groupNo");
		}else {
			group.setGroupNo(groupNo);
		}
		
		if (GlobalValidationUtils.isEmptyStr(groupStatusStr)) {
			ignoredProperties.add("groupStatus");
		}else {
			GroupStatus groupStatus = GroupStatus.values()[Integer.valueOf(groupStatusStr)];
			group.setGroupStatus(groupStatus);
		}
		
		if (GlobalValidationUtils.isEmptyStr(startDateStr)) {
			ignoredProperties.add("startDate");
		}else {
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
			group.setStartDate(startDate);
		}
		
		if (GlobalValidationUtils.isEmptyStr(endDateStr)) {
			ignoredProperties.add("endDate");
		}else {
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
			group.setEndDate(endDate);
		}
		
		if (GlobalValidationUtils.isEmptyStr(sessionNum)) {
			ignoredProperties.add("sessionNum");
		}else {
			group.setSessionNum(Integer.valueOf(sessionNum));
		}
		
		if (GlobalValidationUtils.isEmptyStr(groupTypeStr)) {
			ignoredProperties.add("groupType");
		}else {
			GroupType groupType = GroupType.values()[Integer.valueOf(groupTypeStr)];
			group.setGroupType(groupType);
		}
		
		if (GlobalValidationUtils.isEmptyStr(groupName)) {
			ignoredProperties.add("groupName");
		}else {
			group.setGroupName(groupName);
		}
		
		if (GlobalValidationUtils.isEmptyStr(groupDesc)) {
			ignoredProperties.add("groupDesc");
		}else {
			group.setGroupDesc(groupDesc);
		}
		
		if (GlobalValidationUtils.isEmptyStr(price)) {
			ignoredProperties.add("price");
		}else {
			group.setPrice(Float.valueOf(price));
		}
		
		LOGGER.debug("searched group:" + group);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
	
		Example<AcademicGroup> example = Example.of(group, exampleMatcher);
		LOGGER.debug("example group:" + example.toString());
		return acdGroupRepo.findAll(example);
	}
	
	public ResponseEntity<AcademicGroup> createAcademicGroup(AcademicGroup group) {
		if (acdGroupRepo.existsById(group.getGroupId())) {
			throw new AcademicGroupAlreadyExistsException(group);
		}
		return new ResponseEntity<>(acdGroupRepo.save(group), HttpStatus.CREATED);
	}
	
	public ResponseEntity<AcademicGroup> updateAcademicGroup(AcademicGroup group) {
		if (!acdGroupRepo.existsById(group.getGroupId())) {
			throw new AcademicGroupNotFoundException(group);
		}
		return ResponseEntity.ok(acdGroupRepo.save(group));
	}
	
	public ResponseEntity<AcademicGroup> deleteAcademicGroupById(Integer groupId) {
		if (!acdGroupRepo.existsById(groupId)) {
			throw new AcademicGroupNotFoundException(groupId);
		}
		AcademicGroup group = acdGroupRepo.findById(groupId).get();
		group.setGroupStatus(GroupStatus.CLOSED);
		
		return ResponseEntity.ok(acdGroupRepo.save(group));		
	}

	public ResponseEntity<AcademicGroup> deleteAcademicGroup(AcademicGroup group) {
		return deleteAcademicGroupById(group.getGroupId());
	}

	public AcademicGroup addStudentToAcademicGroup(Integer groupId, Integer stuId) {
		AcademicGroup group = acdGroupRepo.findById(groupId).orElseThrow(() -> new AcademicGroupNotFoundException(groupId));
		Student student = stuService.getStudentById(stuId);
		LOGGER.debug("academic group:" + group);
	
		LOGGER.debug("adding student " + student + " to registered student list");
		group.getRegStudents().add(student);

		LOGGER.debug("new registered student list:" + group.getRegStudents());
		return acdGroupRepo.save(group);
	}
	
	public AcademicGroup removeStudentFromAcademicGroup(Integer groupId, Integer stuId) {
		AcademicGroup group = acdGroupRepo.findById(groupId).orElseThrow(() -> new AcademicGroupNotFoundException(groupId));
		Student student = stuService.getStudentById(stuId);
		LOGGER.debug("academic group:" + group);
		
		LOGGER.debug("removing student " + student + " from registered student list");
		group.getRegStudents().remove(student);
		
		LOGGER.debug("new registered student list:" + group.getRegStudents());
		return acdGroupRepo.save(group);
	}

	public AcademicGroup addInstructorToAcademicGroup(Integer groupId, Integer empId) {
		AcademicGroup group = acdGroupRepo.findById(groupId).orElseThrow(() -> new AcademicGroupNotFoundException(groupId));
		Employee instructor = empService.getEmployeeById(empId);
		
		LOGGER.debug("academic group:" + group);
		
		LOGGER.debug("adding instructor " + instructor + " to registered instructor list");
		group.getRegInstructors().add(instructor);
		
		LOGGER.debug("new registered instructor list:" + group.getRegInstructors());
		return acdGroupRepo.save(group);
	}

	public AcademicGroup removeInstructorToAcademicGroup(Integer groupId, Integer empId) {
		AcademicGroup group = acdGroupRepo.findById(groupId).orElseThrow(() -> new AcademicGroupNotFoundException(groupId));
		Employee instructor = empService.getEmployeeById(empId);
		
		LOGGER.debug("academic group:" + group);
		
		LOGGER.debug("removing instructor " + instructor + " to registered instructor list");
		group.getRegInstructors().remove(instructor);
		
		LOGGER.debug("new registered instructor list:" + group.getRegInstructors());
		return acdGroupRepo.save(group);
	}
	

}
