package com.everis.alicante.courses.beca.summer17.friendsnet.manager.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;

@Service
public class GroupManagerImpl implements GroupManager {
	
	@Autowired
	GroupDAO groupDAO;

	@Override
	public Iterable<Group> findAll() {
		return groupDAO.findAll();
	}

	@Override
	public Group findById(Long id) {
		return groupDAO.findById(id);
	}

	@Override
	public Group save(Group e) {
		return groupDAO.save(e);
	}

	@Override
	public Iterable<Group> save(Iterable<Group> es) {
		return groupDAO.save(es);
	}

	@Override
	public Group update(Group e) {
		return groupDAO.update(e);
	}

	@Override
	public Iterable<Group> update(Iterable<Group> es) {
		return groupDAO.update(es);
	}

	@Override
	public void remove(Group e) {
		groupDAO.remove(e);
	}

	@Override
	public Group addPersons(Iterable<Person> persons) {
		// TODO Auto-generated method stub
		return null;
	}

}