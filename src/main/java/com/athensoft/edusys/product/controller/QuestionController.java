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

import com.athensoft.edusys.product.entity.Question;
import com.athensoft.edusys.product.service.QuestionService;

@RestController
@RequestMapping("/edusys/product")
public class QuestionController {
	private final QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping("/questions")
	public ResponseEntity<List<Question>> getDataListQuestion(){
		return ResponseEntity.ok(questionService.getQuestionList());
	}

	@GetMapping("/questions/{questionId}")
	public ResponseEntity<Question> getDataListQuestion(@PathVariable Integer questionId){
		return ResponseEntity.ok(questionService.getQuestionById(questionId));
	}
	
	@PostMapping("/questions")
	public ResponseEntity<Question> createQuestion(@RequestBody Question question){
		return questionService.createQuestion(question);
	}
	
	@PutMapping("/questions")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return questionService.updateQuestion(question);
	}
	
	@DeleteMapping("/questions/{questionId}")
	public ResponseEntity<Question> deleteQuestionById(@PathVariable Integer questionId){
		return questionService.deleteQuestionById(questionId);
	}
}
