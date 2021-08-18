package com.athensoft.edusys.academic.service;

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

import com.athensoft.edusys.academic.dao.AssignmentRecordRepository;
import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.academic.entity.AssignmentRecord;
import com.athensoft.edusys.academic.entity.AssignmentType;
import com.athensoft.edusys.error.exceptions.AssignmentRecordAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.AssignmentRecordNotFoundException;
import com.athensoft.edusys.utils.validation.GlobalValidationUtils;

@Service
public class AssignmentRecordService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssignmentRecordService.class);
	private final AssignmentRecordRepository assgmtRecordRepo;
	
	private final AcademicSessionService sessionService;
	
	public AssignmentRecordService(AssignmentRecordRepository assgmtRecordRepo, AcademicSessionService sessionService) {
		this.assgmtRecordRepo = assgmtRecordRepo;
		this.sessionService = sessionService;
	}
	
	public List<AssignmentRecord> getAssignmentRecordList(){
		return assgmtRecordRepo.findAll();
	}
	
	public AssignmentRecord getAssignmentRecordById(Integer assgmtRecordId) {
		return assgmtRecordRepo.findById(assgmtRecordId).orElseThrow(() -> new AssignmentRecordNotFoundException());
	}
	
	public AssignmentRecord getAssignmentRecordBySessionId(Integer sessionId) {
		return assgmtRecordRepo.findBySessionId(sessionId).orElseThrow(() -> new AssignmentRecordNotFoundException(sessionId));
	}
	
	public List<AssignmentRecord> getgetAssignmentRecordListByFilters(
			Optional<Integer> assgmtRecordId,
			Optional<Integer> assgmtType,
			Optional<String> issueDateStr,
			Optional<String> dueDateStr) throws ParseException{
		List<String> ignoredProperties = new ArrayList<>();
		AssignmentRecord assgmtRecord = new AssignmentRecord();
		
		if(assgmtRecordId.isEmpty()) {
			ignoredProperties.add("assgmtRecordId");
		}else {
			assgmtRecord.setAssgmtRecordId(assgmtRecordId.get());
		}
		
		if(assgmtType.isEmpty()) {
			ignoredProperties.add("assgmtType");
		}else {
			assgmtRecord.setAssgmtType(AssignmentType.values()[Integer.valueOf(assgmtType.get())]);
		}
		
		if(issueDateStr.isEmpty()) {
			ignoredProperties.add("issueDate");
		}else {
			Date issueDate = new SimpleDateFormat("yyyy-MM-dd").parse(issueDateStr.get());
			assgmtRecord.setIssueDate(issueDate);
		}
		
		if(dueDateStr.isEmpty()) {
			ignoredProperties.add("dueDate");
		}else {
			Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateStr.get());
			assgmtRecord.setDueDate(dueDate);
		}
		
		LOGGER.debug("searched assgmtRecord:" + assgmtRecord);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
	
		Example<AssignmentRecord> example = Example.of(assgmtRecord, exampleMatcher);
		LOGGER.debug("example assgmtRecord:" + example.toString());
		return assgmtRecordRepo.findAll(example);
		
	}
	
	public List<AssignmentRecord> getgetAssignmentRecordListByFiltersStr() throws ParseException{
		JSONObject obj = new JSONObject();
		obj.put("assgmtRecordId", "1");
		obj.put("assgmtType", "");
		obj.put("issueDate", "");
		obj.put("dueDate", "");
		
		String filterStr = obj.toString();
		JSONObject jobj = new JSONObject(filterStr);
		
		List<String> ignoredProperties = new ArrayList<>();
		String assgmtRecordIdStr = jobj.getString("assgmtRecordId").trim();
		String assgmtTypeStr = jobj.getString("assgmtType").trim();
		String issueDateStr = jobj.getString("issueDate").trim();
		String dueDateStr = jobj.getString("dueDate").trim();
		
		AssignmentRecord assgmtRecord = new AssignmentRecord();
		if (GlobalValidationUtils.isEmptyStr(assgmtRecordIdStr)) {
			ignoredProperties.add("assgmtRecordId");
		}else {
			assgmtRecord.setAssgmtRecordId(Integer.valueOf(assgmtRecordIdStr));
		}
		
		if (GlobalValidationUtils.isEmptyStr(assgmtTypeStr)) {
			ignoredProperties.add("assgmtType");
		}else {
			AssignmentType assgmtType = AssignmentType.values()[Integer.valueOf(assgmtTypeStr)];
			assgmtRecord.setAssgmtType(assgmtType);
		}
		
		if (GlobalValidationUtils.isEmptyStr(issueDateStr)) {
			ignoredProperties.add("issueDate");
		}else {
			Date issueDate = new SimpleDateFormat("yyyy-MM-dd").parse(issueDateStr);
			assgmtRecord.setIssueDate(issueDate);
		}
		
		if (GlobalValidationUtils.isEmptyStr(dueDateStr)) {
			ignoredProperties.add("dueDate");
		}else {
			Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateStr);
			assgmtRecord.setDueDate(dueDate);
		}
		
		LOGGER.debug("searched assgmtRecord:" + assgmtRecord);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
	
		Example<AssignmentRecord> example = Example.of(assgmtRecord, exampleMatcher);
		LOGGER.debug("example assgmtRecord:" + example.toString());
		return assgmtRecordRepo.findAll(example);
	}
	
	public ResponseEntity<AssignmentRecord> createAssignmentRecord(Integer sessionId, AssignmentRecord assgmtRecord){
		checkAssignmentRecordAlreadyExistsException(sessionId, assgmtRecord.getAssgmtRecordId());
//		AcademicSession session = sessionService.getAcademicSessionById(sessionId);
//		session.setAssignment(assgmtRecord);
		LOGGER.debug("createAssignmentRecord sessionId:" + sessionId + "\t assgmtRecord:" + assgmtRecord);
		assgmtRecordRepo.createAssignmentRecord(assgmtRecord.getAssgmtType().ordinal(), assgmtRecord.getIssueDate(), assgmtRecord.getDueDate(), sessionId);
		AssignmentRecord createdAssignmentRecord = getAssignmentRecordBySessionId(sessionId);
		return new ResponseEntity<>(createdAssignmentRecord, HttpStatus.CREATED);
	}
	
	public ResponseEntity<AssignmentRecord> updateAssignmentRecord(AssignmentRecord assgmtRecord){
		if (!assgmtRecordRepo.existsById(assgmtRecord.getAssgmtRecordId())) {
			throw new AssignmentRecordNotFoundException(assgmtRecord);
		}
		
		return ResponseEntity.ok(assgmtRecordRepo.save(assgmtRecord));
	}
	
	private void checkAssignmentRecordAlreadyExistsException(Integer sessionId, Integer assgmtRecordId) {
		if(assgmtRecordId != null && assgmtRecordRepo.existsById(assgmtRecordId)) {
			throw new AssignmentRecordAlreadyExistsException(sessionId);
		}else if (assgmtRecordRepo.findBySessionId(sessionId).isPresent()) {
			throw new AssignmentRecordAlreadyExistsException(sessionId);
		}
	}

}
