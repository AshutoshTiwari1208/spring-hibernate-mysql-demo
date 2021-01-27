package com.inclined.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inclined.hibernate.table.relations.Instructor;
import com.inclined.hibernate.table.relations.InstructorDetail;

public class HibernateRelationDelete {
	
	static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(InstructorDetail.class)
			.buildSessionFactory();

	static Session session = factory.getCurrentSession();
	
	public static void main(String[] args) {
				
		// Session Start
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, 1);
		System.out.println("Instructor received is ==> "+ instructor);
		
		if(instructor != null) {
			session.delete(instructor);
		}
		
		//commit Transaction
		session.getTransaction().commit();
	}

}
