package com.hackathon.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.demo.entities.Employee;
import com.hackathon.demo.exceptionhandler.EmployeeNotFoundException;
import com.hackathon.demo.repository.EmployeeRepository;
import com.hackathon.demo.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> getEmployeeByNameAndRole(String name, String role) {
		return repository.findByNameAndRole(name, role);
	}

	@Override
	public Employee replaceEmployee(Employee newEmployee, Long id) {
		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repository.save(newEmployee);
		});
	}

	@Override
	public void deleteEmployee(Long id) {
		repository.deleteById(id);

	}

}
