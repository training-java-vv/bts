package com.ibm.employee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.employee.entity.Employee;
import com.ibm.employee.service.EmployeeService;

@RestController

public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * method to create employee
	 * 
	 * @param employee
	 * @param bindingResult returns employee id
	 */
	@PostMapping("/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createEmployee(@RequestBody @Valid Employee employee, BindingResult bindingResult) {
		validateEmployee(bindingResult);
		System.out.println(employee);
		return employeeService.createEmployee(employee);
	}

	private void validateEmployee(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry.");
		}
	}

	/**
	 * method to search all employees returns list of employees
	 */
	@GetMapping("/employee")
	List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	/**
	 * method to search for employee by id
	 * 
	 * @param employeeId
	 * @returns zero or matching employee
	 */
	@GetMapping("/employee/{id}")
	Optional<Employee> getEmployee(@PathVariable("id") String employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	/**
	 * method to update employee details
	 * 
	 * @param employee
	 * @param bindingResult
	 * @param employeeId
	 */
	@PutMapping("/employee/{id}")
	void updateEmployee(@RequestBody @Valid Employee employee, BindingResult bindingResult,
			@PathVariable("id") String employeeId) {
		validateEmployee(bindingResult);
		System.out.println(employeeId);
		employee.setId(employeeId);
		employeeService.updateEmployee(employee);
	}
}
