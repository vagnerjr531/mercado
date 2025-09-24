package com.unifacisa.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.mercado.entities.Cart;
import com.unifacisa.mercado.entities.Client;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{
	
}

