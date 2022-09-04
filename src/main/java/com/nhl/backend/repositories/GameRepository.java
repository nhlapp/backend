package com.nhl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhl.backend.models.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
