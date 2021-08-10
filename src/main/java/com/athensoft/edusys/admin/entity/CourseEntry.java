package com.athensoft.edusys.admin.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.athensoft.edusys.product.entity.Course;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "admin_rel_group_course")
public class CourseEntry {
	@EmbeddedId
	CourseEntryId courseEntryId;
	
	@ManyToOne(targetEntity = Course.class)
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
	
	@ManyToOne(targetEntity = AcademicGroup.class)
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
	@JsonBackReference
    private AcademicGroup group;
	
	@Column(name = "is_primary")
	private Boolean isPrimary;

	public CourseEntry() {}
	
	

	public CourseEntry(Course course, AcademicGroup group, Boolean isPrimary) {
		super();
		this.courseEntryId = new CourseEntryId(group.getGroupId(), course.getCourseId());
		this.course = course;
		this.group = group;
		this.isPrimary = isPrimary;
	}



	public CourseEntryId getCourseEntryId() {
		return courseEntryId;
	}

	public void setCourseEntryId(CourseEntryId courseEntryId) {
		this.courseEntryId = courseEntryId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}



	public AcademicGroup getGroup() {
		return group;
	}



	public void setGroup(AcademicGroup group) {
		this.group = group;
	}



	@Override
	public String toString() {
		return "CourseEntry [courseEntryId=" + courseEntryId + ", isPrimary=" + isPrimary + "]";
	}

	
	
	
	

}
