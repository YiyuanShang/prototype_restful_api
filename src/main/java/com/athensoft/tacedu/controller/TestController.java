package com.athensoft.tacedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.athensoft.tacedu.entity.Student;

@Controller
public class TestController {
	
	@GetMapping({"/index", "/{lang}/index"})
	public String gotoIndexCoporate(@PathVariable(required=false) String lang) {
		return "index-corporate";
	}
	
	@GetMapping("/test-ajax")
	public String gotoTestAjax() {
		return "test-ajax";
	}
	
	@GetMapping("/edusys/students")
	@ResponseBody
	public ResponseEntity<List<Student>> getDataStudentList(){
		List<Student> students = new ArrayList<>();
		Student stu1 = new Student(1, "1", "Jack");
		Student stu2 = new Student(2, "2", "Jane");
		Student stu3 = new Student(3, "3", "Doe");
		
		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		
		return ResponseEntity.ok(students);
	}
}
