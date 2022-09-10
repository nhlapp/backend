package com.nhl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nhl.backend.models.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, String> {

	User findByEmail(String email);
	
	User findByUsername(String username);
}
