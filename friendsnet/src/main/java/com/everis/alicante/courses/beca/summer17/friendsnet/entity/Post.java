package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.PostType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "postTable")
public class Post implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id", nullable = false, unique = true)
	@JsonIgnore
	private Long id;

	private String text;

	private Date creationDate;

	private PostType type;

	private byte[] picture;

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false, unique = true)
	private Person posts;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;
	
	@OneToMany(mappedBy = "likesByPost", cascade = { CascadeType.ALL })
	@JsonIgnore
	private Set<Like> likes;

}
