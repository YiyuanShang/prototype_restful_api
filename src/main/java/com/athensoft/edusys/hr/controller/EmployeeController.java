package com.athensoft.edusys.hr.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.hr.entity.Employee;
import com.athensoft.edusys.hr.service.EmployeeService;

@RestController
@RequestMapping("/edusys/hr")
public class EmployeeController {
	private final EmployeeService empService;
	
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getDataList(){
		return ResponseEntity.ok(empService.getEmployeeList());
	}
	
	@GetMapping("/employees/filters")
	public ResponseEntity<List<Employee>> getDataByFilters(
			@RequestParam(name = "empId") Optional<Integer> empId, 
			@RequestParam(name = "empCode", required = false) String empCode,
			@RequestParam(name = "empFirstName", required = false) String empFirstName,
			@RequestParam(name = "empLastName", required = false) String empLastName,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "empType") Optional<Integer> empType,
			@RequestParam(name = "hireDate", required = false) Date hireDate,
			@RequestParam(name = "expiryDate", required = false) Date expiryDate,
			@RequestParam(name = "roleType") Optional<Integer> roleType){
		return ResponseEntity.ok(empService.getEmployeeListByFilters(empId, empCode, empFirstName, empLastName, email, empType, hireDate, expiryDate, roleType));
	}

	@GetMapping("/employees/filtersStr")
	public ResponseEntity<List<Employee>> getDataByFiltersStr() throws JSONException, ParseException{
		return ResponseEntity.ok(empService.getEmployeeListByFiltersStr());
	}
}
