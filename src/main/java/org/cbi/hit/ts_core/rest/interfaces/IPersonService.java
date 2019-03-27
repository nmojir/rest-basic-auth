package org.cbi.hit.ts_core.rest.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.cbi.hit.ts_core.entities.Person;
import org.cbi.hit.ts_core.exceptions.BusinessException;

@Path("/persons")
public interface IPersonService {
	@GET
	@Produces("application/json")
	@Path("/{id}")
	public Person getPerson(@PathParam("id") long id) throws BusinessException;
	
	
	@POST
	@Consumes("application/json")
	public Response createPerson(Person person) throws BusinessException;
	

	@PUT
	@Consumes("application/json")
	@Path("/{id}")
	public Response updatePerson(@PathParam("id") long id, Person person) throws BusinessException;
	
	@DELETE
	@Path("/{id}")
	public Response deletePerson(@PathParam("id") long id) throws BusinessException;
	
}
