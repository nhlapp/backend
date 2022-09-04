package com.nhl.backend.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game extends AbstractPersistable<Long> {

	@ManyToOne
	private Tournament tournament;
	
	@ManyToOne
	@JoinColumn(name = "home")
	private User home;
	
	@ManyToOne
	@JoinColumn(name = "away")
	private User away;
	
	
}
