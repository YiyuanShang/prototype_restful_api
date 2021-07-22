package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.product.entity.Course;

public class CourseNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3231332530981116656L;

	public CourseNotFoundException() {
		super("Course is not found!");
	}
	
	public CourseNotFoundException(int courseId) {
		super("Course " + courseId + " is not found!");
	}
	
//	public CourseNotFoundException(Course course) {
//		super("Course " + course.getCourseName() + " is not found!");
//	}
	public CourseNotFoundException(String message) {
		super(message);
	}

}