package com.milhome.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milhome.curso.entities.Product;
import com.milhome.curso.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findByID(Long id) {
		Optional<Product> product = repository.findById(id);
		return product.get();
	}

}
