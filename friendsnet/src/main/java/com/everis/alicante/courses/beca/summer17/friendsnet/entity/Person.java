package com.everis.alicante.courses.beca.summer17.friendsnet.entity;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, exclude={"friends"})
@Entity
@Table(name = "persons")
public class Person implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private Long id;

	private String name;

	private String surname;

	private byte[] picture;

	@ManyToMany(mappedBy = "groups")
	@JsonIgnore
	private Set<Group> groups;

	@OneToMany(mappedBy = "likes")
	@JsonIgnore
	private Set<Like> likes;

	@OneToMany(mappedBy = "posts")
	@JsonIgnore
	private Set<Post> posts;

	@ManyToMany(mappedBy = "events")
	@JsonIgnore
	private Set<Event> events;

}
