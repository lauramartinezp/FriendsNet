package com.everis.alicante.courses.beca.summer17.friendsnet.manager;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.FNEntity;

public class AbstractManager<E extends FNEntity, ID extends Serializable> implements Manager<E, ID> {
	
private final Class<E> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractManager() {
		this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
	}
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		
		return this.entityManager;
	}

	@Override
	public Iterable<E> findAll() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(this.persistentClass);
		Root<E> rootEntry = cq.from(this.persistentClass);
		CriteriaQuery<E> all = cq.select(rootEntry);
		TypedQuery<E> allQuery = this.entityManager.createQuery(all);
		
		return allQuery.getResultList();
	}

	@Override
	public E findById(ID id) {
		return entityManager.find(persistentClass, id);
	}

	@Override
	public E save(E e) {
		entityManager.persist(e);
		return e;
	}

	@Override
	public Iterable<E> save(Iterable<E> es) {
		entityManager.persist(es);
		return es;
	}

	@Override
	public E update(E e) {
		entityManager.merge(e);
		return e;
	}

	@Override
	public Iterable<E> update(Iterable<E> es) {
		entityManager.merge(es);
		return es;
	}

	@Override
	public void remove(E e) {
		// TODO Auto-generated method stub
		
	}

}
