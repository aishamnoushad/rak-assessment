package com.aisha.assessment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisha.assessment.entity.Department;
import com.aisha.assessment.entity.Employee;
import com.aisha.assessment.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	// get all employees
		@GetMapping("/employees/department")
		public List<Department> getAllDepartments(){
			return employeeService.getAllDepartments();
		}	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}		
	
	// create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		return employeeService.createEmployee(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	// update employee rest api
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		return employeeService.updateEmployee(id, employeeDetails);
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/employees/{id}/{employeeName}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name="id") Long id, @PathVariable(name="employeeName") String name){
		return employeeService.getEmployeeByIdAndName(id, name);
	}
}
