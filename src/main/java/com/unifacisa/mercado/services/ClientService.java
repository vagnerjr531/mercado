package com.unifacisa.mercado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.mercado.entities.Client;
import com.unifacisa.mercado.repository.ClientRepository;

@Service
public class ClientService {
	
    @Autowired
    private ClientRepository clientRepository;

    public void registerClient(Client client){
    	clientRepository.save(client);
    }

    public List<Client> listClients(){
        return  clientRepository.findAll();
    }
	
	

}
