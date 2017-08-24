package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

public interface PersonDAO extends EntityDAO<Person, Long>{

	Person relatePersons(Iterable<Person> person);
	
}
