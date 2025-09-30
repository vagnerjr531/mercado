package com.unifacisa.mercado.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Id;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="carts")
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
			
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
	private List<Product> products;
	
	
	public Cart() {
		
	}


	public Cart(Long id) {
		super();
		this.id = id;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

}
