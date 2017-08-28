package com.everis.alicante.courses.beca.summer17.friendsnet.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Group")
public class Group implements FNEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="groupp_id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "name", length = 200)
	private String name;

	@Column(name ="picture")
	private byte[] picture;
	
	
	
}