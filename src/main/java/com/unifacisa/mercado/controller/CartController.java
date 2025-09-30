package com.unifacisa.mercado.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.mercado.entities.Cart;
import com.unifacisa.mercado.services.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping
	public void registerCart(@RequestBody Cart cart) {
		
		cartService.registerCart(cart);
	}
	
    @PostMapping("/{cartId}/add-product/{productId}")
    public Cart addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return cartService.addProductToCart(cartId, productId);
    }
	
	
    @GetMapping
    public List<Cart> listarCarts(){
        return cartService.listCarts();
    }	
    
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
	
}

