package com.athensoft.edusys.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.athensoft.edusys.admin.entity.DeliveryRecordEntry;

public interface DeliveryRecordEntryRepository extends JpaRepository<DeliveryRecordEntry, Integer>{
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query(value = "INSERT INTO admin_delivery_record_entry (admin_delivery_record_entry, emp_id) VALUES(:deliveryRecordId, empId) ", nativeQuery = true)
	int createDeliveryRecordEntry(@Param("deliveryRecordId") Integer deliveryRecordId,
			@Param("empId") Integer empId);
}
