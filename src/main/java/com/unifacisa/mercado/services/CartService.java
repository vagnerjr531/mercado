package com.unifacisa.mercado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.mercado.entities.Cart;
import com.unifacisa.mercado.entities.Client;
import com.unifacisa.mercado.entities.Product;
import com.unifacisa.mercado.repository.CartRepository;
import com.unifacisa.mercado.repository.ClientRepository;
import com.unifacisa.mercado.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ClientRepository clientRepository;

    public void registerCart(Cart cart){
    	cartRepository.save(cart);
    }

    public List<Cart> listCarts(){
        return  cartRepository.findAll();
    }
    

    public void deleteCart(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + id));
        cartRepository.delete(cart);
    }
    

    public Cart addProductToCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + cartId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        cart.getProducts().add(product);

        return cartRepository.save(cart);
    }
    
    public Cart removeProductFromCart(Long cartId, Long productId) {

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + cartId));


        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        if (cart.getProducts() != null) {
        	cart.getProducts().remove(product);
        }

        return cartRepository.save(cart);
    }
    
    @Transactional
    public void associateCartToClient(Long cartId, Long clientId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        cart.setClient(client);
        client.setCart(cart);

        cartRepository.save(cart);
        clientRepository.save(client);
    }
		
}
