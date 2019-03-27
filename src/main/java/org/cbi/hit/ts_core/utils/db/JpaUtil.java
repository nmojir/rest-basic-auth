package org.cbi.hit.ts_core.utils.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	//entity manager factory is instantiated once in entire application
	private EntityManagerFactory emf;
	private static JpaUtil instance;
	
	private JpaUtil()
	{
		emf = Persistence.createEntityManagerFactory("mypu");
	}
	
	public static JpaUtil getInstance()
	{
		if(instance == null)
			instance = new JpaUtil();
		return instance;
	}
	
	public EntityManager createEntityManager()
	{
		return emf.createEntityManager();
	}
}
