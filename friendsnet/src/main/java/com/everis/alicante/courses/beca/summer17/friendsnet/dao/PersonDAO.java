package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

@Service
public interface PersonDAO extends CrudRepository<Person, Long>, EntityDAO<Person, Long>{

	@Query ("SELECT p from Person p")
	Person relatePersons(Long id, List<Long> ids);
	
}
