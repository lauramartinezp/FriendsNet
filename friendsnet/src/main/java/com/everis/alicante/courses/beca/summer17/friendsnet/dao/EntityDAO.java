package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import java.io.Serializable;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.FNEntity;

public interface EntityDAO<E extends FNEntity, ID extends Serializable>{
	
	Iterable<E> findAll();
	
	E findById(ID id);
	
	void save (E e);
	
	void save (Iterable<E> es);
	
	void update (E e);
	
	void update (Iterable<E> es);
	
	void remove(E e);
}
