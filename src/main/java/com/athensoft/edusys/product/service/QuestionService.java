package com.athensoft.edusys.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.error.exceptions.QuestionAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.QuestionNotFoundException;
import com.athensoft.edusys.product.dao.QuestionRepository;
import com.athensoft.edusys.product.entity.Question;

@Service
public class QuestionService {
	private final QuestionRepository questionRepo;
	
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public List<Question> getQuestionList(){
		return questionRepo.findAll();
	}
	
	public Question getQuestionById(Integer questionId) {
		return questionRepo.findById(questionId).orElseThrow(() -> new QuestionNotFoundException(questionId));
	}

	
	public ResponseEntity<Question> createQuestion(Question question){
		checkQuestionAlreadyExistsException(question.getQuestionId());
		return new ResponseEntity<>(questionRepo.save(question), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Question> updateQuestion(Question question){
		checkQuestionNotFoundException(question.getQuestionId());
		return ResponseEntity.ok(questionRepo.save(question));
	}
	
	public ResponseEntity<Question> deleteQuestionById(Integer questionId){
		Question deletedQuestion = getQuestionById(questionId);
		questionRepo.deleteById(questionId);
		return ResponseEntity.ok(deletedQuestion);
		
	}
	
	private void checkQuestionAlreadyExistsException(Integer questionId) {
		if (questionId != null && questionRepo.existsById(questionId)) {
			throw new QuestionAlreadyExistsException(questionId);
		}
	}
	
	private void checkQuestionNotFoundException(Integer questionId) {
		if (questionId == null || !questionRepo.existsById(questionId)) {
			throw new QuestionNotFoundException(questionId);
		}
	}
}
