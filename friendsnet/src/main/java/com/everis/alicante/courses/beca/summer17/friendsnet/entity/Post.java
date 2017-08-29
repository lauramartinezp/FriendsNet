package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.PostType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="POST")
public class Post implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="post_id")
	private Long id;
	private String text;
	
	@CreationTimestamp
	private Date creationDate;
	
	@Enumerated(EnumType.STRING)
	private PostType type;
	private byte[] picture;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person postsByPerson;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;
	
	@OneToMany(mappedBy="likesByPost", cascade = { CascadeType.ALL })
	@JsonIgnore
	private Set<Like> likes;

}
