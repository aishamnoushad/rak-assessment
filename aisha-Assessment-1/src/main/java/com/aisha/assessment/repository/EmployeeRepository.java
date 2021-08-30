package com.aisha.assessment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aisha.assessment.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
	@Query(value = "Select * FROM employee e WHERE e.employee_number = :id and e.employee_name=:name ",nativeQuery = true)
	Optional<Employee> findByIdAndName(@Param("id") Long id,@Param("name") String Name);

}
