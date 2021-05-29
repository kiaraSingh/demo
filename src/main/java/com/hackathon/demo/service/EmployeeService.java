package com.hackathon.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackathon.demo.entities.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	Employee addEmployee(Employee employee);

	List<Employee> getEmployeeByNameAndRole(String name, String role);

	Employee replaceEmployee(Employee employee, Long id);

	void deleteEmployee(Long id);

}
