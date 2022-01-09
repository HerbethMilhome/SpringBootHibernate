package com.milhome.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milhome.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
