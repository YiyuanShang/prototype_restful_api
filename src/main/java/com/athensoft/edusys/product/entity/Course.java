package com.athensoft.edusys.product.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "prod_course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId = -1;
	
	@Column(nullable = false)
	private String courseCode;
	
	@Column(name = "course_shortname")
	private String courseShortName;
	
	private String courseName;
	
	private String courseDesc;

	public Course() {}
	
	public Course(Integer courseId, String courseCode, String courseShortName, String courseName, String courseDesc) {
		super();
		this.courseId = courseId;
		this.courseCode = courseCode;
		this.courseShortName = courseShortName;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseShortName() {
		return courseShortName;
	}

	public void setCourseShortName(String courseShortName) {
		this.courseShortName = courseShortName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseCode=" + courseCode + ", courseShortName=" + courseShortName
				+ ", courseName=" + courseName + ", courseDesc=" + courseDesc + "]";
	}
	
//	private List<Topic> topics;
//	
//	private List<Question> questions;
	
	
	

}
