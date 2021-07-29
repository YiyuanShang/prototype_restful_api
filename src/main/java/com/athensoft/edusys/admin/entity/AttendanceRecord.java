package com.athensoft.edusys.admin.entity;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.hr.entity.Employee;


@Entity
@Table(name = "admin_attend_record")
public class AttendanceRecord {
	@EmbeddedId
	AttendanceRecordId attendanceRecordId;
	
	
	@OneToMany(targetEntity = Student.class)
	@JoinColumns({
		  @JoinColumn(name = "session_id"),
		  @JoinColumn(name = "stu_id")})
	private List<Student> attendedStudents;
}
