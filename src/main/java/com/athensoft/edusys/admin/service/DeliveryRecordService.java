package com.athensoft.edusys.admin.service;

import org.springframework.stereotype.Service;

import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.admin.dao.DeliveryRecordRepository;
import com.athensoft.edusys.admin.entity.DeliveryRecord;
import com.athensoft.edusys.error.exceptions.DeliveryRecordAlreadyExistsException;
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
	
	public DeliveryRecord createDeliveryRecord(AcademicSession session) {
		checkTopicAlreadyExistsException(session.getSessionId());
		
		DeliveryRecord deliveryRecord = new DeliveryRecord();
		deliveryRecord.setDeliveredSession(session);
		
		deliveryRecord = deliveryRecordRepo.save(deliveryRecord);
		
		return deliveryRecord;
	}
	
	private void checkTopicAlreadyExistsException(Integer sessionId) {
		if (deliveryRecordRepo.existsByDeliveredSession_sessionId(sessionId)) {
			throw new DeliveryRecordAlreadyExistsException(sessionId);
		}
	}
}
