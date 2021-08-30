package com.aisha.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aisha.assessment.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{

}
