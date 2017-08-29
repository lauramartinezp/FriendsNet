package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

@Service
public interface PersonDAO extends CrudRepository<Person, Long>, EntityDAO<Person, Long>{

	
}
