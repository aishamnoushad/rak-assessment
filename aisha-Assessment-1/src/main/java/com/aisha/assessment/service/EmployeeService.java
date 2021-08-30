package com.aisha.assessment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aisha.assessment.entity.Department;
import com.aisha.assessment.entity.Employee;
import com.aisha.assessment.exception.ResourceNotFoundException;
import com.aisha.assessment.repository.DepartmentRepository;
import com.aisha.assessment.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Department> getAllDepartments(){
		return departmentRepository.findAll();
		
	}

	

	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	
	public ResponseEntity<Employee> getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	

	public ResponseEntity<Employee> updateEmployee( Long id, Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setEmployeeName(employeeDetails.getEmployeeName());
		employee.setDepartment(employeeDetails.getDepartment());
		employee.setDateOfJoining(employeeDetails.getDateOfJoining());
		employee.setSalary(employeeDetails.getSalary());
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	
	public ResponseEntity<Map<String, Boolean>> deleteEmployee( Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}



	public ResponseEntity<Employee> getEmployeeByIdAndName(Long id, String name) {
		Employee employee = employeeRepository.findByIdAndName(id,name)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}

}
