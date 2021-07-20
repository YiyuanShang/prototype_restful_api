package com.athensoft.edusys.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.product.entity.Course;
import com.athensoft.edusys.product.service.CourseService;

@RestController
public class CourseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
	
	private final CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/courses")
	public List<Course> getDataListCourse(){
		LOGGER.debug("entering /courses");
		return courseService.getCourseList();
	}

}
