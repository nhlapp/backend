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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
public class Tournament extends AbstractPersistable<Long> {

	@NotNull
	@Length(min = 3, max = 20)
	private String name;
	
	@NotNull
	private String founder;
	
	private Integer rounds;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<User> users = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY)
	private List<Message> messages = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY)
	private List<Game> games = new ArrayList<>();
}
