package com.nhl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nhl.backend.models.Message;

@RepositoryRestResource
public interface MessageRepository extends JpaRepository<Message, Long> {

}
