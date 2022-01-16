package com.milhome.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milhome.curso.entities.User;
import com.milhome.curso.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findByID(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User entidade = repository.getById(id);
		updateData(entidade, user);
		return repository.save(entidade);
	}

	private void updateData(User entidade, User user) {
		entidade.setName(user.getName());
		entidade.setEmail(user.getEmail());
		entidade.setFone(user.getFone());
	}
	
}
