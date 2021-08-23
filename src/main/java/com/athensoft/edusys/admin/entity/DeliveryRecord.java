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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.academic.entity.TopicRecordEntry;
import com.athensoft.edusys.hr.entity.Employee;
import com.athensoft.edusys.hr.entity.Instructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
@Entity
@Table(name = "admin_delivery_record")
public class DeliveryRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_record_id")
	private Integer deliveryRecordId = -1;
	
	@OneToMany(targetEntity = DeliveryRecordEntry.class)
	@JoinColumn(name = "delivery_record_id")
	private List<DeliveryRecordEntry> deliveryRecordEntries = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "session_id")
	@JsonBackReference
	AcademicSession deliveredSession;
	
	public DeliveryRecord() {}

	public DeliveryRecord(Integer deliveryRecordId, List<DeliveryRecordEntry> deliveryRecordEntries,
			AcademicSession deliveredSession) {
		super();
		this.deliveryRecordId = deliveryRecordId;
		this.deliveryRecordEntries = deliveryRecordEntries;
		this.deliveredSession = deliveredSession;
	}

	public Integer getDeliveryRecordId() {
		return deliveryRecordId;
	}

	public void setDeliveryRecordId(Integer deliveryRecordId) {
		this.deliveryRecordId = deliveryRecordId;
	}

	public List<DeliveryRecordEntry> getDeliveryRecordEntries() {
		return deliveryRecordEntries;
	}

	public void setDeliveryRecordEntries(List<DeliveryRecordEntry> deliveryRecordEntries) {
		this.deliveryRecordEntries = deliveryRecordEntries;
	}

	public AcademicSession getDeliveredSession() {
		return deliveredSession;
	}

	public void setDeliveredSession(AcademicSession deliveredSession) {
		this.deliveredSession = deliveredSession;
	}

	
}


