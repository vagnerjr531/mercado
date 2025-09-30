package com.unifacisa.mercado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.mercado.entities.Manager;
import com.unifacisa.mercado.repository.ManagerRepository;


@Service
public class ManagerService {
	
    @Autowired
    private ManagerRepository managerRepository;

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

}
