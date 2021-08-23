package com.athensoft.edusys.admin.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.hr.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "admin_delivery_record_entry")
public class DeliveryRecordEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entryId = -1;
	
	@Column(name = "delivery_record_id", nullable = false)
	@JsonIgnore
	private Integer deliveryRecordId;
	
	@Column(nullable = false)
	private Integer empId;

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public Integer getDeliveryRecordId() {
		return deliveryRecordId;
	}

	public void setDeliveryRecordId(Integer deliveryRecordId) {
		this.deliveryRecordId = deliveryRecordId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "DeliveryRecordEntry [entryId=" + entryId + ", deliveryRecordId=" + deliveryRecordId + ", empId=" + empId
				+ "]";
	}
	
	
	
	

	
	
	
	

}
