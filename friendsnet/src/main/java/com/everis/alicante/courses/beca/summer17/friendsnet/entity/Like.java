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
@Table(name = "Like")
public class Like implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "like_id", nullable = false, unique = true)
	private Long id;

	@Column(name ="date", length = 20)
	private Date creationDate;

	@Column(name ="type", length = 20)
	private LikeType type;



}
