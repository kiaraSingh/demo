package com.hackathon.demo.exceptionhandler;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8194700151567558495L;

	public EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
