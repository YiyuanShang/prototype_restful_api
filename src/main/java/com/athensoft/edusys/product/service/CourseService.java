package com.athensoft.edusys.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.error.exceptions.CourseAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.CourseNotFoundException;
import com.athensoft.edusys.product.dao.CourseRepository;
import com.athensoft.edusys.product.entity.Course;
import com.athensoft.edusys.product.entity.Module;

@Service
public class CourseService {
	private final CourseRepository courseRepo;
	
	private final ModuleService moduleService;
	
	public CourseService(CourseRepository courseRepo, ModuleService moduleService) {
		this.courseRepo = courseRepo;
		this.moduleService = moduleService;
	}
	
	public List<Course> getCourseList(){
		return courseRepo.findAll();
	}
	
	public Course getCourseById(Integer courseId) {
		return courseRepo.findById(courseId)
				.orElseThrow(() -> new CourseNotFoundException(courseId));
	}
	
	public List<Module> getModuleListByCourseId(Integer courseId) {
		return getCourseById(courseId).getModules();
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
	
	public ResponseEntity<Course> addModuleToCourse(Integer courseId, Integer moduleId) {
		Course course = getCourseById(courseId);
		Module module = moduleService.getModuleById(moduleId);
		course.getModules().add(module);
		
		return updateCourse(course);
	}
	
	public ResponseEntity<Course> removeModuleFromCourse(Integer courseId, Integer moduleId){
		Course course = getCourseById(courseId);
		Module module = moduleService.getModuleById(moduleId);
		course.getModules().remove(module);
		
		return updateCourse(course);
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
