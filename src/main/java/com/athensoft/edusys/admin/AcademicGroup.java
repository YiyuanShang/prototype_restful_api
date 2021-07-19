package com.athensoft.edusys.admin;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.athensoft.edusys.client.Student;
import com.athensoft.edusys.hr.Instructor;

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
	private String groupNo;
	private List<Student> regStudents;
	private List<Instructor> regInstructors;
	private GroupStatus groupStatus;
	private Date startDate;
	private Date endDate;
	private int courseId;
	private int sessionNum;
	private GroupType groupType;
}
