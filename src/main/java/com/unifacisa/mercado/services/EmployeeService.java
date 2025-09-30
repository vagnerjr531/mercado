package com.unifacisa.mercado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.mercado.entities.Employee;
import com.unifacisa.mercado.entities.Manager;
import com.unifacisa.mercado.repository.EmployeeRepository;
import com.unifacisa.mercado.repository.ManagerRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ManagerRepository managerRepository;

	public void registerEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<Employee> listEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

		employee.setName(employeeDetails.getName());
		employee.setManager(employeeDetails.getManager());

		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		employeeRepository.delete(employee);
	}
	public Employee changeManager(Long employeeId, Long newManagerId) {
	    Employee employee = employeeRepository.findById(employeeId)
	            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + employeeId));

	    Manager newManager = managerRepository.findById(newManagerId)
	            .orElseThrow(() -> new RuntimeException("Gerente não encontrado com ID: " + newManagerId));

	    employee.setManager(newManager);
	    return employeeRepository.save(employee);
	}

}
