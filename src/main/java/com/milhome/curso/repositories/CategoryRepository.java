package com.milhome.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milhome.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
