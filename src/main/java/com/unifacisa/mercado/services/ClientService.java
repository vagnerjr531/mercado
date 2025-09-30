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
    
    public Client updateClient(Long id, Client clientDetails) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        
        client.setName(clientDetails.getName());
        client.setEmail(clientDetails.getEmail());
        
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        clientRepository.delete(client);
    }
	
	

}
