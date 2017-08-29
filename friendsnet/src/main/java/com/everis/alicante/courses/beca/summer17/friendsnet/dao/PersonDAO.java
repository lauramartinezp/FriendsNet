package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import java.util.List;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
public interface PersonDAO extends EntityDAO<Person, Long>{

	Person relatePersons(Long id, List<Long> ids);
	
}
