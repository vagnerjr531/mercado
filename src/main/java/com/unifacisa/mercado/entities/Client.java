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
	private String phone;
	private String adress;

	private LocalDate registrationDate;
	
	public Client() {
	}
	
	
	public Client(Long id, String email, String phone, String adress, LocalDate registrationDate, String name) {
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.registrationDate = registrationDate;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
}
