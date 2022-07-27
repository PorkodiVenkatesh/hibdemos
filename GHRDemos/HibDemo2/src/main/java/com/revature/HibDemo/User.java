package com.revature.HibDemo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "user_table")
@NamedQuery(name = "ListUserByLocation", query = "FROM User where location = :locationToList")
public class User {
	//its my primary key 
	@Id
	@Column(name= "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	@Column(name = "user_name")
	String name;
	@Column(name = "user_location")
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
	
	public User() {
		
	}
	
	public User(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public User(String name, String location) {
		this.name = name;
		this.location = location;
	}

}
