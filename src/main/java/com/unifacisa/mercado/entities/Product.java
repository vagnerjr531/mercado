package com.unifacisa.mercado.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;




@Entity
@Table(name="products")
public class Product {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @ManyToMany(mappedBy = "products")
    @JsonIdentityInfo(
    		  generator = ObjectIdGenerators.PropertyGenerator.class,
    		  property = "id"
    		)
    private List<Cart> carts;
	
	private String name;
	private Double price;
	private int stock;
	
	public Product() {

	}

	public Product(String name, Double price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.carts = new ArrayList<Cart>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Long getId() {
		
		return this.id;
	}

}
