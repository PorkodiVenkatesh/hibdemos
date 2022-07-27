package com.revature.HibCriteria;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.Criteria;
public class App 
{
    public static void main( String[] args )
    {

		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);

		SessionFactory sessionFactor = con.buildSessionFactory();

		Session session = sessionFactor.openSession();

		Transaction tr = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		
		//criteria.add(Restrictions.eq("id", 4));
		
	//	criteria.add(Restrictions.between("id", 2, 4));
		
		
	
		User u1 = new User(6,"john", "banglore");
		
		session.save(u1);
		
		//criteria.addOrder(Order.asc("name"));
		
		
		List<User> users = criteria.list();


			for (User user : users) {
				System.out.println(user.id + " " + user.name + " " + user.location);
			}
		tr.commit();

		session.close();
		
    }
}
