package com.athensoft.edusys.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.error.exceptions.CourseAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.CourseNotFoundException;
import com.athensoft.edusys.product.dao.CourseRepository;
import com.athensoft.edusys.product.entity.Course;

@Service
public class CourseService {
	private CourseRepository courseRepo;
	
	public CourseService(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	public List<Course> getCourseList(){
		return courseRepo.findAll();
	}
	
	public Course getCourseById(Integer courseId) {
		return courseRepo.findById(courseId)
				.orElseThrow(() -> new CourseNotFoundException(courseId));
	}
	
	public ResponseEntity<Course> createCourse(Course course){
		checkCourseAlreadyExistsException(course.getCourseId());

		return new ResponseEntity<>(courseRepo.save(course), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Course> updateCourse(Course course){
		checkCourseNotFoundException(course.getCourseId());

		return ResponseEntity.ok(courseRepo.save(course));
	}
	
	public ResponseEntity<Course> deleteCourse(Course course){
		checkCourseNotFoundException(course.getCourseId());
		courseRepo.delete(course);
		return ResponseEntity.ok(course);
	}
	
	public ResponseEntity<Course> deleteCourseById(Integer courseId){
		checkCourseNotFoundException(courseId);
		Course deletedCourse = getCourseById(courseId);
		courseRepo.deleteById(courseId);
		return ResponseEntity.ok(deletedCourse);
	}
	
	private void checkCourseAlreadyExistsException(Integer courseId) {
		if (courseRepo.existsById(courseId)) {
			throw new CourseAlreadyExistsException(courseId);
		}
	}
	
	private void checkCourseNotFoundException(Integer courseId) {
		if (!courseRepo.existsById(courseId)) {
			throw new CourseNotFoundException(courseId);
		}
	}

}
