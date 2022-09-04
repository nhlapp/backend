package com.nhl.backend.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Friend extends AbstractPersistable<Long> {
	
	@NotNull
	@ManyToOne
	public User user;
	
	@CreationTimestamp
	public Date date;
	

}
