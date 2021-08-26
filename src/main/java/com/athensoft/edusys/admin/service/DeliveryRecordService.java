package com.athensoft.edusys.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.academic.service.AcademicSessionService;
import com.athensoft.edusys.admin.dao.DeliveryRecordEntryRepository;
import com.athensoft.edusys.admin.dao.DeliveryRecordRepository;
import com.athensoft.edusys.admin.entity.DeliveryRecord;
import com.athensoft.edusys.admin.entity.DeliveryRecordEntry;
import com.athensoft.edusys.error.exceptions.DeliveryRecordAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.DeliveryRecordEntryAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.DeliveryRecordNotFoundException;



@Service
public class DeliveryRecordService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryRecordService.class);
	private final DeliveryRecordRepository deliveryRecordRepo;
	private final DeliveryRecordEntryRepository deliveryRecordEntryRepo;
	
	public DeliveryRecordService(DeliveryRecordRepository deliveryRecordRepo,DeliveryRecordEntryRepository deliveryRecordEntryRepo) {
		this.deliveryRecordRepo = deliveryRecordRepo;
		this.deliveryRecordEntryRepo = deliveryRecordEntryRepo;
	}
	
	public DeliveryRecord getDeliveryRecordBySessionId(Integer sessionId) {
		return deliveryRecordRepo.findByDeliveredSession_sessionId(sessionId).orElseThrow(() -> new DeliveryRecordNotFoundException(sessionId));
				
	}
	
	public DeliveryRecord createDeliveryRecord(AcademicSession session) {
		checkDeliveryRecordAlreadyExistsException(session.getSessionId());
		
		DeliveryRecord deliveryRecord = new DeliveryRecord();
		deliveryRecord.setDeliveredSession(session);
		
		deliveryRecord = deliveryRecordRepo.save(deliveryRecord);
		
		return deliveryRecord;
	}
	
	public DeliveryRecordEntry createDeliveryRecordEntry(DeliveryRecordEntry deliveryRecordEntry) {
		checkDeliveryRecordEntryAlreadyExistsException(deliveryRecordEntry.getEntryId());
//		deliveryRecordEntryRepo.createDeliveryRecordEntry(deliveryRecordEntry.getDeliveryRecordId(), deliveryRecordEntry.getEmpId());
		DeliveryRecordEntry entry = deliveryRecordEntryRepo.save(deliveryRecordEntry);
		LOGGER.debug("created deliveryRecordEntry:" + entry);
		return entry;
	}
	
	


	private void checkDeliveryRecordAlreadyExistsException(Integer sessionId) {
		if (deliveryRecordRepo.existsByDeliveredSession_sessionId(sessionId)) {
			throw new DeliveryRecordAlreadyExistsException(sessionId);
		}
	}
	
	private void checkDeliveryRecordEntryAlreadyExistsException(Integer entryId) {
		if (entryId != null && deliveryRecordEntryRepo.existsById(entryId)) {
			throw new DeliveryRecordEntryAlreadyExistsException(entryId);
		}
	}
}
