package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import java.io.Serializable;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.EntityDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.FNEntity;

public abstract class AbstractManager<E extends FNEntity, ID extends Serializable> implements Manager<E, ID> {
	
	protected abstract EntityDAO<E, ID> getEntityDAO();
	

	@Override
	public Iterable<E> findAll(){
		return this.getEntityDAO().findAll();
	}

	@Override
	public E findOne(ID id) {
		return this.getEntityDAO().findOne(id);
	}
	
	@Override
	public Iterable<E> findAll(Iterable<ID> ids){
		return this.getEntityDAO().findAll(ids);
	}

	@Override
	public 	<S extends E> S save(S entity) {
		return this.getEntityDAO().save(entity);
	}

	@Override
	public <S extends E> Iterable<S> save(Iterable<S> entities) {
		return this.getEntityDAO().save(entities);
	}

	//@Override
	//public E update(E e) {
	//	return this.getEntityDAO().update(e);
	//}

	//@Override
	//public Iterable<E> update(Iterable<E> es) {
	//	return this.getEntityDAO().update(es);
	//}

	@Override
	public void delete(E entity){
		this.getEntityDAO().delete(entity);
	}

}
