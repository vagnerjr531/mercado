package com.unifacisa.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.mercado.entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long>{
	
}

