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
@Table(name= "Person")
public class Person implements FNEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "person_id", unique=true, nullable=false)
	private Long id;
	
	@Column(name ="name", length = 200)
	private String name;
	
	@Column(name ="surname",length = 200)
	private String surname;
	
	@Column(name ="picture")
	private byte[] picture;
	


}
