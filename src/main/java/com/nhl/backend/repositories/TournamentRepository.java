package com.nhl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhl.backend.models.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}
