package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Post")
public class Post implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id", unique=true, nullable=false)
	private Long id;

	@Column(name ="text", length = 200)
	private String text;

	@Column(name ="date", length = 20)
	private Date creationDate;

	@Column(name ="type", length = 20)
	private PostType type;

	@Column(name ="picture")
	private byte[] picture;


}
