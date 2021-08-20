package com.athensoft.edusys.admin.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.hr.entity.Admin;
import com.athensoft.edusys.hr.entity.Employee;
import com.athensoft.edusys.hr.entity.Instructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "admin_group")
public class AcademicGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id", nullable = false)
	private Integer groupId = -1;

	@Column(name = "group_no", unique = true)
	private String groupNo;

	@ManyToMany(targetEntity = Student.class)
	@JoinTable(name = "admin_rel_group_student", joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"), inverseJoinColumns = @JoinColumn(name = "stu_id", referencedColumnName = "stu_id"))
	private List<Student> regStudents;

	@ManyToMany(targetEntity = Employee.class)
	@JoinTable(name = "admin_rel_group_employee", joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"), inverseJoinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "emp_id"))
	private List<Instructor> regInstructors;

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

	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<CourseEntry> courseEntries;

	@Column(name = "price")
	private Float price;
	
	@ManyToMany
	@JoinTable(name = "admin_rel_group_admin",
    joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
    inverseJoinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "emp_id"))
	private List<Admin> regAdmins;
	
	@OneToMany(targetEntity = GroupSchedule.class)
	@JoinTable(name = "admin_group_schedule",
			joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
		    inverseJoinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id"))
	private List<GroupSchedule> groupSchedules;

	public AcademicGroup() {
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

	public List<Instructor> getRegInstructors() {
		return regInstructors;
	}

	public void setRegInstructors(List<Instructor> regInstructors) {
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

	public List<CourseEntry> getCourseEntries() {
		return courseEntries;
	}

	public void setCourseEntries(List<CourseEntry> courseEntries) {
		this.courseEntries = courseEntries;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<Admin> getRegAdmins() {
		return regAdmins;
	}

	public void setRegAdmins(List<Admin> regAdmins) {
		this.regAdmins = regAdmins;
	}
	
	public List<GroupSchedule> getGroupSchedules() {
		return groupSchedules;
	}

	public void setGroupSchedules(List<GroupSchedule> groupSchedules) {
		this.groupSchedules = groupSchedules;
	}

	@Override
	public String toString() {
		return "AcademicGroup [groupId=" + groupId + ", groupNo=" + groupNo + ", regStudents=" + regStudents
				+ ", regInstructors=" + regInstructors + ", groupStatus=" + groupStatus + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", sessionNum=" + sessionNum + ", groupType=" + groupType + ", groupName="
				+ groupName + ", groupDesc=" + groupDesc + ", courseEntries=" + courseEntries + ", price=" + price
				+ ", regAdmins=" + regAdmins + ", groupSchedules=" + groupSchedules + "]";
	}

	

	

}
