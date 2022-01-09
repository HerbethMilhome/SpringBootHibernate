package com.milhome.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.milhome.curso.entities.User;
import com.milhome.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria", "maria@gmail.com", "988888888", "12345");
		User u2 = new User(null, "João", "joao@gmail.com", "977777777", "12345");
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}
