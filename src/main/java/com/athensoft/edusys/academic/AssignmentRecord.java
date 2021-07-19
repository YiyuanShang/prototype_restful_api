package com.athensoft.edusys.academic;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.athensoft.edusys.product.Question;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "acd_asgmt_record")
@Getter @Setter @NoArgsConstructor @ToString
public class AssignmentRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assgmtRecordId;
	private AssignmentType assgmtType;
	private Date issueDate;
	private Date dueDate;
	private List<Question> questions;
}
