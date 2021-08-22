package com.athensoft.edusys.academic.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.athensoft.edusys.product.entity.Question;


@Entity
@Table(name = "acd_asgmt_record")
public class AssignmentRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assgmt_record_id")
	private Integer assgmtRecordId = -1;

	@Enumerated(EnumType.ORDINAL)
	private AssignmentType assgmtType;

	@Temporal(TemporalType.DATE)
	@Column(name = "issuedate")
	private Date issueDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "duedate")
	private Date dueDate;
	
	@Column(name = "received_notice_number")
	private Integer numReceivedNotice;
	
	@Enumerated(EnumType.ORDINAL)
	private AssignmentRecordStatus assgmtRecordStatus;

//	@ManyToMany(targetEntity = Question.class)
//	@JoinTable(name = "acd_rel_assgmt_question", 
//	joinColumns = @JoinColumn(name = "assgmt_record_id", referencedColumnName = "assgmt_record_id"),
//    inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"))
//	private List<Question> questions;


	public Integer getAssgmtRecordId() {
		return assgmtRecordId;
	}

	public void setAssgmtRecordId(Integer assgmtRecordId) {
		this.assgmtRecordId = assgmtRecordId;
	}

	public AssignmentType getAssgmtType() {
		return assgmtType;
	}

	public void setAssgmtType(AssignmentType assgmtType) {
		this.assgmtType = assgmtType;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getNumReceivedNotice() {
		return numReceivedNotice;
	}

	public void setNumReceivedNotice(Integer numReceivedNotice) {
		this.numReceivedNotice = numReceivedNotice;
	}

	public AssignmentRecordStatus getAssgmtRecordStatus() {
		return assgmtRecordStatus;
	}

	public void setAssgmtRecordStatus(AssignmentRecordStatus assgmtRecordStatus) {
		this.assgmtRecordStatus = assgmtRecordStatus;
	}

	@Override
	public String toString() {
		return "AssignmentRecord [assgmtRecordId=" + assgmtRecordId + ", assgmtType=" + assgmtType + ", issueDate="
				+ issueDate + ", dueDate=" + dueDate + ", numReceivedNotice=" + numReceivedNotice
				+ ", assgmtRecordStatus=" + assgmtRecordStatus + "]";
	}

	

//	public List<Question> getQuestions() {
//		return questions;
//	}
//
//	public void setQuestions(List<Question> questions) {
//		this.questions = questions;
//	}
//


}
