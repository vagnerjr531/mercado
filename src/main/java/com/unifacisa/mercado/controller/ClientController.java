package com.unifacisa.mercado.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.mercado.entities.Client;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@GetMapping//metodo que responde a requisição ao tipo get do http.
	public ResponseEntity<Client> findAll(){//find All retorno os clientes.
		Client c  = new Client(1L,"junior@gmail","8555555","ruadascarambolas",LocalDate.of(2025, 9, 25));//instanciando um cliente
		return ResponseEntity.ok().body(c); //retorna .ok() retorna resposta com sucesso no http, o corpo da resposta o usuario c .
	}

}
