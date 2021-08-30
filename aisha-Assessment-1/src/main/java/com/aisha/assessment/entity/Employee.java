package com.aisha.assessment.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name="employee")

public class Employee {
	@Id
	@Column(name="employee_number")
	Long id;
	//@NotNull(message = " is required")
	String employeeName;
	//@NotNull(message = " is required")
	LocalDate dateOfJoining;
	//@NotNull(message = " is required")
	Float salary;
	//@NotNull(message = " is required")
	//@Max(message =" it should contain 2  department code only ", value = 2)
	String department;
	
	@Transient
	@Autowired
	Department departmentDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Department getDepartmentDetails() {
		return departmentDetails;
	}

	public void setDepartmentDetails(Department departmentDetails) {
		this.departmentDetails = departmentDetails;
	}

//	public Employee(@NotNull(message = " is required") Long employeeNumber,
//			@NotNull(message = " is required") String employeeName,
//			@NotNull(message = " is required") LocalDate dateOfJoining, @NotNull(message = " is required") Float salary,
//			@NotNull(message = " is required") @Max(message = " it should contain 2  department code only ", value = 2) String department,
//			Department departmentDetails) {
//		super();
//		this.employeeNumber = employeeNumber;
//		this.employeeName = employeeName;
//		this.dateOfJoining = dateOfJoining;
//		this.salary = salary;
//		this.department = department;
//		this.departmentDetails = departmentDetails;
//	}
	
	public Employee() {
		
	}

	public Employee(Long employeeNumber, String employeeName, LocalDate dateOfJoining, Float salary, String department,
		Department departmentDetails) {
	super();
	this.id = employeeNumber;
	this.employeeName = employeeName;
	this.dateOfJoining = dateOfJoining;
	this.salary = salary;
	this.department = department;
	this.departmentDetails = departmentDetails;
}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + id + ", employeeName=" + employeeName + ", dateOfJoining="
				+ dateOfJoining + ", salary=" + salary + ", department=" + department + ", departmentDetails="
				+ departmentDetails + "]";
	}
	
	
	
	
	
}
