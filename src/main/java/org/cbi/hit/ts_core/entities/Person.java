package org.cbi.hit.ts_core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nationalCode;
	
	private String firstName;
	
	private String lastName;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getNationalCode()
	{
		return nationalCode;
	}

	public void setNationalCode(String nationalCode)
	{
		this.nationalCode = nationalCode;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	
}
