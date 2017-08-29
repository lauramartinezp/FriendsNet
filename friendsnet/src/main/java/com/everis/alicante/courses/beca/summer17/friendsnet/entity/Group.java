package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity(name="GROUP")
public class Group implements FNEntity {

	@Id
	@GeneratedValue
	@Column(name="GROUPTABLE_ID")
	private Long id;
	private String name;
	private byte[] picture;
	
	@ManyToMany
	@JoinColumn(name="person_id")
	private Set<Person> personsInGroup;
}