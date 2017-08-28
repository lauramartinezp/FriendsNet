package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

public interface PersonManager extends Manager<Person, Long> {

	
	public Person relatePersons(Long id, Iterable<Long> ids);
	
}
