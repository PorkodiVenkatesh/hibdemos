package com.revature.HibDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        User u1 = new User();
        u1.setId(2);
        u1.setName("Pooja");
        u1.setLocation("Nagpur");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
        
        SessionFactory  sessionFactory = con.buildSessionFactory();
      
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        session.save(u1);
        
        session.getTransaction().commit();
        session.close();
    }
}
