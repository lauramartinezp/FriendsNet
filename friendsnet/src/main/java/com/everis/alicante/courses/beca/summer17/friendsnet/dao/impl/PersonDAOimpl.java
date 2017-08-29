package com.everis.alicante.courses.beca.summer17.friendsnet.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.AbstractDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;

@Service
public class PersonDAOimpl extends AbstractDAO<Person, Long> implements PersonDAO{


	@Override
	public Person relatePersons(Long id, List<Long> ids) {
        Person person = this.findById(id);
        List<Person> persons = new ArrayList<Person>();
        this.findByIds(ids).forEach(persons::add);
       // person.relate(persons);
        this.update(person);
        return person;
	}

}
