package com.nhl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nhl.backend.models.Game;

@RepositoryRestResource
public interface GameRepository extends JpaRepository<Game, Long> {

}
