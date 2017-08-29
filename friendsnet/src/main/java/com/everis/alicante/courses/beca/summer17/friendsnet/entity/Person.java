package com.everis.alicante.courses.beca.summer17.friendsnet.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "PERSON")
@EqualsAndHashCode(callSuper = false, exclude = { "persons" })
public class Person implements FNEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "person_id")
	private Long id;
	private String name;
	private String surname;
	private byte[] picture;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "persons", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "person_id") })
	@JsonIgnore
	private Set<Person> persons;

	@ManyToMany(mappedBy = "persons")
	@JsonIgnore
	private Set<Person> person;

	@ManyToMany(mappedBy = "personsInGroup")
	@JsonIgnore
	private Set<Group> groups;

	@OneToMany(mappedBy = "likesByPerson")
	@JsonIgnore
	private Set<Like> likes;

	@OneToMany(mappedBy = "postsByPerson")
	@JsonIgnore
	private Set<Post> posts;

	@ManyToMany(mappedBy = "personsEvent")
	@JsonIgnore
	private Set<Event> events;
}
