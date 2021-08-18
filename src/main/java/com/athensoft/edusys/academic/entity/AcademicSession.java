package com.athensoft.edusys.academic.entity;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.athensoft.edusys.admin.entity.AttendanceRecord;
import com.athensoft.edusys.admin.entity.DeliveryRecord;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "acd_session")
//@SecondaryTable(name="admin_delivery_record",
//pkJoinColumns = {@PrimaryKeyJoinColumn(name = "session_id", referencedColumnName = "session_id")})
public class AcademicSession implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "session_id", nullable = false)
	private Integer sessionId = -1;
	
	@Column(name = "group_no", unique = true)
	private String groupNo;
	
	@Column(name = "session_seqno")
	private Integer sessionSeqNo;
	
	@OneToOne(targetEntity = AssignmentRecord.class)
	@JoinColumn(name = "session_id")
	private AssignmentRecord assignmentRecord;
	
//	@OneToOne(targetEntity = DeliveryRecord.class)
////	@AttributeOverrides({
////        @AttributeOverride(name="deliveredSession", column=@Column(name="session_id", table="admin_delivery_record"))
////    })
//	@JoinTable(name = "admin_delivery_record")
//	private DeliveryRecord deliveryRecord;
//	
//	@OneToOne(targetEntity = AttendanceRecord.class)
//	@JoinTable(name = "admin_attend_record")
//	private AttendanceRecord attendanceRecord;
	
	@OneToOne(targetEntity = TopicRecord.class, mappedBy = "deliveredSession")
	@JsonManagedReference
	private TopicRecord topicRecord;

	@Column(name = "delivery_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Etc/GMT+4")
	private Date deliveryDate;
	
	@Column(name = "start_time")
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date startTime;
	
	@Column(name = "end_time")
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date endTime;
	
	private Float duration; 
	
	@Enumerated(EnumType.ORDINAL)	
	@Column(name = "session_status")
	private SessionStatus sessionStatus;
	
	public AcademicSession() {}

	
	public AcademicSession(Integer sessionId, String groupNo, Integer sessionSeqNo, AssignmentRecord assignmentRecord,
			TopicRecord topicRecord, Date deliveryDate, Date startTime, Date endTime, Float duration,
			SessionStatus sessionStatus) {
		super();
		this.sessionId = sessionId;
		this.groupNo = groupNo;
		this.sessionSeqNo = sessionSeqNo;
		this.assignmentRecord = assignmentRecord;
		this.topicRecord = topicRecord;
		this.deliveryDate = deliveryDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.sessionStatus = sessionStatus;
	}


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

	public AssignmentRecord getAssignmentRecord() {
		return assignmentRecord;
	}

	public void setAssignmentRecord(AssignmentRecord assignmentRecord) {
		this.assignmentRecord = assignmentRecord;
	}

//	public DeliveryRecord getDeliveryRecord() {
//		return deliveryRecord;
//	}
//
//	public void setDeliveryRecord(DeliveryRecord deliveryRecord) {
//		this.deliveryRecord = deliveryRecord;
//	}
//
//	public AttendanceRecord getAttendanceRecord() {
//		return attendanceRecord;
//	}
//
//	public void setAttendanceRecord(AttendanceRecord attendanceRecord) {
//		this.attendanceRecord = attendanceRecord;
//	}
//
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Float getDuration() {
		// convert milliseconds to hours
		return (float) ((endTime.getTime() - startTime.getTime())/ (3.6 * Math.pow(10, 6)));
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public SessionStatus getSessionStatus() {
		return sessionStatus;
	}

	public void setSessionStatus(SessionStatus sessionStatus) {
		this.sessionStatus = sessionStatus;
	}


//	@Override
//	public String toString() {
//		return "AcademicSession [sessionId=" + sessionId + ", groupNo=" + groupNo + ", sessionSeqNo=" + sessionSeqNo
//				+ ", deliveryDate=" + deliveryDate + ", startTime=" + startTime + ", endTime=" + endTime + ", duration="
//				+ duration + ", sessionStatus=" + sessionStatus + "]";
//	}

	

	public TopicRecord getTopicRecord() {
		return topicRecord;
	}


	public void setTopicRecord(TopicRecord topicRecord) {
		this.topicRecord = topicRecord;
	}

	@Override
	public String toString() {
		return "AcademicSession [sessionId=" + sessionId + ", groupNo=" + groupNo + ", sessionSeqNo=" + sessionSeqNo
				+ ", assignmentRecord=" + assignmentRecord + ", topicRecord=" + topicRecord + ", deliveryDate=" + deliveryDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", duration=" + duration + ", sessionStatus="
				+ sessionStatus + "]";
	}

	
	
	
}
