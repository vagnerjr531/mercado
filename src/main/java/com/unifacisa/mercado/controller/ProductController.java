package com.unifacisa.mercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.mercado.entities.Product;
import com.unifacisa.mercado.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping
	public void registerProduct(@RequestBody Product product) {
		
		productService.registerProduct(product);
	}
	
	
    @GetMapping
    public List<Product> listarProducts(){
        return productService.listProducts();
    }	
	

}
