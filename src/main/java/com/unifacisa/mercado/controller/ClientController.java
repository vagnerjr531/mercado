package com.unifacisa.mercado.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.mercado.entities.Client;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@GetMapping // metodo que responde a requisição ao tipo GET do http.
	public ResponseEntity<Client> findAll() { // findAll retorna um cliente
		Client c = new Client(1L, "junior@gmail", "8555555", "ruadascarambolas", LocalDate.of(2025, 9, 25)); // instanciando um cliente
		return ResponseEntity.ok().body(c); // retorna .ok() com o cliente "c"
	}

	@GetMapping("/list") // novo endpoint: GET /clients/list
	public ResponseEntity<List<Client>> listAll() {
		List<Client> clients = new ArrayList<>();
		clients.add(new Client(1L, "junior@gmail", "8555555", "ruadascarambolas", LocalDate.of(2025, 9, 25)));
		clients.add(new Client(2L, "maria@gmail", "9777777", "avenida central", LocalDate.of(2024, 5, 15)));
		clients.add(new Client(3L, "joao@gmail", "9666666", "praca das flores", LocalDate.of(2023, 12, 1)));

		return ResponseEntity.ok().body(clients); // retorna lista de clientes
	}
}
