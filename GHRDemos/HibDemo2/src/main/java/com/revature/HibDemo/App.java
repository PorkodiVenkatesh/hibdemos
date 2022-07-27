package com.revature.HibDemo;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sessionFactory = con.buildSessionFactory();

		// ------------Session1----------------//
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		//CRUD operations
		//C -> Create
		//inserts a row to a table, from object
		session1.save(new User("Porkodi", "Chennai"));
		
		//R -> Read
		//list all the rows in the table
		Query query1 = session1.createQuery("FROM User");
		List<User> users = query1.list();
		
		for (User u : users) {
			System.out.println(u.id + " " + u.location + " " + u.name);
		}
	
		//U -> Update
		//to Update a row in the table
//		Query query2 = session1.createQuery("Update User SET name = :nameToUpdate where id = :idToUpdate");
//		query2.setParameter("nameToUpdate", "Shadid");
//		query2.setParameter("idToUpdate" , 4);
//		query2.executeUpdate();
		
		//D -> Delete
	 // to Delete a row
//		Query query3 = session1.createQuery("Delete User where id = :idToDelete");
//		query3.setParameter("idToDelete" , 4);
//		query3.executeUpdate();
		
		//namedQuery
		
		Query query4 = session1.getNamedQuery("ListUserByLocation").setParameter("locationToList", "pune");
		
		List<User> puneUsers = query4.list();
		
		for (User u : puneUsers) {
			System.out.println(u.id + " " + u.location + " " + u.name);
		}
		
		
		//sqlquery
		Query query5 = session1.createSQLQuery("select * from user_table");
		List<Object[]> rows = query5.list();
		
		for(Object[] row : rows){
			User u = new User();
			u.setId(Integer.parseInt(row[0].toString()));
			u.setName(row[1].toString());
			u.setLocation(row[2].toString());
			System.out.println(u.id + " " + u.location + " " + u.name);
		}
		
		
		session1.getTransaction().commit();
		session1.close();
		// ------------Session1----------------//

	}
}
