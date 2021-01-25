package com.inclined.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inclined.hibernate.demo.entity.Student;

public class QueryHibernateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {	
	
		// start transaction
		session.beginTransaction();
		
		List<Student> student1 = session.createQuery("from Student s where s.lastName='tiw'"
				+ " and s.firstName like '%as%'")
									.getResultList();
		
		for(Student stu: student1) {
			System.out.println("Student is : "+ stu);
		}
		
		System.out.println("Commited!");
		session.getTransaction().commit();
		
		}finally {
			factory.close();
		}
	}

}
