package com.athensoft.prototype.error.exceptions;

import com.athensoft.edusys.product.entity.Course;

public class CourseNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3231332530981116656L;

	public CourseNotFoundException() {
		super("Course is not found!");
	}
	
	public CourseNotFoundException(int courseId) {
		super("Course " + courseId + " is not found!");
	}
	
	public CourseNotFoundException(Course course) {
//		super("Course " + course.get)
	}
	public CourseNotFoundException(String message) {
		super(message);
	}

}