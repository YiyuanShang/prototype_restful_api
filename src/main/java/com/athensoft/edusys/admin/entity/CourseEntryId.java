package com.athensoft.edusys.admin.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CourseEntryId implements Serializable {
	private static final long serialVersionUID = -4202417404182651657L;

	private Integer groupId;

	private Integer courseId;

	public CourseEntryId() {
	}

	public CourseEntryId(Integer groupId, Integer courseId) {
		super();
		this.groupId = groupId;
		this.courseId = courseId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "CourseEntryId [groupId=" + groupId + ", courseId=" + courseId + "]";
	}

}
