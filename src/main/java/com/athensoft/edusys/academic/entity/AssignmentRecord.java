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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "acd_asgmt_record")
public class AssignmentRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assgmt_record_id")
	private Integer assgmtRecordId = -1;
	
	@Enumerated(EnumType.STRING)
	private AssignmentType assgmtType;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "issuedate")
	private Date issueDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "duedate")
	private Date dueDate;
	
	@ManyToMany(targetEntity = Question.class)
	@JoinTable(name = "acd_rel_assgmt_question", 
	joinColumns = @JoinColumn(name = "assgmt_record_id", referencedColumnName = "assgmt_record_id"),
    inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"))
	private List<Question> questions;

	public AssignmentRecord() {}
	
	public AssignmentRecord(Integer assgmtRecordId, AssignmentType assgmtType, Date issueDate, Date dueDate,
			List<Question> questions) {
		super();
		this.assgmtRecordId = assgmtRecordId;
		this.assgmtType = assgmtType;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.questions = questions;
	}

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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "AssignmentRecord [assgmtRecordId=" + assgmtRecordId + ", assgmtType=" + assgmtType + ", issueDate="
				+ issueDate + ", dueDate=" + dueDate + ", questions=" + questions + "]";
	}
	
	
	
	
}
