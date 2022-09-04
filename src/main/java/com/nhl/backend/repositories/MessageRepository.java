package com.nhl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhl.backend.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
