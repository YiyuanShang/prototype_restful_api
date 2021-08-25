package com.athensoft.edusys.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

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


}
