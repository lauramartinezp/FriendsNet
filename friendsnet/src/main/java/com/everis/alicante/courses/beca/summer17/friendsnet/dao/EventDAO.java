package com.everis.alicante.courses.beca.summer17.friendsnet.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Event;

@Service
public interface EventDAO extends CrudRepository<Event, Long>, EntityDAO<Event, Long>{

}
