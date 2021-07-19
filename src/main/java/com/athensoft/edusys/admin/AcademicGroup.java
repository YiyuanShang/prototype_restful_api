package com.athensoft.edusys.admin;

import java.util.Date;
import java.util.List;

import com.athensoft.edusys.client.Student;
import com.athensoft.edusys.hr.Instructor;

public class AcademicGroup {
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
