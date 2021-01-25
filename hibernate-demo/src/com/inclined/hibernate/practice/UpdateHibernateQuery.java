package com.inclined.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inclined.hibernate.demo.entity.Student;

public class UpdateHibernateQuery {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {	
		// start transaction
		session.beginTransaction();
		
		Student student = session.get(Student.class, 1);
		
		
		session.createQuery("update Student s set s.email='temp123@gmail.com' where s.id=1").executeUpdate();
		

		 student = session.get(Student.class, 1);

		System.out.println("Student before : " + student);

		System.out.println("Commited!");
		session.getTransaction().commit();
		
		}finally {
			factory.close();
		}
	}

}
