package com.revature.HibCriteria;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
public class User {
	@Id
	int id;
	String name;
	String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public User(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public User() {
		
	}
}
