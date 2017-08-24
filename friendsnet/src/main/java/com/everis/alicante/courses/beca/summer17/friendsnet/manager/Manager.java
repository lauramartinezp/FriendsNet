package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import java.io.Serializable;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.FNEntity;

public interface Manager<E extends FNEntity, ID extends Serializable> {
	Iterable<E> findAll();
	
	E findById(ID id);
	
	E save (E e);
	
	Iterable<E> save (Iterable<E> es);
	
	E update (E e);
	
	Iterable<E> update (Iterable<E> es);
	
	void remove(ID id);
}
