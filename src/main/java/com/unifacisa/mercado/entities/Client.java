package com.unifacisa.mercado.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Id;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="clients")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Cart cart;
    
	private String name;
	private String email;

	
	public Client() {
	}
	
	
	public Client(Long id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
