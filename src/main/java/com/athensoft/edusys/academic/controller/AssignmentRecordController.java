package com.athensoft.edusys.academic.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.academic.entity.AssignmentRecord;
import com.athensoft.edusys.academic.service.AssignmentRecordService;

@RestController
@RequestMapping("/edusys/academic")
public class AssignmentRecordController {
	private final AssignmentRecordService assgmtRecordService;
	
	public AssignmentRecordController(AssignmentRecordService assgmtRecordService) {
		this.assgmtRecordService = assgmtRecordService;
	}
	
	@GetMapping("/assgmtRecords")
	public ResponseEntity<List<AssignmentRecord>> getDataList(){
		return ResponseEntity.ok(assgmtRecordService.getAssignmentRecordList());
	}
	
	@GetMapping("/assgmtRecords/{assgmtRecordId}")
	public ResponseEntity<AssignmentRecord> getDataById(@PathVariable Integer assgmtRecordId){
		return ResponseEntity.ok(assgmtRecordService.getAssignmentRecordById(assgmtRecordId));
	}
	
	@GetMapping("/assgmtRecords/filters")
	public ResponseEntity<List<AssignmentRecord>> getDataListByFilters(
			Optional<Integer> assgmtRecordId,
			Optional<Integer> assgmtType,
			Optional<String> issueDate,
			Optional<String> dueDate) throws ParseException{
		return ResponseEntity.ok(assgmtRecordService.getgetAssignmentRecordListByFilters(assgmtRecordId, assgmtType, issueDate, dueDate));
	}
	
	@PostMapping("/assgmtRecords")
	public ResponseEntity<AssignmentRecord> createAssignmentRecord(@RequestBody AssignmentRecord assgmtRecord){
		return assgmtRecordService.createAssignmentRecord(assgmtRecord);
	}
	
	@PutMapping("/assgmtRecords")
	public ResponseEntity<AssignmentRecord> updateAssignmentRecord(@RequestBody AssignmentRecord assgmtRecord){
		return assgmtRecordService.updateAssignmentRecord(assgmtRecord);
	}
}
