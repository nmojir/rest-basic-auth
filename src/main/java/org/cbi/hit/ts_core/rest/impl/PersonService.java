package org.cbi.hit.ts_core.rest.impl;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.cbi.hit.ts_core.entities.Person;
import org.cbi.hit.ts_core.exceptions.BusinessException;
import org.cbi.hit.ts_core.exceptions.InternalErrorException;
import org.cbi.hit.ts_core.exceptions.NotFoundException;
import org.cbi.hit.ts_core.rest.interfaces.IPersonService;
import org.cbi.hit.ts_core.utils.db.JpaUtil;

import com.mojir.dao.GeneralDao;


public class PersonService implements IPersonService {
	private EntityManager em;
	
	public PersonService()
	{
		//It is better to let containers like EJB handle these things.
		//But in this sample code I didn't want to make things complex!
		em = JpaUtil.getInstance().createEntityManager();
	}
	
	//Note that RequiresPermissions annotation do not work in the interface.
	//So I was forced to put it in the concrete class
	@RequiresPermissions("person:get")
	@Override
	public Person getPerson(long id) throws BusinessException
	{
		try 
		{
			return findPerson(id);			
		} 
		catch (BusinessException e) {
			throw e;
		}
		catch(Exception e)
		{
			e.printStackTrace(); //log it in a real project
			throw new InternalErrorException("Fetching person failed due to an internal error."
					+ " Please contact administrator for more information.");
		}
		finally
		{
			em.close();
		}
	}
	
	
	@RequiresPermissions("person:create")
	@Override
	public Response createPerson(Person person) throws BusinessException
	{		
		try
		{
			em.getTransaction().begin();
			GeneralDao dao = new GeneralDao(em);
			
			person.setId(0); //Creating new person so make sure id is not set

			dao.create(person);
			em.getTransaction().commit();
			
			return Response.status(Status.CREATED).entity(person).build();
		}
		catch(Exception e)
		{
			e.printStackTrace(); //log it in a real project
			em.getTransaction().rollback();
			throw new InternalErrorException("Creating person failed due to an internal error."
					+ " Please contact administrator for more information.");
		}
		finally
		{
			em.close();
		}
	}

	
	@RequiresPermissions("person:update")
	@Override
	public Response updatePerson(long personId, Person person) throws BusinessException 
	{
		try
		{		
			em.getTransaction().begin();
			GeneralDao dao = new GeneralDao(em);
			
			person.setId(personId);
			
			dao.update(person);
			
			em.getTransaction().commit();
			
			return Response.status(Status.OK).entity(person).build();
		}
		catch(Exception e)
		{
			e.printStackTrace(); //log it in a real project
			em.getTransaction().rollback();
			throw new InternalErrorException("Updating person failed due to an internal error."
					+ " Please contact administrator for more information.");
		}
		finally
		{
			em.close();
		}
	}
	
	
	private Person findPerson(long id) throws NotFoundException
	{
		GeneralDao dao = new GeneralDao(em);
		Person person = dao.find(Person.class, id);
		if(person == null)
			throw new NotFoundException("Person with ID " + id + " was not found");
		return person;
	}

	@Override
	@RequiresPermissions("person:delete")
	public Response deletePerson(long id) throws BusinessException
	{
		try
		{		
			em.getTransaction().begin();
			GeneralDao dao = new GeneralDao(em);
			
			Person toBeDeleted = findPerson(id);
			
			dao.delete(toBeDeleted);
			
			em.getTransaction().commit();
			
			return Response.status(Status.OK).build();
		}
		catch(BusinessException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			e.printStackTrace(); //log it in a real project
			em.getTransaction().rollback();
			throw new InternalErrorException("Deleting person failed due to an internal error."
					+ " Please contact administrator for more information.");
		}
		finally
		{
			em.close();
		}
	}
	
	
}
