package com.nhl.backend.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message extends AbstractPersistable<Long> {

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Tournament tournament;
	
	@CreationTimestamp
	private Date date;
}
