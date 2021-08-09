package com.athensoft.edusys.admin.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.hr.entity.Employee;


//@Entity
//@Table(name = "admin_attend_record")
public class AttendanceRecord {
//	@EmbeddedId
//	AttendanceRecordId attendanceRecordId;
//	
//	
//	@ElementCollection
//	@JoinColumns({
//		  @JoinColumn(name = "session_id"),
//		  @JoinColumn(name = "stu_id")})
//	private List<AttendanceRecordEntry> attendaceRecordEntries;
//	
////	@ManyToOne
////	@MapsId("sessionId")
////	@JoinColumn(name = "session_id")
////	private AcademicSession attendedSession;
//
//	public AttendanceRecord() {}
//	public AttendanceRecord(AttendanceRecordId attendanceRecordId, List<AttendanceRecordEntry> attendaceRecordEntries
//			) {
//		super();
//		this.attendanceRecordId = attendanceRecordId;
//		this.attendaceRecordEntries = attendaceRecordEntries;
////		this.attendedSession = attendedSession;
//	}
//
//	public AttendanceRecordId getAttendanceRecordId() {
//		return attendanceRecordId;
//	}
//
//	public void setAttendanceRecordId(AttendanceRecordId attendanceRecordId) {
//		this.attendanceRecordId = attendanceRecordId;
//	}
//
//	public List<AttendanceRecordEntry> getAttendaceRecordEntries() {
//		return attendaceRecordEntries;
//	}
//
//	public void setAttendaceRecordEntries(List<AttendanceRecordEntry> attendaceRecordEntries) {
//		this.attendaceRecordEntries = attendaceRecordEntries;
//	}
//
////	public AcademicSession getAttendedSession() {
////		return attendedSession;
////	}
////
////	public void setAttendedSession(AcademicSession attendedSession) {
////		this.attendedSession = attendedSession;
////	}
//	
	
	
}
