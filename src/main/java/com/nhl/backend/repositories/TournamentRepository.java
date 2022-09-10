package com.nhl.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nhl.backend.models.Tournament;

@RepositoryRestResource
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
	
	@EntityGraph(attributePaths = {"users", "users.tournaments"})
	List<Tournament> findAll();

}
