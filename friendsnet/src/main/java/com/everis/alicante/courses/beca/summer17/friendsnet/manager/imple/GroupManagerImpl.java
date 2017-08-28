package com.everis.alicante.courses.beca.summer17.friendsnet.manager.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.AbstractManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;

@Service
public class GroupManagerImpl extends AbstractManager<Group, Long> implements GroupManager {
	
	@Autowired
	private GroupDAO groupDAO;

	@Override
	public Group addPersons(Iterable<Person> persons) {
		return groupDAO.addPersons(persons);
	}

}