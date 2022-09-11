package com.nhl.backend.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserTable")
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractPersistable<Long> {

	@NotNull
	@Length(min = 2, max = 20)
	private String username;
	
	//@Length(min = 6, max = 15)
	@NotNull
	private String password;
	
	@NotNull
	@Email
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String role;
	
	@ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<Tournament> tournaments = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Message> messages = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Friend> friends = new ArrayList<>();
	
	
}
