package com.athensoft.edusys.client.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.client.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{
	Optional<Student> findByStuNo(String stuNo);

}
