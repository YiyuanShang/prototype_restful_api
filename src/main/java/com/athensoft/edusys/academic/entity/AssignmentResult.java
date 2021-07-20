package com.athensoft.edusys.academic.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "acd_asgmt_result")
@Getter @Setter @NoArgsConstructor @ToString
public class AssignmentResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assgmtRecordId;
	
	@Transient
	private String stuNo;
	private int instructorId;
	private float resultScore;
	private String resultGrade;
	private int assgmtResultId;
	
	@Enumerated(EnumType.STRING)
	private AssignmentResultStatus assgmtResultStatus;
}
