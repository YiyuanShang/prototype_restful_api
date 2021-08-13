package com.athensoft.edusys.academic.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.academic.entity.TopicRecord;

public interface TopicRecordRepository extends JpaRepository<TopicRecord, Integer>{
	Optional<TopicRecord> findByDeliveredSession_sessionId(Integer sessionId);
	
	boolean existsByDeliveredSession_sessionId(Integer sessionId);
}
