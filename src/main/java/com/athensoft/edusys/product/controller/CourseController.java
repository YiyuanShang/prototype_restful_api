package com.athensoft.edusys.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.product.entity.Course;
import com.athensoft.edusys.product.service.CourseService;

@RestController
@RequestMapping("/edusys/product")
public class CourseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
	
	private final CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getDataListCourse(){
		LOGGER.debug("entering /courses");
		return ResponseEntity.ok(courseService.getCourseList());
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getDataCourseById(@PathVariable Integer courseId){
		return ResponseEntity.ok(courseService.getCourseById(courseId));
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> createCourse(@RequestBody Course course){
		return courseService.createCourse(course);
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course){
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses")
	public ResponseEntity<Course> deleteCourse(@RequestBody Course course){
		return courseService.deleteCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<Course> deleteCourseById(@PathVariable Integer courseId){
		return courseService.deleteCourseById(courseId);
	}

}
