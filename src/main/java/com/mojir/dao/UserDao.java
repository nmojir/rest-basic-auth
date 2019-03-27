package com.mojir.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mojir.auth.entities.User;

public class UserDao extends GeneralDao {

	public UserDao(EntityManager entityManager) {
		super(entityManager);
	}
	
	@SuppressWarnings("unchecked")
	public User findByUsername(String username)
	{
		String queryStr = "SELECT u FROM User u"
				+ " WHERE u.username = :username";
		Query query = em.createQuery(queryStr);
		query.setParameter("username", username);		
		List<User> result = query.getResultList();
		if(result.size() == 0)
			return null;
		return result.get(0);
	}

}
