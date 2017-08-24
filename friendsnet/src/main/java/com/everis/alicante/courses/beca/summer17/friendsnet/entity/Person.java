package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person implements FNEntity {
	@Id
	private Long id;

	private String name;

	private String surname;

	private byte picture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public byte getPicture() {
		return picture;
	}

	public void setPicture(byte picture) {
		this.picture = picture;
	}

}
