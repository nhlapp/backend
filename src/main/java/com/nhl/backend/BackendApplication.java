package com.nhl.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nhl.backend.models.Tournament;
import com.nhl.backend.models.User;
import com.nhl.backend.repositories.TournamentRepository;
import com.nhl.backend.repositories.UserRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TournamentRepository tournamentRepository, UserRepository userRepository) {
		return (args) -> {
			User user = new User();
			user.setEmail("pakniiles@gmail.com");
			user.setUsername("niikari");
			user.setPassword("hipsairas");
			userRepository.save(user);
			
			User user2 = new User();
			user2.setEmail("belinda@gmail.com");
			user2.setUsername("nora");
			user2.setPassword("hipsairas");
			userRepository.save(user2);
			
			Tournament tour = new Tournament();
			tour.setFounder("Niiles");
			tour.setRounds(3);
			tour.setName("The best");
			tour.getUsers().add(user2);
			tour.getUsers().add(user);
			tournamentRepository.save(tour);
			
			Tournament tour2 = new Tournament();
			tour2.setFounder("Nora");
			tour2.setRounds(2);
			tour2.setName("Unbelievable");
			tour2.getUsers().add(user2);
			tour2.getUsers().add(user);
			tournamentRepository.save(tour2);
		};
	}

}
