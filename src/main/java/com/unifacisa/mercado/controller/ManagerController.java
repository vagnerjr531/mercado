package com.unifacisa.mercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.mercado.entities.Manager;
import com.unifacisa.mercado.services.ManagerService;


@RestController
@RequestMapping("/managers")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	
	@PostMapping
	public void registerManager(@RequestBody Manager manager) {
		
		managerService.registerManager(manager);
	}
	
	
    @GetMapping
    public List<Manager> listarManager(){
        return managerService.listManagers();
    }	

}
