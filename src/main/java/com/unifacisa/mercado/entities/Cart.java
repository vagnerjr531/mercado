package com.unifacisa.mercado.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="carts")
public class Cart{

			
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;

	
    @ManyToMany
    @JoinTable(
        name = "cart_products",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonIdentityInfo(
    		  generator = ObjectIdGenerators.PropertyGenerator.class,
    		  property = "id"
    		)
	private List<Product> products = new ArrayList<Product>();
	

    
	public Cart() {
		

	}

	public Cart(Long id) {
		
		this.id = id;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Product> getProducts() {
	    return products;
	}

	public void setProducts(List<Product> products) {
	    this.products = products;
	}

	public void setClient(Client client) {
		
		this.client = client;
		
	}
	
	

}
