package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.EventType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name = "event")
public class Event implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id", nullable = false, unique = true)
	private Long id;

	private String name;

	private Date startingDate;

	private Date endingDate;

	private EventType type;

	private byte[] picture;

	@ManyToMany
	@JoinColumn(name = "person_id", nullable = false, unique = true)
	@JsonIgnore
	private Set<Person> events;

	@OneToMany
	@JsonIgnore
	private Set<Post> posts;
}
