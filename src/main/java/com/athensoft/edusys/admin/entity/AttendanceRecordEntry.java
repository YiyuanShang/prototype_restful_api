package com.athensoft.edusys.admin.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.athensoft.edusys.academic.entity.AcademicSession;
import com.athensoft.edusys.client.entity.Student;

@Embeddable
public class AttendanceRecordEntry implements Serializable{
	private static final long serialVersionUID = 6958416949270053797L;
	
//	@OneToOne(targetEntity = AcademicSession.class)
	@ManyToOne
	@MapsId("sessionId")
	@JoinColumn(name = "session_id")
	private AcademicSession session;
	
//	@OneToOne(targetEntity = Student.class)
	@ManyToOne
	@MapsId("stuId")
	@JoinColumn(name = "stu_id")
	private Student student;
	
	@Column(name = "attendance_type")
	private AttendanceType attendanceType;
	
	@Column(name = "attendance_desc")
	private String attendanceDesc;
	
	public AttendanceRecordEntry() {}
	
	public AttendanceRecordEntry(Student student, AttendanceType attendanceType, String attendanceDesc) {
		super();
		this.student = student;
		this.attendanceType = attendanceType;
		this.attendanceDesc = attendanceDesc;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AttendanceType getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(AttendanceType attendanceType) {
		this.attendanceType = attendanceType;
	}

	public String getAttendanceDesc() {
		return attendanceDesc;
	}

	public void setAttendanceDesc(String attendanceDesc) {
		this.attendanceDesc = attendanceDesc;
	}

	@Override
	public String toString() {
		return "AttendanceRecordEntry [student=" + student + ", attendanceType=" + attendanceType + ", attendanceDesc="
				+ attendanceDesc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(student, attendanceType, attendanceDesc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttendanceRecordEntry other = (AttendanceRecordEntry) obj;
		if (attendanceDesc == null) {
			if (other.attendanceDesc != null)
				return false;
		} else if (!attendanceDesc.equals(other.attendanceDesc))
			return false;
		if (attendanceType != other.attendanceType)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
	
	
	

}
