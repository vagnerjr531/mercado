package com.unifacisa.mercado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.mercado.entities.Product;
import com.unifacisa.mercado.repository.ProductRepository;

@Service
public class ProductService {
	
    @Autowired
    private ProductRepository productRepository;

    public void registerProduct(Product product){
    	productRepository.save(product);
    }

    public List<Product> listProducts(){
        return  productRepository.findAll();
    }

}
