package com.unifacisa.mercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.mercado.entities.Employee;
import com.unifacisa.mercado.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public void registerEmployee(@RequestBody Employee employee) {
		
		employeeService.registerEmployee(employee);
	}
	
	
    @GetMapping
    public List<Employee> listarEmployee(){
    	
        return employeeService.listEmployees();
    }	
}
