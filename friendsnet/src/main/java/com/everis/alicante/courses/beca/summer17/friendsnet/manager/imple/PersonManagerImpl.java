package com.everis.alicante.courses.beca.summer17.friendsnet.manager.imple;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.EntityDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.AbstractManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

@Service
public class PersonManagerImpl extends AbstractManager<Person, Long> implements PersonManager{

	@Autowired
	private PersonDAO persondao;
	
	@Override
	public Person relatePersons(Long id, Iterable<Long> ids) {
		Person person = persondao.findOne(id);
		Set<Person> persons = StreamSupport.stream(ids.spliterator(), false).map(persondao::findOne).collect(Collectors.toSet());
//		Set<Person> personsx = new HashSet<>();
//		for(Long idx: ids) {
//			personsx.add(persondao.findOne(idx));
//		}
		person.getPersons().addAll(persons);
		return persondao.save(person);
	}

	@Override
	protected PersonDAO getEntityDAO() {
		return persondao;
	}

	
	
	


}
