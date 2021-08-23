package com.athensoft.edusys.admin.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.admin.entity.DeliveryRecord;

public interface DeliveryRecordRepository extends JpaRepository<DeliveryRecord, Integer>{
	Optional<DeliveryRecord> findByDeliveredSession_sessionId(Integer sessionId);
}
