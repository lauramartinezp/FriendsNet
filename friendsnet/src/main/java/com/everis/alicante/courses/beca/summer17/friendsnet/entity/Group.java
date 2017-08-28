package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import lombok.Data;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Data
@Entity(name = "Grouptable")
public class Group implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "group_id", nullable = false, unique = true)
	private Long id;
	private String name;
	private byte[] picture;

	@ManyToMany
	@JoinColumn(name = "person_id", nullable = false, unique = true)
	private Set<Person> groups;

}