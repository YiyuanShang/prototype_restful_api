package com.athensoft.edusys.academic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.academic.entity.AcademicSession;

public interface AcademicSessionRepository extends JpaRepository<AcademicSession, Integer>{

}
