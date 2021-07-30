package com.athensoft.edusys.admin.entity;

import java.util.List;

import javax.persistence.AttributeOverrides;
import javax.persistence.ElementCollection;
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

import com.athensoft.edusys.hr.entity.Employee;
import com.athensoft.edusys.hr.entity.Instructor;


@Entity
@Table(name = "admin_delivery_record")
public class DeliveryRecord {
	@EmbeddedId
	DeliveryRecordId deliveryRecordId;
	
	@ElementCollection
	@JoinColumns({
		  @JoinColumn(name = "session_id"),
		  @JoinColumn(name = "emp_id")})
	private List<DeliveryRecordEntry> deliveredInstructors;
	
}


