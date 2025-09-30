package com.unifacisa.mercado.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.mercado.entities.Employee;
import com.unifacisa.mercado.entities.Manager;
import com.unifacisa.mercado.repository.EmployeeRepository;
import com.unifacisa.mercado.repository.ManagerRepository;


@Service
public class ManagerService {
	
    @Autowired
    private ManagerRepository managerRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public void registerManager(Manager manager){
    	managerRepository.save(manager);
    }

    public List<Manager> listManagers(){
        return  managerRepository.findAll();
    }
    
    public Manager updateManager(Long id, Manager managerDetails) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found with id: " + id));

        manager.setName(managerDetails.getName());

        return managerRepository.save(manager);
    }

    public void deleteManager(Long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found with id: " + id));
        managerRepository.delete(manager);
    }
    
    public Manager addEmployeeToManager(Long managerId, Long employeeId) {
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));


        manager.getEmployees().add(employee);

        employee.setManager(manager);

        employeeRepository.save(employee);
        
        return managerRepository.save(manager);
    }

    public Manager removeEmployeeFromManager(Long managerId, Long employeeId) {
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (manager.getEmployees() != null) {
            manager.getEmployees().remove(employee);
        }

        employee.setManager(null);

        employeeRepository.save(employee);
        
        return managerRepository.save(manager);
    }

}
