package com.unifacisa.mercado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.mercado.entities.Employee;
import com.unifacisa.mercado.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
    @Autowired
    private EmployeeRepository employeeRepository;

    public void registerEmployee(Employee employee){
    	employeeRepository.save(employee);
    }

    public List<Employee> listEmployees(){
        return  employeeRepository.findAll();
    }

}
