package com.athensoft.edusys.admin.entity;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.athensoft.edusys.academic.entity.AssignmentResultStatus;
import com.athensoft.edusys.hr.entity.Instructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Getter @Setter @NoArgsConstructor
//@Table(name = "admin_delivery_record")
public class DeliveryRecord {
//	@EmbeddedId
//	DeliveryRecordId deliveryRecordId;
//	
//	@JoinColumn(name = "instructor_id")
//	@OneToMany(targetEntity = Instructor.class)
//	private List<Instructor> deliveredInstructors;
}


