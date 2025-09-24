package com.unifacisa.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.mercado.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	
}

