package com.hackathon.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.demo.entities.Employee;
import com.hackathon.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	List<Employee> all() {
		return employeeService.getAllEmployees();
	}

	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return employeeService.addEmployee(newEmployee);
	}

	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {

		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/employees/{name}/{role}")
	List<Employee> findByNameAndRole(@PathVariable String name, @PathVariable String role) {

		return employeeService.getEmployeeByNameAndRole(name, role);
	}

	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return employeeService.replaceEmployee(newEmployee, id);

	}

	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}
}
