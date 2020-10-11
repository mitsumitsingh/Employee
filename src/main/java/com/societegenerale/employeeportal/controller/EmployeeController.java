package com.societegenerale.employeeportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.societegenerale.employeeportal.model.Employee;
import com.societegenerale.employeeportal.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")// Used to take the request from angular
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
    private EmployeeRepository employeeRepository;

	// Get all the employees details
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllByFirstNameAsc();
    }
    
    // Save a employee detail
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {    	
        return employeeRepository.save(employee);
    }
}
