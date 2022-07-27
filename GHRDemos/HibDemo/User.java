package com.revature.HibDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	//its my primary key 
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
	
	

}
