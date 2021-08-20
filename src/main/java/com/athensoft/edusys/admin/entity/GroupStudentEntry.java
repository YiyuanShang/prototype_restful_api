package com.athensoft.edusys.admin.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.athensoft.edusys.client.entity.Student;

@Entity
@Table(name = "admin_rel_group_student")
@IdClass(GroupStudentEntryId.class)
public class GroupStudentEntry {
	@Id
	@JoinColumn(name = "stu_id")
	@ManyToOne(targetEntity = Student.class)
	private Student student;
	
	@Enumerated(EnumType.ORDINAL)
	private StudentGroupStatus studentGroupStatus;
	
	private String comment;
	
	@Id
	@JoinColumn(name = "group_id")
	@ManyToOne(targetEntity = AcademicGroup.class)
	private AcademicGroup group;

	public GroupStudentEntry() {}
	
	public GroupStudentEntry(Student student, StudentGroupStatus studentGroupStatus, String comment,
			AcademicGroup group) {
		super();
		this.student = student;
		this.studentGroupStatus = studentGroupStatus;
		this.comment = comment;
		this.group = group;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentGroupStatus getStudentGroupStatus() {
		return studentGroupStatus;
	}

	public void setStudentGroupStatus(StudentGroupStatus studentGroupStatus) {
		this.studentGroupStatus = studentGroupStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public AcademicGroup getGroup() {
		return group;
	}

	public void setGroup(AcademicGroup group) {
		this.group = group;
	}
	
	

}
