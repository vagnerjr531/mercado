package com.unifacisa.mercado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.mercado.entities.Cart;
import com.unifacisa.mercado.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void registerCart(Cart cart){
    	cartRepository.save(cart);
    }

    public List<Cart> listCarts(){
        return  cartRepository.findAll();
    }
		
}
