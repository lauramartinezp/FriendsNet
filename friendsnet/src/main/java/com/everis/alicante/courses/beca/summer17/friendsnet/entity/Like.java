package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="LIKETABLE")
@EqualsAndHashCode(callSuper = false, exclude = { "likesByPost","likesByPerson" })
public class Like implements FNEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="like_id", nullable=false, unique=true)
	private Long id;
	@CreationTimestamp
	private Date creationDate;
	@Enumerated(EnumType.STRING)
	private LikeType type;
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person likesByPerson;
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post likesByPost;
	
	
}