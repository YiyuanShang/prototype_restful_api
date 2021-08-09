package com.athensoft.edusys.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
