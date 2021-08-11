package com.athensoft.edusys.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.error.exceptions.SubjectAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.SubjectNotFoundException;
import com.athensoft.edusys.product.dao.SubjectRepository;
import com.athensoft.edusys.product.entity.Subject;

@Service
public class SubjectService {
	private final SubjectRepository subjectRepo;

	public SubjectService(SubjectRepository subjectRepo) {
		this.subjectRepo = subjectRepo;
	}

	public List<Subject> getSubjectList() {
		return subjectRepo.findAll();
	}
	
	public Subject getSubjectById(Integer subjectId) {
		return subjectRepo.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(subjectId));
	}
	
	public ResponseEntity<Subject> createSubject(Subject subject){
		checkSubjectAlreadyExistsException(subject.getSubjectId());
		return new ResponseEntity<>(subjectRepo.save(subject), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Subject> updateSubject(Subject subject){
		checkSubjectNotFoundException(subject.getSubjectId());
		return ResponseEntity.ok(subjectRepo.save(subject));
	}
	
	public ResponseEntity<Subject> deleteSubject(Subject subject){
		checkSubjectNotFoundException(subject.getSubjectId());
		subjectRepo.deleteById(subject.getSubjectId());
		return ResponseEntity.ok(subject);
	}
	
	public ResponseEntity<Subject> deleteSubjectById(Integer subjectId){
		checkSubjectNotFoundException(subjectId);
		Subject deletedSubject = subjectRepo.getById(subjectId);
		subjectRepo.deleteById(subjectId);
		return ResponseEntity.ok(deletedSubject);
	}
	
	public void checkSubjectAlreadyExistsException(Integer subjectId) {
		if(subjectRepo.existsById(subjectId)) {
			throw new SubjectAlreadyExistsException(subjectId);
		}
	}
	
	public void checkSubjectNotFoundException(Integer subjectId) {
		if(!subjectRepo.existsById(subjectId)) {
			throw new SubjectNotFoundException(subjectId);
		}
	}
}
