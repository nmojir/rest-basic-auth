package com.mojir.dao;

import javax.persistence.EntityManager;

public class GeneralDao {
	protected EntityManager em;	
	
	public GeneralDao(EntityManager entityManager)
	{
		this.em = entityManager;
		
	}
	
	public void create(Object entity)
	{
		em.persist(entity);
	}
	
	public <T> T find(Class<T> c, Object id)
	{
		return em.find(c, id);
	}
	
	public void update(Object entity)
	{
		em.merge(entity);
		em.flush();
	}
	
	public void delete(Object entity)
	{
		em.remove(entity);
	}
	
	
}
