package com.athensoft.edusys.hr.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.athensoft.edusys.error.exceptions.EmployeeAlreadyExistsException;
import com.athensoft.edusys.error.exceptions.EmployeeNotFoundException;
import com.athensoft.edusys.hr.dao.EmployeeRepository;
import com.athensoft.edusys.hr.entity.Employee;
import com.athensoft.edusys.hr.entity.EmploymentType;
import com.athensoft.edusys.hr.entity.RoleType;
import com.athensoft.edusys.utils.validation.GlobalValidationUtils;

@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	private final EmployeeRepository empRepo;
	
	public EmployeeService(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	public List<Employee> getEmployeeList(){
		return empRepo.findAll();
	}
	
	public Employee getEmployeeById(Integer empId) {
		return empRepo.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException(empId));
	}
	
	public List<Employee> getEmployeeListByFilters(
			Optional<Integer> empId,
			String empCode,
			String empFirstName,
			String empLastName,
			String email,
			Optional<Integer> empType,
			Date hireDate,
			Date expiryDate,
			Optional<Integer> roleType,
			String phoneNumber){
		
		List<String> ignoredProperties = new ArrayList<>();
		Employee employee = new Employee();
		if(empId.isEmpty()) {
			ignoredProperties.add("empId");
		}else {
			employee.setEmpId(empId.get());
		}
		if(empType.isEmpty()) {
			ignoredProperties.add("empType");
		}else {
			employee.setEmpType(EmploymentType.values()[empType.get()]);
		}
//		if(roleType.isEmpty()) {
//			ignoredProperties.add("roleType");
//		}else {
//			employee.setRoleType(RoleType.values()[roleType.get()]);
//		}
		
		employee.setEmpCode(empCode);
		employee.setEmpFirstName(empFirstName);
		employee.setEmpLastName(empLastName);
		employee.setEmail(email);
		employee.setHireDate(hireDate);
		employee.setExpiryDate(expiryDate);
		employee.setPhoneNumber(phoneNumber);
		
		LOGGER.debug("searched employee:" + employee);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
		Example<Employee> example = Example.of(employee, exampleMatcher);
		LOGGER.debug("example student:" + example.toString());
		return empRepo.findAll(example);
	}
	
	public List<Employee> getEmployeeListByFiltersStr() throws ParseException{
		JSONObject obj = new JSONObject();
		obj.put("empId", "1");
		obj.put("empCode", "emp001");
		obj.put("empFirstName", "Kenny");
		obj.put("empLastName", "Zhang");
		obj.put("email", "kenny@gmail.com");
		obj.put("empType", "1");
		obj.put("hireDate", "2018-01-01");
		obj.put("expiryDate", "2019-12-31");
		obj.put("roleType", "1");
		obj.put("phoneNumber", "514-123-4567");
		String filterStr = obj.toString();
		JSONObject jobj = new JSONObject(filterStr);
		
		List<String> ignoredProperties = new ArrayList<>();
		String empIdStr = jobj.getString("empId").trim();
		String empCode = jobj.getString("empCode").trim();
		String empFirstName = jobj.getString("empFirstName").trim();
		String empLastName = jobj.getString("empLastName").trim();
		String email = jobj.getString("email").trim();
		String empTypeStr = jobj.getString("empType").trim();
		String hireDateStr = jobj.getString("hireDate").trim();
		String expiryDateStr = jobj.getString("expiryDate").trim();
		String roleTypeStr = jobj.getString("roleType").trim();
		String phoneNumber = jobj.getString("phoneNumber").trim();
		
		Employee employee = new Employee();
		if (GlobalValidationUtils.isEmptyStr(empIdStr)) {
			ignoredProperties.add("empId");
		}else {
			employee.setEmpId(Integer.valueOf(empIdStr));
		}
		
		if (GlobalValidationUtils.isEmptyStr(empCode)) {
			ignoredProperties.add("empCode");
		}else {
			employee.setEmpCode(empCode);
		}
		
		if (GlobalValidationUtils.isEmptyStr(empFirstName)) {
			ignoredProperties.add("empFirstName");
		}else {
			employee.setEmpFirstName(empFirstName);
		}
		
		if (GlobalValidationUtils.isEmptyStr(empLastName)) {
			ignoredProperties.add("empLastName");
		}else {
			employee.setEmpLastName(empLastName);
		}
		
		if (GlobalValidationUtils.isEmptyStr(email)) {
			ignoredProperties.add("email");
		}else {
			employee.setEmail(email);
		}
		
		if (GlobalValidationUtils.isEmptyStr(empTypeStr)) {
			ignoredProperties.add("empType");
		}else {
			EmploymentType empType = EmploymentType.values()[Integer.valueOf(empTypeStr)];
			employee.setEmpType(empType);
		}
		
		if (GlobalValidationUtils.isEmptyStr(hireDateStr)) {
			ignoredProperties.add("hireDate");
		}else {
			Date hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(hireDateStr);
			employee.setHireDate(hireDate);
		}
		
		if (GlobalValidationUtils.isEmptyStr(phoneNumber)) {
			ignoredProperties.add("phoneNumber");
		}else {
			employee.setPhoneNumber(phoneNumber);
		}
		
//		if (GlobalValidationUtils.isEmptyStr(roleTypeStr)) {
//			ignoredProperties.add("roleType");
//		}else {
//			RoleType roleType = RoleType.values()[Integer.valueOf(roleTypeStr)];
//			employee.setRoleType(roleType);
//		}
		
		if (GlobalValidationUtils.isEmptyStr(expiryDateStr)) {
			ignoredProperties.add("expiryDate");
		}else {
			Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDateStr);
			employee.setExpiryDate(expiryDate);
		}
		LOGGER.debug("searched employee:" + employee);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
		if (!ignoredProperties.isEmpty()) {
			exampleMatcher = exampleMatcher.withIgnorePaths(ignoredProperties.toArray(new String[0]));
		}
		Example<Employee> example = Example.of(employee, exampleMatcher);
		LOGGER.debug("example employee:" + example.toString());
		return empRepo.findAll(example);
	}
	
	public ResponseEntity<Employee> createEmloyee(Employee employee){
		checkEmployeeAlreadyExistsException(employee);
		
		return new ResponseEntity<>(empRepo.save(employee), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Employee> updateEmloyee(Employee employee){
		checkEmployeeNotFoundException(employee);
		
		return ResponseEntity.ok(empRepo.save(employee));
	}
	
	public ResponseEntity<String> deleteEmployee(Employee employee){
		checkEmployeeNotFoundException(employee);
		
		return ResponseEntity.ok("Employee " + employee + " is deleted successfully!");
	}
	
	public ResponseEntity<String> deleteEmployeeById(Integer empId){
		checkEmployeeNotFoundException(empId);
		
		return ResponseEntity.ok("Employee " + empId + " is deleted successfully!");
	}
	
	
	private void checkEmployeeAlreadyExistsException(Employee employee) {
		if (empRepo.existsById(employee.getEmpId())) {
			throw new EmployeeAlreadyExistsException(employee);
		}
	}
	
	private void checkEmployeeNotFoundException(Employee employee) {
		if (!empRepo.existsById(employee.getEmpId())) {
			throw new EmployeeNotFoundException(employee);
		}
	}
	
	private void checkEmployeeNotFoundException(Integer empId) {
		if (!empRepo.existsById(empId)) {
			throw new EmployeeNotFoundException(empId);
		}
	}


}
