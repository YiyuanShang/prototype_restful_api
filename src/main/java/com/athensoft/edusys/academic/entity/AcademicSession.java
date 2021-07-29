package com.athensoft.edusys.academic.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.athensoft.edusys.admin.entity.AttendanceRecord;
import com.athensoft.edusys.admin.entity.DeliveryRecord;
//import com.athensoft.edusys.product.entity.Topic;

@Entity
@Table(name = "acd_session")
public class AcademicSession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_id", nullable = false)
	private Integer sessionId = -1;
	
	@Column(name = "group_no", unique = true)
	private String groupNo;
	
	@Column(name = "session_seqno")
	private Integer sessionSeqNo;
	
	@OneToOne
	@JoinColumn(name = "assgmt_record_id")
	private AssignmentRecord assignment;
	
	@OneToOne(targetEntity = DeliveryRecord.class)
	private DeliveryRecord deliveryRecord;
	
	@OneToOne(targetEntity = AttendanceRecord.class)
	private AttendanceRecord attendanceRecord;
	
//	@OneToOne(targetEntity = TopicRecord.class)
//	private TopicRecord topicRecord;

	public AcademicSession() {}
	
public AcademicSession(Integer sessionId, String groupNo, Integer sessionSeqNo, AssignmentRecord assignment,
		DeliveryRecord deliveryRecord, AttendanceRecord attendanceRecord) {
	super();
	this.sessionId = sessionId;
	this.groupNo = groupNo;
	this.sessionSeqNo = sessionSeqNo;
	this.assignment = assignment;
	this.deliveryRecord = deliveryRecord;
	this.attendanceRecord = attendanceRecord;
}

//	public AcademicSession(Integer sessionId, String groupNo, Integer sessionSeqNo, AssignmentRecord assignment,
//			DeliveryRecord deliveryRecord, AttendanceRecord attendanceRecord, TopicRecord topicRecord) {
//		super();
//		this.sessionId = sessionId;
//		this.groupNo = groupNo;
//		this.sessionSeqNo = sessionSeqNo;
//		this.assignment = assignment;
//		this.deliveryRecord = deliveryRecord;
//		this.attendanceRecord = attendanceRecord;
//		this.topicRecord = topicRecord;
//	}
	
	

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public Integer getSessionSeqNo() {
		return sessionSeqNo;
	}

	public void setSessionSeqNo(Integer sessionSeqNo) {
		this.sessionSeqNo = sessionSeqNo;
	}

	public AssignmentRecord getAssignment() {
		return assignment;
	}

	public void setAssignment(AssignmentRecord assignment) {
		this.assignment = assignment;
	}

	public DeliveryRecord getDeliveryRecord() {
		return deliveryRecord;
	}

	public void setDeliveryRecord(DeliveryRecord deliveryRecord) {
		this.deliveryRecord = deliveryRecord;
	}

	public AttendanceRecord getAttendanceRecord() {
		return attendanceRecord;
	}

	public void setAttendanceRecord(AttendanceRecord attendanceRecord) {
		this.attendanceRecord = attendanceRecord;
	}

	@Override
	public String toString() {
		return "AcademicSession [sessionId=" + sessionId + ", groupNo=" + groupNo + ", sessionSeqNo=" + sessionSeqNo
				+ ", assignment=" + assignment + ", deliveryRecord=" + deliveryRecord + ", attendanceRecord="
				+ attendanceRecord + "]";
	}

//	public TopicRecord getTopics() {
//		return topicRecord;
//	}
//
//	public void setTopics(TopicRecord topicRecord) {
//		this.topicRecord = topicRecord;
//	}

//	@Override
//	public String toString() {
//		return "AcademicSession [sessionId=" + sessionId + ", groupNo=" + groupNo + ", sessionSeqNo=" + sessionSeqNo
//				+ ", assignment=" + assignment + ", deliveryRecord=" + deliveryRecord + ", attendanceRecord="
//				+ attendanceRecord + ", topicRecord=" + topicRecord + "]";
//	}
	
	
	
}
