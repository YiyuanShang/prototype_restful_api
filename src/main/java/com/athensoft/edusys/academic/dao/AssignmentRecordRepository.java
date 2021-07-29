package com.athensoft.edusys.academic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.academic.entity.AssignmentRecord;

public interface AssignmentRecordRepository extends JpaRepository<AssignmentRecord, Integer>{

}
