package com.inclined.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inclined.hibernate.table.relations.Instructor;
import com.inclined.hibernate.table.relations.InstructorDetail;

public class HibernateRelationMain {
	
	static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(InstructorDetail.class)
			.buildSessionFactory();

	static Session session = factory.getCurrentSession();
	
	public static void main(String[] args) {
		
		Instructor instructor = new Instructor("carry", "Deol", "carry@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("Carry Minati","A Roasting Machine :|");
		instructor.setInstructorDetail(instructorDetail);
		
		// Session Start
		session.beginTransaction();
		
		session.save(instructor);
		
		//commit Transaction
		session.getTransaction().commit();
	}

}
