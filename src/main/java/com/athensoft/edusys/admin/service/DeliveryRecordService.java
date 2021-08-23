package com.athensoft.edusys.admin.service;

import org.springframework.stereotype.Service;

import com.athensoft.edusys.admin.dao.DeliveryRecordRepository;
import com.athensoft.edusys.admin.entity.DeliveryRecord;
import com.athensoft.edusys.error.exceptions.DeliveryRecordNotFoundException;

@Service
public class DeliveryRecordService {
	public final DeliveryRecordRepository deliveryRecordRepo;
	
	public DeliveryRecordService(DeliveryRecordRepository deliveryRecordRepo) {
		this.deliveryRecordRepo = deliveryRecordRepo;
	}
	

	public DeliveryRecord getDeliveryRecordBySessionId(Integer sessionId) {
		return deliveryRecordRepo.findByDeliveredSession_sessionId(sessionId).orElseThrow(() -> new DeliveryRecordNotFoundException(sessionId));
				
	}
}
