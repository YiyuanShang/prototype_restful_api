package com.athensoft.edusys.admin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.hr.entity.Employee;
import com.athensoft.edusys.hr.entity.Instructor;
import com.athensoft.edusys.product.entity.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "admin_group")
public class AcademicGroup{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id", nullable = false)
	private Integer groupId = -1;
	
	@Column(name = "group_no", unique=true)
	private String groupNo;
	
	@ManyToMany(targetEntity = Student.class)
	@JoinTable(name = "admin_rel_group_student",
			joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
	        inverseJoinColumns = @JoinColumn(name = "stu_id", referencedColumnName = "stu_id"))
	private List<Student> regStudents;
	
	@ManyToMany(targetEntity = Employee.class)
	@JoinTable(name = "admin_rel_group_employee", 
			joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
	        inverseJoinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "emp_id"))
	private List<Employee> regInstructors;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "group_status")
	private GroupStatus groupStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "session_num")
	private Integer sessionNum;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "group_type")
	private GroupType groupType;
	
	@Column(name = "group_name")
	private String groupName;
	
	@Column(name = "group_desc")
	private String groupDesc;
	
//	@ManyToMany(targetEntity = Course.class)
//	@JoinTable(name = "admin_rel_group_course", 
//		joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
//	    inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"))
//	private List<Course> courses;
	
	public AcademicGroup() {}

	public AcademicGroup(Integer groupId, String groupNo, List<Student> regStudents, List<Employee> regInstructors,
			GroupStatus groupStatus, Date startDate, Date endDate, Integer sessionNum, GroupType groupType,
			String groupName, String groupDesc) {
		super();
		this.groupId = groupId;
		this.groupNo = groupNo;
		this.regStudents = regStudents;
		this.regInstructors = regInstructors;
		this.groupStatus = groupStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sessionNum = sessionNum;
		this.groupType = groupType;
		this.groupName = groupName;
		this.groupDesc = groupDesc;
//		this.courses = courses;
	}



	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public List<Student> getRegStudents() {
		return regStudents;
	}

	public void setRegStudents(List<Student> regStudents) {
		this.regStudents = regStudents;
	}

	public List<Employee> getRegInstructors() {
		return regInstructors;
	}

	public void setRegInstructors(List<Employee> regInstructors) {
		this.regInstructors = regInstructors;
	}

	public GroupStatus getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(GroupStatus groupStatus) {
		this.groupStatus = groupStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getSessionNum() {
		return sessionNum;
	}

	public void setSessionNum(Integer sessionNum) {
		this.sessionNum = sessionNum;
	}

	public GroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	

//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}

	@Override
	public String toString() {
		return "AcademicGroup [groupId=" + groupId + ", groupNo=" + groupNo + ", regStudents=" + regStudents
				+ ", regInstructors=" + regInstructors + ", groupStatus=" + groupStatus + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", sessionNum=" + sessionNum + ", groupType=" + groupType + ", groupName="
				+ groupName + ", groupDesc=" + groupDesc + "]";
	}

	
	
	
	
	
}
