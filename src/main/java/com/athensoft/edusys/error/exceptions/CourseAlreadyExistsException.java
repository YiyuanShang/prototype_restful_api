package com.athensoft.edusys.error.exceptions;

import com.athensoft.edusys.product.entity.Course;

public class CourseAlreadyExistsException extends AlreadyExistsException {
	private static final long serialVersionUID = -3231332530981116656L;

	public CourseAlreadyExistsException() {
		super("Course already exists!");
	}
	
	public CourseAlreadyExistsException(Integer courseId) {
		super("Course " + courseId + " already exists!");
	}
	
	public CourseAlreadyExistsException(Course course) {
		super("Course " + course.getCourseName() + " already exists!");
	}
	
	public CourseAlreadyExistsException(String message) {
		super(message);
	}

}