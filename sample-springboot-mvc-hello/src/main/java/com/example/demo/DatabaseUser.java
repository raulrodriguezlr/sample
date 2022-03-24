package com.example.demo;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class DatabaseUser {
	@Autowired
	private UserRepository blogUserRepository;
	
	@PostConstruct
	public void userDB() {
		blogUserRepository.saveAll(Arrays.asList(
			new Usuario("Pepe", "Sanchez", 48201145),
			new Usuario("Raul", "Rodriguez", 48205513),
			new Usuario("Jorge", "Rodriguez ", 48205515)));
	} 
}