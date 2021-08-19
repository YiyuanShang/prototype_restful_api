package com.athensoft.edusys.academic.dao;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.athensoft.edusys.academic.entity.AssignmentRecord;
import com.athensoft.edusys.academic.entity.AssignmentType;

public interface AssignmentRecordRepository extends JpaRepository<AssignmentRecord, Integer>{
	@Query(value = "SELECT * FROM acd_asgmt_record WHERE session_id = :sessionId", nativeQuery = true)
	Optional<AssignmentRecord> findBySessionId(@Param("sessionId")Integer sessionId);

	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query(value = "INSERT INTO acd_asgmt_record (session_id) VALUES(:sessionId) ", nativeQuery = true)
	int createAssignmentRecord(@Param("sessionId") Integer sessionId);
	
}
