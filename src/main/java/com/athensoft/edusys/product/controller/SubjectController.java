package com.athensoft.edusys.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.product.entity.Subject;
import com.athensoft.edusys.product.service.SubjectService;

@RestController
@RequestMapping("/edusys/product")
public class SubjectController {
	private final SubjectService subjectService;
	
	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	@GetMapping("/subjects")
	public ResponseEntity<List<Subject>> getDataListSubject(){
		return ResponseEntity.ok(subjectService.getSubjectList());
	}
	
	@GetMapping("/subjects/{subjectId}")
	public ResponseEntity<Subject> getDataSubjectById(@PathVariable Integer subjectId){
		return ResponseEntity.ok(subjectService.getSubjectById(subjectId));
	}
	
	@PostMapping("/subjects")
	public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
		return subjectService.createSubject(subject);
	}
	
	@PutMapping("/subjects")
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
		return subjectService.updateSubject(subject);
	}
	
	@DeleteMapping("/subjects")
	public ResponseEntity<Subject> deleteSubject(@RequestBody Subject subject){
		return subjectService.deleteSubject(subject);
	}
	
	@DeleteMapping("/subjects/{subjectId}")
	public ResponseEntity<Subject> deleteSubjectById(@PathVariable Integer subjectId){
		return subjectService.deleteSubjectById(subjectId);
	}

}
