package com.nhl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhl.backend.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByEmail(String email);
}
