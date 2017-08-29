package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import java.io.Serializable;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.FNEntity;

public interface Manager<E extends FNEntity, ID extends Serializable> {
	Iterable<E> findAll();
	
	E findOne(ID id);
	
	Iterable<E> findAll(Iterable<ID> ids);
	
	<S extends E> S save(S entity);
	
	<S extends E> Iterable<S> save(Iterable<S> entities);
	
	//E update (E e);
	
	//Iterable<E> update (Iterable<E> es);

	void delete(E entity);
}
