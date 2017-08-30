package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="EVENT")
@EqualsAndHashCode(callSuper = false, exclude = { "personsEvent","posts" })
public class Event implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="event_id")
	private Long id;
	private String name;
	private Date startingDate;
	private Date endingDate;
	@Enumerated(EnumType.STRING)
	private EventType type;
	private byte[] picture;
	
	@ManyToMany
	@JoinColumn(name="person_id")
	@JsonIgnore
	private Set<Person> personsEvent;
	
	
	@OneToMany
	@JsonIgnore
	private Set<Post> posts;
	
}
