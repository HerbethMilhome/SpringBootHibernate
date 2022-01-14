package com.milhome.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milhome.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
