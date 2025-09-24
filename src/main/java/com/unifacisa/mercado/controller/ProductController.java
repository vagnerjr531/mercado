package com.unifacisa.mercado.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.mercado.entities.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping//metodo que responde a requisição ao tipo get do http.
	public ResponseEntity<Product> findAll(){//find All retorno os Productes.
		Product p  = new Product("caneta",20.8 , 2);//instanciando um Producte
		return ResponseEntity.ok().body(p); //retorna .ok() retorna resposta com sucesso no http, o corpo da resposta o usuario c .
	}

}
