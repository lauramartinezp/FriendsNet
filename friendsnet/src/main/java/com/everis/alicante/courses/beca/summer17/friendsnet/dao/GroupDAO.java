package com.everis.alicante.courses.beca.summer17.friendsnet.dao;


import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

public interface GroupDAO extends EntityDAO<Group, Long> {
	
	public Group addPersons(Iterable<Person> persons);

}