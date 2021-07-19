package com.athensoft.edusys.academic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String stuNo;
	private int instructorId;
	private float resultScore;
	private String resultGrade;
	private int assgmtResultId;
	private AssignmentResultStatus assgmtResultStatus;
}
