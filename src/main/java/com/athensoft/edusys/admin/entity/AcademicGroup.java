package com.athensoft.edusys.admin.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.hr.entity.Instructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "admin_group")
@Getter @Setter @NoArgsConstructor @ToString
public class AcademicGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupId;
	
	@Column(unique=true)
	private String groupNo;
	
	@ManyToMany(targetEntity = Student.class)
	private List<Student> regStudents;
	
	@ManyToMany(targetEntity = Instructor.class)
	private List<Instructor> regInstructors;
	
	@Enumerated(EnumType.STRING)
	private GroupStatus groupStatus;
	
	private Date startDate;
	private Date endDate;
	private int courseId;
	private int sessionNum;
	
	@Enumerated(EnumType.STRING)
	private GroupType groupType;
}
