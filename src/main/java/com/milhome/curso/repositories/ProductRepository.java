package com.milhome.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milhome.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
