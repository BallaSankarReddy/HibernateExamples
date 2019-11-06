package com.spring.hibernate.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hibernate.model.Employee;
import com.spring.hibernate.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/emp")
	public Employee saveEmp(@RequestBody Employee emp) {
		employeeService.saveEmployee(emp);
		return emp;
	}
	
	@GetMapping("/empID/{empId}")
	public Employee getEmp(@PathVariable int empId) {
		
		return employeeService.getEmployee(empId);
	}
}
