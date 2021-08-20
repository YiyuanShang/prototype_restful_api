package com.athensoft.edusys.admin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import com.athensoft.edusys.admin.dao.CourseEntryRepository;
import com.athensoft.edusys.admin.dao.GroupScheduleRepository;
import com.athensoft.edusys.admin.entity.AcademicGroup;
import com.athensoft.edusys.admin.entity.CourseEntry;
import com.athensoft.edusys.admin.entity.CourseEntryId;
import com.athensoft.edusys.admin.entity.GroupSchedule;
import com.athensoft.edusys.admin.entity.GroupStatus;
import com.athensoft.edusys.admin.entity.GroupType;
import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.client.service.StudentService;
import com.athensoft.edusys.error.exceptions.AcademicGroupAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.AcademicGroupNotFoundException;
import com.athensoft.edusys.hr.entity.Admin;
import com.athensoft.edusys.hr.entity.Employee;
import com.athensoft.edusys.hr.entity.Instructor;
import com.athensoft.edusys.hr.service.EmployeeService;
import com.athensoft.edusys.product.entity.Course;
import com.athensoft.edusys.product.service.CourseService;
import com.athensoft.edusys.utils.validation.GlobalValidationUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AcademicGroupService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AcademicGroupService.class);
	private final AcademicGroupRepository acdGroupRepo;
	private final CourseEntryRepository courseEntryRepo;
	private final GroupScheduleRepository scheduleRepo;

	private final StudentService stuService;
	private final EmployeeService empService;
	private final CourseService courseService;

	public AcademicGroupService(AcademicGroupRepository acdGroupRepo, CourseEntryRepository courseEntryRepo, GroupScheduleRepository scheduleRepo, 
			StudentService stuService, EmployeeService empService, CourseService courseService) {
		this.acdGroupRepo = acdGroupRepo;
		this.courseEntryRepo = courseEntryRepo;
		this.scheduleRepo = scheduleRepo;
		this.stuService = stuService;
		this.empService = empService;
		this.courseService = courseService;
	}

	public List<AcademicGroup> getAcademicGroupList() {
		return acdGroupRepo.findAll();
	}

	public AcademicGroup getAcademicGroupById(Integer groupId) {
		return acdGroupRepo.findById(groupId).orElseThrow(() -> new AcademicGroupNotFoundException(groupId));
	}

	public List<AcademicGroup> getAcademicGroupListByFilters(Optional<Integer> groupId, String groupNo,
			Optional<Integer> groupStatus, Optional<String> startDateStr, Optional<String> endDateStr,
			Optional<Integer> sessionNum, Optional<Integer> groupType, String groupName, String groupDesc, Float price)
			throws ParseException {
		List<String> ignoredProperties = new ArrayList<>();
		AcademicGroup group = new AcademicGroup();
		if (groupId.isEmpty()) {
			ignoredProperties.add("groupId");
		} else {
			group.setGroupId(groupId.get());
		}

		if (groupStatus.isEmpty()) {
			ignoredProperties.add("groupStatus");
		} else {
			group.setGroupStatus(GroupStatus.values()[groupStatus.get()]);
		}

		if (startDateStr.isEmpty()) {
			ignoredProperties.add("startDate");
		} else {
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr.get());
			group.setStartDate(startDate);
		}

		if (endDateStr.isEmpty()) {
			ignoredProperties.add("endDate");
		} else {
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr.get());
			group.setEndDate(endDate);
		}

		if (sessionNum.isEmpty()) {
			ignoredProperties.add("sessionNum");
		} else {
			group.setSessionNum(sessionNum.get());
		}

		if (groupType.isEmpty()) {
			ignoredProperties.add("groupType");
		} else {
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
		} else {
			group.setGroupId(Integer.valueOf(groupIdStr));
		}

		if (GlobalValidationUtils.isEmptyStr(groupNo)) {
			ignoredProperties.add("groupNo");
		} else {
			group.setGroupNo(groupNo);
		}

		if (GlobalValidationUtils.isEmptyStr(groupStatusStr)) {
			ignoredProperties.add("groupStatus");
		} else {
			GroupStatus groupStatus = GroupStatus.values()[Integer.valueOf(groupStatusStr)];
			group.setGroupStatus(groupStatus);
		}

		if (GlobalValidationUtils.isEmptyStr(startDateStr)) {
			ignoredProperties.add("startDate");
		} else {
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
			group.setStartDate(startDate);
		}

		if (GlobalValidationUtils.isEmptyStr(endDateStr)) {
			ignoredProperties.add("endDate");
		} else {
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
			group.setEndDate(endDate);
		}

		if (GlobalValidationUtils.isEmptyStr(sessionNum)) {
			ignoredProperties.add("sessionNum");
		} else {
			group.setSessionNum(Integer.valueOf(sessionNum));
		}

		if (GlobalValidationUtils.isEmptyStr(groupTypeStr)) {
			ignoredProperties.add("groupType");
		} else {
			GroupType groupType = GroupType.values()[Integer.valueOf(groupTypeStr)];
			group.setGroupType(groupType);
		}

		if (GlobalValidationUtils.isEmptyStr(groupName)) {
			ignoredProperties.add("groupName");
		} else {
			group.setGroupName(groupName);
		}

		if (GlobalValidationUtils.isEmptyStr(groupDesc)) {
			ignoredProperties.add("groupDesc");
		} else {
			group.setGroupDesc(groupDesc);
		}

		if (GlobalValidationUtils.isEmptyStr(price)) {
			ignoredProperties.add("price");
		} else {
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
		checkAcademicGroupNotFoundException(group.getGroupId());
		return ResponseEntity.ok(acdGroupRepo.save(group));
	}

	public ResponseEntity<AcademicGroup> deleteAcademicGroupById(Integer groupId) {
		checkAcademicGroupNotFoundException(groupId);
		AcademicGroup group = acdGroupRepo.findById(groupId).get();
		group.setGroupStatus(GroupStatus.CLOSED);

		return ResponseEntity.ok(acdGroupRepo.save(group));
	}

	public ResponseEntity<AcademicGroup> deleteAcademicGroup(AcademicGroup group) {
		return deleteAcademicGroupById(group.getGroupId());
	}

	public AcademicGroup addStudentListToAcademicGroup(Integer groupId, List<Student> studentList) {
		AcademicGroup group = getAcademicGroupById(groupId);
		LOGGER.debug("academic group:" + group);
	
		LOGGER.debug("adding students " + studentList + " to registered student list");
		group.getRegStudents().addAll(studentList);
	
		LOGGER.debug("new registered student list:" + group.getRegStudents());
		return acdGroupRepo.save(group);
	}

	public AcademicGroup addStudentToAcademicGroup(Integer groupId, Integer stuId) {
		AcademicGroup group = getAcademicGroupById(groupId);
		Student student = stuService.getStudentById(stuId);
		LOGGER.debug("academic group:" + group);

		LOGGER.debug("adding student " + student + " to registered student list");
		group.getRegStudents().add(student);

		LOGGER.debug("new registered student list:" + group.getRegStudents());
		return acdGroupRepo.save(group);
	}

	public AcademicGroup addInstructorToAcademicGroup(Integer groupId, Integer empId) {
		AcademicGroup group = getAcademicGroupById(groupId);
		Instructor instructor = (Instructor) empService.getEmployeeById(empId);

		LOGGER.debug("academic group:" + group);

		LOGGER.debug("adding instructor " + instructor + " to registered instructor list");
		group.getRegInstructors().add(instructor);

		LOGGER.debug("new registered instructor list:" + group.getRegInstructors());
		return acdGroupRepo.save(group);
	}

	public AcademicGroup addCourseListToAcademicGroup(Integer groupId, List<Map<String, Object>> courseEntryList) {
		AcademicGroup group = getAcademicGroupById(groupId);

		LOGGER.debug("academic group:" + group);
		
		ObjectMapper mapper = new ObjectMapper();
		for (Map<String, Object> courseEntryMap : courseEntryList) {
			
			
			Boolean isPrimary = mapper.convertValue(courseEntryMap.get("isPrimary"), Boolean.class);
			Course course = mapper.convertValue(courseEntryMap.get("course"), Course.class);
			
			CourseEntry courseEntry = new CourseEntry(course, group, isPrimary);
			
			LOGGER.debug("adding course " + course + " to course list, isPrimary:" + isPrimary);
			courseEntryRepo.save(courseEntry);
			group.getCourseEntries().add(courseEntry);
		}

		LOGGER.debug("new course list:" + group.getCourseEntries());
		return acdGroupRepo.save(group);

	}

	public AcademicGroup addCourseToAcademicGroup(Integer groupId, Integer courseId, Boolean isPrimary) {
		AcademicGroup group = getAcademicGroupById(groupId);
		Course course = courseService.getCourseById(courseId);

		LOGGER.debug("academic group:" + group);
		LOGGER.debug("adding course " + course + " to course list, isPrimary:" + isPrimary);
		CourseEntry courseEntry = new CourseEntry(course, group, isPrimary);
		
		courseEntryRepo.save(courseEntry);
		LOGGER.debug("adding course entry to group course entries");
		group.getCourseEntries().add(courseEntry);

		LOGGER.debug("new course list:" + group.getCourseEntries());
		return acdGroupRepo.save(group);
	}
	
	public AcademicGroup addAdminToAcademicGroup(Integer groupId, Integer empId) {
		AcademicGroup group = getAcademicGroupById(groupId);
		Admin admin = (Admin) empService.getEmployeeById(empId);

		LOGGER.debug("academic group:" + group);

		LOGGER.debug("adding admin " + admin + " to responsible admin list");
		group.getRegAdmins().add(admin);

		LOGGER.debug("new responsible admin list:" + group.getRegAdmins());
		return acdGroupRepo.save(group);
	}

	public AcademicGroup addScheduleToAcademicGroup(Integer groupId, GroupSchedule groupSchedule) {
		AcademicGroup group = getAcademicGroupById(groupId);
		List<GroupSchedule> groupSchedules = group.getGroupSchedules();
		scheduleRepo.save(groupSchedule);
		return null;
	}

	public AcademicGroup removeStudentFromAcademicGroup(Integer groupId, Integer stuId) {
		AcademicGroup group = getAcademicGroupById(groupId);
		Student student = stuService.getStudentById(stuId);
		LOGGER.debug("academic group:" + group);

		LOGGER.debug("removing student " + student + " from registered student list");
		group.getRegStudents().remove(student);

		LOGGER.debug("new registered student list:" + group.getRegStudents());
		return acdGroupRepo.save(group);
	}

	public AcademicGroup removeInstructorToAcademicGroup(Integer groupId, Integer empId) {
		AcademicGroup group = getAcademicGroupById(groupId);
		Instructor instructor = (Instructor) empService.getEmployeeById(empId);

		LOGGER.debug("academic group:" + group);

		LOGGER.debug("removing instructor " + instructor + " to registered instructor list");
		group.getRegInstructors().remove(instructor);

		LOGGER.debug("new registered instructor list:" + group.getRegInstructors());
		return acdGroupRepo.save(group);
	}

	public AcademicGroup removeCourseListFromAcademicGroup(Integer groupId, List<Course> courseList) {
		AcademicGroup group = getAcademicGroupById(groupId);

		LOGGER.debug("academic group:" + group);
		LOGGER.debug("removing courses " + courseList + " from course list");
		
		List<CourseEntryId> courseEntryIdList = new ArrayList<>();
		for (Course course : courseList) {
			CourseEntryId courseEntryId = new CourseEntryId(groupId, course.getCourseId());
			courseEntryIdList.add(courseEntryId);
		}
		// remove all course list elements from collection
		group.getCourseEntries().removeIf(courseEntry -> courseEntryIdList.contains(courseEntry.getCourseEntryId()));
				
		LOGGER.debug("new course list:" + group.getCourseEntries());
		courseEntryRepo.deleteAllByIdInBatch(courseEntryIdList);
		return acdGroupRepo.save(group);

	}

	public AcademicGroup removeCourseFromAcademicGroup(Integer groupId, Integer courseId) {
		AcademicGroup group = getAcademicGroupById(groupId);

		LOGGER.debug("academic group:" + group);
		LOGGER.debug("old course list:" + group.getCourseEntries());
		LOGGER.debug("removing course " + courseId + " to course list");
		// remove course entry with specific course Id from collection
		group.getCourseEntries().removeIf(courseEntry -> courseEntry.getCourseEntryId().getCourseId() == courseId);

		LOGGER.debug("new course list:" + group.getCourseEntries());
		courseEntryRepo.deleteById(new CourseEntryId(groupId, courseId));
		return acdGroupRepo.save(group);

	}
	

	private void checkAcademicGroupNotFoundException(Integer groupId) {
		if (!acdGroupRepo.existsById(groupId)) {
			throw new AcademicGroupNotFoundException(groupId);
		}
	}

}
