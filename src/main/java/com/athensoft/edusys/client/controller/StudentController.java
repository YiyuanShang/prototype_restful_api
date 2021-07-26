package com.athensoft.edusys.client.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.client.service.StudentService;

@RestController
@RequestMapping("/edusys/client")
public class StudentController {
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getDataList(){
		return ResponseEntity.ok(studentService.getStudentList());
	}
	
	@GetMapping("/students/{stuId}")
	public ResponseEntity<Student> getDataById(@PathVariable int stuId){
		return ResponseEntity.ok(studentService.getStudentById(stuId));
	}
	
	@GetMapping("/students/name")
	public ResponseEntity<List<Student>> getDataByName(
			@RequestParam(name = "stuFirstName") String stuFirstName, 
			@RequestParam(name = "stuLastName") String stuLastName){
		return ResponseEntity.ok(studentService.getStudentListByName(stuFirstName, stuLastName));
	}
	
	@GetMapping("/students/filters")
	public ResponseEntity<List<Student>> getDataByFilters(
			@RequestParam(name = "stuId") Optional<Integer> stuId, 
			@RequestParam(name = "stuNo", required = false) String stuNo, 
			@RequestParam(name = "stuFirstName", required = false) String stuFirstName, 
			@RequestParam(name = "stuLastName", required = false) String stuLastName,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "isMember") Optional<Boolean> isMember,
			@RequestParam(name = "regDate") Optional<String> regDate,
			@RequestParam(name = "studentType") Optional<Integer> stuType) throws ParseException{
		return ResponseEntity.ok(studentService.getStudentListByFilters(stuId, stuNo, stuFirstName, stuLastName, email, isMember, regDate, stuType));
	}
	
	@GetMapping("/students/filtersStr")
	public ResponseEntity<List<Student>> getDataByFiltersStr() throws JSONException, ParseException{
		return ResponseEntity.ok(studentService.getStudentListByFiltersStr());
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return studentService.createStudent(student);
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/students")
	public ResponseEntity<Student> deleteStudent(@RequestBody Student student){
		return studentService.deleteStudent(student);
	}
	
	@DeleteMapping("/students/{stuId}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable int stuId){
		return studentService.deleteStudentById(stuId);
	}
}
