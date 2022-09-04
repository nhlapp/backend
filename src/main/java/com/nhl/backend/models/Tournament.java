package com.nhl.backend.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tournament extends AbstractPersistable<Long> {

	@NotNull
	@Length(min = 3, max = 20)
	private String name;
	
	@NotNull
	private String founder;
	
	@NotNull
	@Length(min = 1, max = 3)
	private Integer rounds;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> users = new ArrayList<>();

	@OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY)
	private List<Message> messages = new ArrayList<>();
	
	@OneToMany(mappedBy = "tournament")
	private List<Game> games = new ArrayList<>();
}
