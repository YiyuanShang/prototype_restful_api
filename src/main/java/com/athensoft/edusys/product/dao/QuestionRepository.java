package com.athensoft.edusys.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.product.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
