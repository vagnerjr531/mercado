package com.unifacisa.mercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.mercado.entities.Client;
import com.unifacisa.mercado.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	@PostMapping
	public void registerProduct(@RequestBody Client client) {
		
		clientService.registerClient(client);
	}
	
    @GetMapping
    public List<Client> listarClients(){
    	
        return clientService.listClients();
    }	
	
}
