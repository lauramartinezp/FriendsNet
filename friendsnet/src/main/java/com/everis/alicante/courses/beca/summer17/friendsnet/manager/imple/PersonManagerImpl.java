package com.everis.alicante.courses.beca.summer17.friendsnet.manager.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}

	
	
	


}
