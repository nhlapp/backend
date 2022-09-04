package com.nhl.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhl.backend.models.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {

}
