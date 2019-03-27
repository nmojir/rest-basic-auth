package com.mojir.auth.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permission {
	@Id
	private int id;
	
	/**
	 * a colon delimited string like person:create
	 */
	private String perm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPerm() {
		return perm;
	}

	public void setPerm(String perm) {
		this.perm = perm;
	}
	
	
}
