package com.societegenerale.employeeportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.societegenerale.employeeportal.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
