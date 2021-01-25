package com.inclined.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inclined.hibernate.demo.entity.Student;

public class StudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// making object to save
			Student student = new Student("Ashutosh","Tiwari","ashutosh3309@gmail.com");
			
			// start transaction
			session.beginTransaction();
			
			// save student to session
			session.save(student);
			
			//commit the transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
