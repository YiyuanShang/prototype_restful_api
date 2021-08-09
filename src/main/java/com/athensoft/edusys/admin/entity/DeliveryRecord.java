package com.athensoft.edusys.admin.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.hr.entity.Employee;
import com.athensoft.edusys.hr.entity.Instructor;

//@Embeddable
//@Entity
//@Table(name = "admin_delivery_record")
public class DeliveryRecord {
//	@EmbeddedId 
//	DeliveryRecordId deliveryRecordId;
//	
//	@ElementCollection(targetClass = DeliveryRecordEntry.class)
////	@JoinColumn(name = "emp_id")
////	@Column(name = "emp_id")
//	private List<DeliveryRecordEntry> deliveryRecordEntries = new ArrayList<>();
//
////	@ManyToOne(targetEntity = AcademicSession.class)
////	@JoinColumns({
////		  @JoinColumn(name = "session_id"),
////		  @JoinColumn(name = "emp_id")})
////	@Column(name = "session_id")
////	@ManyToOne
////	@MapsId("sessionId")
////	@JoinColumn(name = "session_id")
////	private AcademicSession deliveredSession;
//	
//	public DeliveryRecord() {}
//
//	public DeliveryRecord(DeliveryRecordId deliveryRecordId, List<DeliveryRecordEntry> deliveryRecordEntries) {
//		super();
//		this.deliveryRecordId = deliveryRecordId;
//		this.deliveryRecordEntries = deliveryRecordEntries;
////		this.deliveredSession = deliveredSession;
//	}
//
//	public DeliveryRecordId getDeliveryRecordId() {
//		return deliveryRecordId;
//	}
//
//	public void setDeliveryRecordId(DeliveryRecordId deliveryRecordId) {
//		this.deliveryRecordId = deliveryRecordId;
//	}
//
//	public List<DeliveryRecordEntry> getDeliveryRecordEntries() {
//		return deliveryRecordEntries;
//	}
//
//	public void setDeliveryRecordEntries(List<DeliveryRecordEntry> deliveryRecordEntries) {
//		this.deliveryRecordEntries = deliveryRecordEntries;
//	}
//
////	public AcademicSession getDeliveredSession() {
////		return deliveredSession;
////	}
////
////	public void setDeliveredSession(AcademicSession deliveredSession) {
////		this.deliveredSession = deliveredSession;
////	}
//	
//	
//	
}


