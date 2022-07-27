package com.revature.HibDemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.*;

public class App 
{
	public static void main(String[] args) {
//        User u1 = new User();
//        u1.setId(6);
//        u1.setName("raghu");
//        u1.setLocation("chennai");

		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);

		SessionFactory sessionFactor = con.buildSessionFactory();

		Session session = sessionFactor.openSession();

		Transaction tr = session.beginTransaction();
		// session.save(u1);

//        Query query = session.createQuery("UPDATE User SET name = :user_name WHERE id = :user_id");
//        query.setParameter("user_name", "Porkodi");
//        query.setParameter("user_id", 1);
//        query.executeUpdate();
//        

//        Query query = session.createQuery("Delete from User WHERE id = :user_id");
//        query.setParameter("user_id", 6);
//        query.executeUpdate();

//        
//        Query query = session.createQuery("from User");
//        List<User> users = query.list();
//        
//        for (User user : users) {
//			System.out.println(user.id + " " + user.name+ " " + user.location);
//		}

	//	Query query = session.getNamedQuery("findUserByID").setParameter("id", 4);
		
	Query query = session.createQuery("from User");
		List<User> users = query.list();

		if (users.size() == 0) {
			System.out.println("ID is not present");
		} else {
			for (User user : users) {
				System.out.println(user.id + " " + user.name + " " + user.location);
			}
		}
		
       User user2 = session.get(User.class, 3);
		
		System.out.println(user2.id + " " + user2.name + " " + user2.location);
		
		User user3 = session.load(User.class, 3);
		
		System.out.println(user3.id + " " + user3.name + " " + user3.location);
		tr.commit();

		session.close();
//		
//		Session session1 = sessionFactor.openSession();
//		session1.beginTransaction();
//		
//		User user1 = session1.get(User.class, 1);
//		
//		System.out.println(user1.id + " " + user1.name + " " + user1.location);
//		
//		
//		
//				
//		session1.getTransaction().commit();
//		session1.close();
//		
//		
//		Session session2 = sessionFactor.openSession();
//		session2.beginTransaction();
//		
//		User user2 = session2.get(User.class, 1);
//		
//		System.out.println(user2.id + " " + user2.name + " " + user2.location);
//		
//				
//		session2.getTransaction().commit();
//		session2.close();

	}
}
