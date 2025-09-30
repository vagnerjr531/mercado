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

}
